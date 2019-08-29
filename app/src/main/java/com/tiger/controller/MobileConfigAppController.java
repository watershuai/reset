/*     */ package com.tiger.controller;
/*     */ 
/*     */ import com.tiger.formbean.MakeMobileConfigForm;
/*     */ import com.tiger.pojo.Account;
/*     */ import com.tiger.pojo.MobileConfigApp;
/*     */ import com.tiger.pojo.MobileConfigAppOrder;
/*     */ import com.tiger.service.AccountService;
/*     */ import com.tiger.service.MobileConfigAppOrderService;
/*     */ import com.tiger.service.MobileConfigAppService;
/*     */ import com.tiger.utils.MobileConfigUtil;
/*     */ import com.yz.common.core.exception.HandlerException;
/*     */ import com.yz.common.core.utils.DateUtils;
/*     */ import com.yz.common.core.utils.FileUtils;
/*     */ import com.yz.common.core.utils.SnowflakeIdWorker;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.validation.annotation.Validated;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import sun.misc.BASE64Encoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class MobileConfigAppController
/*     */ {
/*  43 */   private static final Logger logger = LoggerFactory.getLogger(PayController.class);
/*     */   
/*     */   public static final String CHARSET = "utf-8";
/*     */   public static final String FORMAT = "JSON";
/*     */   @Value("${alipay.signType}")
/*  48 */   public String SIGN_TYPE = "";
/*     */   @Value("${alipay.appId}")
/*  50 */   public String APP_ID = "";
/*     */   @Value("${alipay.publicKey}")
/*  52 */   public String ALIPAY_PUBLIC_KEY = "";
/*     */   @Value("${alipay.app.privateKey}")
/*  54 */   public String APP_PRIVATE_KEY = "";
/*     */   
/*     */ 
/*     */   @Value("${sys.fileupload.path}")
/*     */   private String fileUploadPath;
/*     */   
/*     */   @Value("${server.hostName}")
/*     */   private String serverHost;
/*     */   
/*     */   @Value("${ssl.cert.path}")
/*     */   private String sslCertPath;
/*     */   
/*     */   @Value("${ssl.privkey.path}")
/*     */   private String sslPrivkeyPath;
/*     */   
/*     */   @Value("${ssl.fullchain.path}")
/*     */   private String sslFullchainpath;
/*     */   
/*     */   @Resource
/*     */   private MobileConfigAppService mobileConfigAppService;
/*     */   
/*     */   @Resource
/*     */   private AccountService accountService;
/*     */   
/*     */   @Resource
/*     */   private MobileConfigAppOrderService mobileConfigAppOrderService;
/*     */   
/*  81 */   private Map<Integer, Integer> mobileConfigAppGoodsPrice = new HashMap();
/*     */   
/*     */   @PostConstruct
/*     */   public void init() {
/*  85 */     this.mobileConfigAppGoodsPrice.put(Integer.valueOf(180), Integer.valueOf(150000));
/*  86 */     this.mobileConfigAppGoodsPrice.put(Integer.valueOf(365), Integer.valueOf(200000));
/*  87 */     this.mobileConfigAppGoodsPrice.put(Integer.valueOf(9999), Integer.valueOf(300000));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/auth/mobileconfig/make"})
/*     */   public Object makeMobileConfig(HttpServletRequest request, @RequestParam MultipartFile iconFile, @Validated MakeMobileConfigForm makeMobileConfigForm) throws Exception {
/*  92 */     Account account = (Account)request.getAttribute("account");
/*     */     
/*  94 */     int day = makeMobileConfigForm.getDay();
/*  95 */     Integer price = (Integer)this.mobileConfigAppGoodsPrice.get(Integer.valueOf(day));
/*  96 */     if (price == null) {
/*  97 */       throw new HandlerException(36, "请求参数异常");
/*     */     }
/*     */     
/* 100 */     account = (Account)this.accountService.selectById(Long.valueOf(account.getId().longValue()));
/*     */     
/* 102 */     File file = new File(this.fileUploadPath + "mobileconfig/icon");
/* 103 */     if (!file.exists()) {
/* 104 */       file.mkdirs();
/*     */     }
/*     */     
/* 107 */     MobileConfigUtil mobileConfigUtil = new MobileConfigUtil();
/* 108 */     mobileConfigUtil.setDisplayName(makeMobileConfigForm.getAppName());
/* 109 */     BASE64Encoder base64Encoder = new BASE64Encoder();
/* 110 */     String encode = base64Encoder.encode(iconFile.getBytes());
/* 111 */     mobileConfigUtil.setIcon(encode);
/* 112 */     mobileConfigUtil.setWebUrl(makeMobileConfigForm.getAppUrl());
/* 113 */     if (makeMobileConfigForm.getAllowDelete() == 0) {
/* 114 */       mobileConfigUtil.setAllowDelete(false);
/*     */     }
/* 116 */     String s = mobileConfigUtil.create();
/*     */     
/* 118 */     String mobileConfigFileName = System.currentTimeMillis() + ".mobileconfig";
/* 119 */     File mobileConfigFile = new File(this.fileUploadPath + "mobileconfig/" + mobileConfigFileName);
/* 120 */     FileUtils.writeStringToFile(mobileConfigFile, s);
/* 121 */     String configFilePath = mobileConfigFile.getPath();
/*     */     
/* 123 */     String signMobileConfigFileName = SnowflakeIdWorker.generateId() + ".mobileconfig";
/* 124 */     Process exec = Runtime.getRuntime().exec("openssl smime -sign -in " + configFilePath + " -out " + this.fileUploadPath + "mobileconfig/" + signMobileConfigFileName + " -signer " + this.sslCertPath + " -inkey " + this.sslPrivkeyPath + " -certfile " + this.sslFullchainpath + " -outform der -nodetach");
/* 125 */     exec.waitFor();
/*     */     
/* 127 */     String iconFileName = iconFile.getOriginalFilename();
/* 128 */     String iconFilePath = this.fileUploadPath + "/mobileconfig/icon/" + iconFileName;
/* 129 */     iconFile.transferTo(new File(iconFilePath));
/*     */     
/* 131 */     MobileConfigApp mobileConfigApp = new MobileConfigApp();
/* 132 */     mobileConfigApp.setUserId(Long.valueOf(account.getId().longValue()));
/* 133 */     mobileConfigApp.setMobileConfigUrl(this.serverHost + "/mobileconfig/" + signMobileConfigFileName);
/* 134 */     mobileConfigApp.setIconUrl(this.serverHost + "/mobileconfig/icon/" + iconFileName);
/* 135 */     mobileConfigApp.setAppName(makeMobileConfigForm.getAppName());
/* 136 */     Calendar calendar = Calendar.getInstance();
/* 137 */     Date time = calendar.getTime();
/* 138 */     calendar.add(5, makeMobileConfigForm.getDay());
/* 139 */     Date expireTime = calendar.getTime();
/* 140 */     mobileConfigApp.setExpireTime(expireTime);
/* 141 */     mobileConfigApp.setCreateTime(time);
/* 142 */     mobileConfigApp.setUpdateTime(time);
/* 143 */     mobileConfigApp.setStatus(Integer.valueOf(0));
/* 144 */     boolean insert = this.mobileConfigAppService.insert(mobileConfigApp);
/*     */     
/* 146 */     if (!insert) {
/* 147 */       throw new HandlerException(32, "生成描述文件失败");
/*     */     }
/*     */     
/* 150 */     mobileConfigFile.delete();
/*     */     
/*     */ 
/* 153 */     String orderNum = DateUtils.FormatDate(new Date(), "yyyyMMddhhmmss").concat(String.valueOf((int)((Math.random() * 9.0D + 1.0D) * 1000.0D)));
/*     */     
/* 155 */     MobileConfigAppOrder mobileConfigAppOrder = new MobileConfigAppOrder();
/* 156 */     mobileConfigAppOrder.setOrderNum(orderNum);
/* 157 */     mobileConfigAppOrder.setMobileconfigAppId(mobileConfigApp.getId());
/* 158 */     mobileConfigAppOrder.setOrderStatus(Integer.valueOf(0));
/* 159 */     mobileConfigAppOrder.setPayWay(Integer.valueOf(0));
/* 160 */     mobileConfigAppOrder.setUserId(Long.valueOf(account.getId().longValue()));
/* 161 */     mobileConfigAppOrder.setPrice(price);
/* 162 */     mobileConfigAppOrder.setOrderDesc("在线描述文件制作");
/* 163 */     mobileConfigAppOrder.setCreateTime(new Date());
/*     */     
/* 165 */     insert = this.mobileConfigAppOrderService.insert(mobileConfigAppOrder);
/*     */     
/* 167 */     if (!insert) {
/* 168 */       throw new HandlerException(32, "添加订单失败");
/*     */     }
/* 170 */     return mobileConfigAppOrder;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/auth/mobileconfig/app/upload"})
/*     */   public Object mobileConfigAppUpload(HttpServletRequest request, MultipartFile mobileConfigFile, MultipartFile iconFile, @RequestParam String appName) throws IOException {
/* 175 */     Account account = (Account)request.getAttribute("account");
/*     */     
/* 177 */     File file = new File(this.fileUploadPath + "mobileconfig/icon");
/* 178 */     if (!file.exists()) {
/* 179 */       file.mkdirs();
/*     */     }
/*     */     
/* 182 */     String mobileConfigFileName = System.currentTimeMillis() + ".mobileconfig";
/* 183 */     String mobileConfigFilePath = this.fileUploadPath + "/mobileconfig/" + mobileConfigFileName;
/* 184 */     mobileConfigFile.transferTo(new File(mobileConfigFilePath));
/*     */     
/* 186 */     String iconFileName = iconFile.getOriginalFilename();
/* 187 */     String iconFilePath = this.fileUploadPath + "/mobileconfig/icon/" + iconFileName;
/* 188 */     iconFile.transferTo(new File(iconFilePath));
/*     */     
/* 190 */     MobileConfigApp mobileConfigApp = new MobileConfigApp();
/* 191 */     mobileConfigApp.setUserId(Long.valueOf(account.getId().longValue()));
/* 192 */     mobileConfigApp.setMobileConfigUrl(this.serverHost + "/mobileconfig/" + mobileConfigFileName);
/* 193 */     mobileConfigApp.setIconUrl(this.serverHost + "/mobileconfig/icon/" + iconFileName);
/* 194 */     mobileConfigApp.setAppName(appName);
/* 195 */     mobileConfigApp.setStatus(Integer.valueOf(1));
/* 196 */     Date date = new Date();
/* 197 */     mobileConfigApp.setCreateTime(date);
/* 198 */     mobileConfigApp.setUpdateTime(date);
/* 199 */     boolean insert = this.mobileConfigAppService.insert(mobileConfigApp);
/* 200 */     return Boolean.valueOf(insert);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/auth/mobileconfig/app/list"})
/*     */   public Object mobileConfigAppList(HttpServletRequest request) {
/* 205 */     Account account = (Account)request.getAttribute("account");
/* 206 */     MobileConfigApp mobileConfigApp = new MobileConfigApp();
/* 207 */     mobileConfigApp.setUserId(Long.valueOf(account.getId().longValue()));
/* 208 */     mobileConfigApp.setStatus(Integer.valueOf(1));
/* 209 */     List<MobileConfigApp> mobileConfigApps = this.mobileConfigAppService.selectList(mobileConfigApp);
/* 210 */     return mobileConfigApps;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/auth/mobileconfig/app/update"})
/*     */   public Object mobileConfigAppUpdate(HttpServletRequest request, @RequestParam MultipartFile mobileConfigFile, @RequestParam Long mobileConfigId) throws Exception {
/* 215 */     Account account = (Account)request.getAttribute("account");
/* 216 */     MobileConfigApp mobileConfigApp = new MobileConfigApp();
/* 217 */     mobileConfigApp.setId(mobileConfigId);
/* 218 */     mobileConfigApp.setUserId(Long.valueOf(account.getId().longValue()));
/*     */     
/* 220 */     mobileConfigApp = (MobileConfigApp)this.mobileConfigAppService.selectOne(mobileConfigApp);
/*     */     
/* 222 */     if (mobileConfigApp == null) {
/* 223 */       throw new HandlerException(11, "应该不存在");
/*     */     }
/*     */     
/* 226 */     String mobileConfigFileName = System.currentTimeMillis() + ".mobileconfig";
/* 227 */     String mobileConfigFilePath = this.fileUploadPath + "/mobileconfig/" + mobileConfigFileName;
/* 228 */     mobileConfigFile.transferTo(new File(mobileConfigFilePath));
/* 229 */     MobileConfigApp mca = new MobileConfigApp();
/* 230 */     mca.setId(mobileConfigId);
/* 231 */     mca.setMobileConfigUrl(this.serverHost + "/mobileconfig/" + mobileConfigFileName);
/* 232 */     mobileConfigApp.setUpdateTime(new Date());
/* 233 */     boolean update = this.mobileConfigAppService.update(mobileConfigApp);
/* 234 */     return Boolean.valueOf(update);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/auth/mobileconfig/app/delete"})
/*     */   public Object mobileConfigAppDelete(HttpServletRequest request, @RequestParam Long mobileConfigId) throws Exception {
/* 239 */     Account account = (Account)request.getAttribute("account");
/* 240 */     MobileConfigApp mobileConfigApp = new MobileConfigApp();
/* 241 */     mobileConfigApp.setId(mobileConfigId);
/* 242 */     mobileConfigApp.setUserId(Long.valueOf(account.getId().longValue()));
/* 243 */     mobileConfigApp = (MobileConfigApp)this.mobileConfigAppService.selectOne(mobileConfigApp);
/* 244 */     if (mobileConfigApp == null) {
/* 245 */       throw new HandlerException(11, "应该不存在");
/*     */     }
/* 247 */     boolean b = this.mobileConfigAppService.deleteById(mobileConfigId);
/* 248 */     return Boolean.valueOf(b);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/app/download/mobileconfig/{id}"})
/*     */   public Object mobileConfigApp(@PathVariable(name="id") Long id, HttpServletRequest request) throws HandlerException {
/* 253 */     MobileConfigApp mobileConfigApp = new MobileConfigApp();
/* 254 */     mobileConfigApp.setId(id);
/* 255 */     mobileConfigApp = (MobileConfigApp)this.mobileConfigAppService.selectOne(mobileConfigApp);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 266 */     Long downloadNum = mobileConfigApp.getDownloadNum();
/* 267 */     MobileConfigApp mca = new MobileConfigApp();
/* 268 */     mca.setId(mobileConfigApp.getId());
/* 269 */     mca.setDownloadNum(Long.valueOf(downloadNum.longValue() + 1L));
/* 270 */     this.mobileConfigAppService.update(mca);
/* 271 */     return mobileConfigApp.getMobileConfigUrl();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\MobileConfigAppController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */