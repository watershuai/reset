 package com.tiger.controller;
 
 import com.tiger.builder.PayDirector;
 import com.tiger.enums.PayEnum;
 import com.tiger.pojo.Account;
 import com.tiger.pojo.AutoSignApp;
 import com.tiger.pojo.AutoSignMeal;
 import com.tiger.pojo.AutoSignMealType;
 import com.tiger.pojo.AutoSignOrder;
 import com.tiger.pojo.MobileConfigAppOrder;
 import com.tiger.pojo.PayOrder;
 import com.tiger.service.AutoSignAppService;
 import com.tiger.service.AutoSignMealService;
 import com.tiger.service.AutoSignOrderService;
 import com.tiger.service.MobileConfigAppOrderService;
 import com.tiger.service.PayService;
 import com.tiger.service.impl.AliPayService;
 import com.tiger.service.impl.AliPayService;
 import com.yz.common.core.exception.HandlerException;
 import com.yz.common.core.utils.DateUtils;
 import com.yz.common.pay.bean.WXCreateOrderParams;
 import com.yz.common.pay.service.IPay;
 import com.yz.common.pay.service.PayFactory;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;
 import javax.annotation.PostConstruct;
 import javax.annotation.Resource;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.validation.constraints.Min;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 
 @org.springframework.web.bind.annotation.RestController
 @org.springframework.validation.annotation.Validated
 public class PayController
 {
   private static final Logger logger = LoggerFactory.getLogger(PayController.class);
   
   @Value("${server.hostName}")
   private String serverHostName;
   
   @Resource
   private PayService payService;
   
   @Resource
   private AutoSignOrderService autoSignOrderService;
   
   @Resource
   private AutoSignAppService autoSignAppService;
   
   @Resource
   private AutoSignMealService autoSignMealService;
   
   @Resource
   private AliPayService aliPayService;
   
   @Resource
   private MobileConfigAppOrderService mobileConfigAppOrderService;
   
/*  65 */   private Map<Integer, Integer> autoSignUpdateNumPrice = new HashMap();
   
   @PostConstruct
   public void init() {
/*  69 */     this.autoSignUpdateNumPrice.put(Integer.valueOf(1), Integer.valueOf(50));
/*  70 */     this.autoSignUpdateNumPrice.put(Integer.valueOf(5), Integer.valueOf(200));
/*  71 */     this.autoSignUpdateNumPrice.put(Integer.valueOf(10), Integer.valueOf(300));
   }
   
   @RequestMapping({"/auth/pay/down_num"})
   public Object payDownNum(HttpServletRequest request, @RequestParam String orderNum, @RequestParam(required=false, defaultValue="1") int payWay, HttpServletResponse response) throws HandlerException {
/*  76 */     PayOrder payOrder = new PayOrder();
/*  77 */     payOrder.setOrderId(orderNum);
/*  78 */     payOrder = (PayOrder)this.payService.selectOne(payOrder);
     
/*  80 */     if (payOrder == null) {
/*  81 */       throw new HandlerException(39, "订单不存在");
     }
     
/*  84 */     PayOrder payOrder1 = new PayOrder();
/*  85 */     payOrder1.setId(payOrder.getId());
/*  86 */     payOrder1.setPayWay(Integer.valueOf(payWay));
/*  87 */     this.payService.update(payOrder1);
     
/*  89 */     String orderId = payOrder.getOrderId();
     
/*  91 */     if (payWay == PayEnum.WX.getCode()) {
/*  92 */       WXCreateOrderParams wxCreateOrderParams = new WXCreateOrderParams();
/*  93 */       wxCreateOrderParams.setNotifyUrl(this.serverHostName + "/wxpay/downNum/notifay");
/*  94 */       wxCreateOrderParams.setBody(payOrder.getGoodsName());
/*  95 */       wxCreateOrderParams.setOutTradeNo(orderId);
/*  96 */       wxCreateOrderParams.setSpbillCreateIp("114.113.63.84");
/*  97 */       wxCreateOrderParams.setTradeType("NATIVE");
/*  98 */       HashMap<String, String> attach = new HashMap();
/*  99 */       attach.put("orderId", orderId);
/* 100 */       wxCreateOrderParams.setAttach(attach);
/* 101 */       wxCreateOrderParams.setTotalFee(payOrder.getGoodsPrice().intValue() / 100.0D);
/* 102 */       IPay iPay = new PayFactory().init(1);
       
/* 104 */       Map<String, Object> data = (Map)iPay.createOrder(wxCreateOrderParams);
/* 105 */       if (data == null) {
/* 106 */         throw new HandlerException(32, "充值失败！请重新尝试");
       }
/* 108 */       return data;
     }
     
/* 111 */     if (payWay == PayEnum.ALI.getCode()) {
/* 112 */       AliPayService.CreateOrderParam createOrderParam = new AliPayService.CreateOrderParam();
/* 113 */       double money = payOrder.getGoodsPrice().intValue() / 100.0D;
/* 114 */       createOrderParam.setTotalAmount(money);
/* 115 */       createOrderParam.setOutTradeNo(orderNum);
/* 116 */       createOrderParam.setNotifyUrl(this.serverHostName + "/alipay/downNum/notifay");
/* 117 */       createOrderParam.setReturnUrl(this.serverHostName + "/#/apps");
/* 118 */       createOrderParam.setPassbackParams(orderId);
/* 119 */       createOrderParam.setSubject(payOrder.getGoodsName());
/* 120 */       String form = (String)PayDirector.build().getALiPay().createOrder(createOrderParam);
/* 121 */       return form;
     }
     
/* 124 */     return "";
   }
   
   @RequestMapping({"/auth/vip/pay"})
   public Object vipPay(HttpServletRequest request, @RequestParam String orderNum, @RequestParam(required=false, defaultValue="1") int payWay, HttpServletResponse response) throws HandlerException
   {
/* 130 */     PayOrder payOrder = new PayOrder();
/* 131 */     payOrder.setOrderId(orderNum);
/* 132 */     payOrder = (PayOrder)this.payService.selectOne(payOrder);
     
/* 134 */     if (payOrder == null) {
/* 135 */       throw new HandlerException(39, "订单不存在");
     }
     
/* 138 */     PayOrder payOrder1 = new PayOrder();
/* 139 */     payOrder1.setId(payOrder.getId());
/* 140 */     payOrder1.setPayWay(Integer.valueOf(payWay));
/* 141 */     this.payService.update(payOrder1);
     
/* 143 */     String orderId = payOrder.getOrderId();
/* 144 */     if (payWay == 1) {
/* 145 */       WXCreateOrderParams wxCreateOrderParams = new WXCreateOrderParams();
/* 146 */       wxCreateOrderParams.setNotifyUrl(this.serverHostName + "/wxpay/vip/notifay");
/* 147 */       wxCreateOrderParams.setBody(payOrder.getGoodsName());
/* 148 */       wxCreateOrderParams.setOutTradeNo(orderId);
/* 149 */       wxCreateOrderParams.setSpbillCreateIp("114.113.63.84");
/* 150 */       wxCreateOrderParams.setTradeType("NATIVE");
/* 151 */       HashMap<String, String> attach = new HashMap();
/* 152 */       attach.put("orderId", orderId);
/* 153 */       wxCreateOrderParams.setAttach(attach);
/* 154 */       wxCreateOrderParams.setTotalFee(payOrder.getGoodsPrice().intValue() / 100.0D);
/* 155 */       IPay iPay = new PayFactory().init(1);
       
/* 157 */       Map<String, Object> data = (Map)iPay.createOrder(wxCreateOrderParams);
/* 158 */       if (data == null) {
/* 159 */         throw new HandlerException(32, "充值失败！请重新尝试");
       }
/* 161 */       return data; }
/* 162 */     if (payWay == 2) {
/* 163 */       AliPayService.CreateOrderParam createOrderParam = new AliPayService.CreateOrderParam();
/* 164 */       double money = payOrder.getGoodsPrice().intValue() / 100.0D;
/* 165 */       createOrderParam.setTotalAmount(money);
/* 166 */       createOrderParam.setOutTradeNo(orderNum);
/* 167 */       createOrderParam.setNotifyUrl(this.serverHostName + "/alipay/vip/notifay");
/* 168 */       createOrderParam.setReturnUrl(this.serverHostName + "/#/apps");
/* 169 */       createOrderParam.setPassbackParams(orderId);
/* 170 */       createOrderParam.setSubject(payOrder.getGoodsName());
/* 171 */       String form = (String)PayDirector.build().getALiPay().createOrder(createOrderParam);
/* 172 */       return form;
     }
/* 174 */     return "";
   }
   
   @RequestMapping({"/auth/auto/sign/pay"})
   public Object autoSignPay(HttpServletRequest request, @RequestParam String orderNum, @RequestParam(required=false, defaultValue="1") int payWay, HttpServletResponse response) throws HandlerException
   {
/* 180 */     AutoSignOrder autoSignOrder = new AutoSignOrder();
/* 181 */     autoSignOrder.setOrderNum(orderNum);
/* 182 */     autoSignOrder = (AutoSignOrder)this.autoSignOrderService.selectOne(autoSignOrder);
/* 183 */     if (autoSignOrder == null) {
/* 184 */       throw new HandlerException(39, "订单不存在");
     }
     
/* 187 */     AutoSignOrder autoSignOrder1 = new AutoSignOrder();
/* 188 */     autoSignOrder1.setId(autoSignOrder.getId());
/* 189 */     autoSignOrder1.setPayWay(Integer.valueOf(payWay));
/* 190 */     this.autoSignOrderService.update(autoSignOrder1);
     
/* 192 */     if (payWay == 1) {
/* 193 */       WXCreateOrderParams wxCreateOrderParams = new WXCreateOrderParams();
/* 194 */       wxCreateOrderParams.setNotifyUrl(this.serverHostName + "/autoSign/wxPay/notify");
/* 195 */       wxCreateOrderParams.setBody(autoSignOrder.getOrderDesc());
/* 196 */       wxCreateOrderParams.setOutTradeNo(orderNum);
/* 197 */       wxCreateOrderParams.setSpbillCreateIp("114.113.63.84");
/* 198 */       wxCreateOrderParams.setTradeType("NATIVE");
/* 199 */       HashMap<String, String> attach = new HashMap();
/* 200 */       attach.put("taskNum", autoSignOrder.getTaskNum().toString());
/* 201 */       wxCreateOrderParams.setAttach(attach);
/* 202 */       wxCreateOrderParams.setTotalFee(autoSignOrder.getPrice().intValue() / 1.0D);
/* 203 */       IPay iPay = new PayFactory().init(1);
       
/* 205 */       Map<String, Object> data = (Map)iPay.createOrder(wxCreateOrderParams);
/* 206 */       if (data == null) {
/* 207 */         throw new HandlerException(32, "充值失败！请重新尝试");
       }
/* 209 */       return data; }
/* 210 */     if (payWay == 2) {
/* 211 */       AliPayService.CreateOrderParam createOrderParam = new AliPayService.CreateOrderParam();
/* 212 */       double money = autoSignOrder.getPrice().intValue() / 1.0D;
/* 213 */       createOrderParam.setTotalAmount(money);
/* 214 */       createOrderParam.setOutTradeNo(orderNum);
/* 215 */       createOrderParam.setNotifyUrl(this.serverHostName + "/autoSign/aliPay/notify");
/* 216 */       createOrderParam.setReturnUrl(this.serverHostName + "/#/sign/manager");
/* 217 */       createOrderParam.setPassbackParams(orderNum);
/* 218 */       createOrderParam.setSubject(autoSignOrder.getOrderDesc());
/* 219 */       String form = (String)PayDirector.build().getALiPay().createOrder(createOrderParam);
/* 220 */       return form;
     }
/* 222 */     return "";
   }
   
   @RequestMapping({"/auth/pay/auto/sign/update/num"})
   public Object paySignUpdateNum(HttpServletRequest request, @RequestParam Long autoSignAppId, @Min(value=1L, message="输入最小数字为1") Integer num, @RequestParam(required=false, defaultValue="1") int payWay) throws HandlerException {
/* 227 */     Account account = (Account)request.getAttribute("account");
/* 228 */     String orderNum = DateUtils.FormatDate(new Date(), "yyyyMMddhhmmss").concat(String.valueOf((int)((Math.random() * 9.0D + 1.0D) * 1000.0D)));
/* 229 */     AutoSignOrder autoSignOrder = new AutoSignOrder();
/* 230 */     autoSignOrder.setUserId(Long.valueOf(account.getId().longValue()));
/* 231 */     autoSignOrder.setOrderNum(orderNum);
/* 232 */     autoSignOrder.setAutoSignAppId(autoSignAppId);
     
/* 234 */     Integer price = (Integer)this.autoSignUpdateNumPrice.get(num);
/* 235 */     if (price == null) {
/* 236 */       throw new HandlerException(31, "商品不存在");
     }
     
/* 239 */     autoSignOrder.setPrice(price);
/* 240 */     autoSignOrder.setOrderDesc(price + "元 购买更新" + num + "次");
/* 241 */     autoSignOrder.setBusinessData(num + "");
/* 242 */     autoSignOrder.setCreateTime(new Date());
     
/* 244 */     boolean insert = this.autoSignOrderService.insert(autoSignOrder);
/* 245 */     if (!insert) {
/* 246 */       throw new HandlerException(35, "订单创建失败");
     }
/* 248 */     if (payWay == 1) {
/* 249 */       WXCreateOrderParams wxCreateOrderParams = new WXCreateOrderParams();
/* 250 */       wxCreateOrderParams.setNotifyUrl(this.serverHostName + "/wxPay/autoSign/updateNum/notify");
/* 251 */       wxCreateOrderParams.setBody(autoSignOrder.getOrderDesc());
/* 252 */       wxCreateOrderParams.setOutTradeNo(orderNum);
/* 253 */       wxCreateOrderParams.setSpbillCreateIp("114.113.63.84");
/* 254 */       wxCreateOrderParams.setTradeType("NATIVE");
/* 255 */       HashMap<String, String> attach = new HashMap();
/* 256 */       attach.put("updateNum", num + "");
/* 257 */       wxCreateOrderParams.setAttach(attach);
/* 258 */       wxCreateOrderParams.setTotalFee(30 * num.intValue() / 1.0D);
/* 259 */       IPay iPay = new PayFactory().init(1);
       
/* 261 */       Map<String, Object> data = (Map)iPay.createOrder(wxCreateOrderParams);
/* 262 */       if (data == null) {
/* 263 */         throw new HandlerException(32, "充值失败！请重新尝试");
       }
/* 265 */       return data; }
/* 266 */     if (payWay == 2) {
/* 267 */       AliPayService.CreateOrderParam createOrderParam = new AliPayService.CreateOrderParam();
/* 268 */       double money = autoSignOrder.getPrice().intValue() / 1.0D;
/* 269 */       createOrderParam.setTotalAmount(money);
/* 270 */       createOrderParam.setOutTradeNo(orderNum);
/* 271 */       createOrderParam.setNotifyUrl(this.serverHostName + "/aliPay/autoSign/updateNum/notify");
/* 272 */       createOrderParam.setReturnUrl(this.serverHostName + "/#/sign/manager");
/* 273 */       createOrderParam.setPassbackParams(orderNum);
/* 274 */       createOrderParam.setSubject(autoSignOrder.getOrderDesc());
/* 275 */       String form = (String)PayDirector.build().getALiPay().createOrder(createOrderParam);
/* 276 */       return form;
     }
/* 278 */     return "";
   }
   
   @RequestMapping({"/auth/pay/auto/sign/delay"})
   public Object autoSignDelay(HttpServletRequest request, @RequestParam Long autoSignAppId, @RequestParam Integer day, @RequestParam(required=false, defaultValue="1") int payWay) throws HandlerException {
/* 283 */     Account account = (Account)request.getAttribute("account");
     
/* 285 */     AutoSignApp autoSignApp = (AutoSignApp)this.autoSignAppService.selectById(autoSignAppId);
/* 286 */     Integer mealId = autoSignApp.getMealId();
/* 287 */     AutoSignMeal autoSignMeal = (AutoSignMeal)this.autoSignMealService.selectById(Long.valueOf(mealId.longValue()));
/* 288 */     Integer mealTypeId = autoSignMeal.getMealTypeId();
/* 289 */     autoSignMeal = new AutoSignMeal();
/* 290 */     autoSignMeal.setMealTypeId(mealTypeId);
/* 291 */     autoSignMeal.setEffectiveDays(day);
/* 292 */     autoSignMeal = (AutoSignMeal)this.autoSignMealService.selectOne(autoSignMeal);
/* 293 */     if (autoSignMeal == null) {
/* 294 */       throw new HandlerException(36, "参数有误");
     }
     
/* 297 */     AutoSignApp autoSignApp1 = new AutoSignApp();
/* 298 */     autoSignApp1.setId(autoSignAppId);
/* 299 */     autoSignApp1.setMealId(autoSignMeal.getId());
/* 300 */     boolean update = this.autoSignAppService.update(autoSignApp1);
/* 301 */     if (!update) {
/* 302 */       throw new HandlerException(12, "续费失败，请重新尝试");
     }
     
/* 305 */     Integer mealPrice = autoSignMeal.getMealPrice();
     
/* 307 */     AutoSignMealType autoSignMealType = this.autoSignMealService.getAutoSignMealTypeById(autoSignMeal.getMealTypeId());
     
/* 309 */     String orderNum = DateUtils.FormatDate(new Date(), "yyyyMMddhhmmss").concat(String.valueOf((int)((Math.random() * 9.0D + 1.0D) * 1000.0D)));
/* 310 */     AutoSignOrder autoSignOrder = new AutoSignOrder();
/* 311 */     autoSignOrder.setUserId(Long.valueOf(account.getId().longValue()));
/* 312 */     autoSignOrder.setOrderNum(orderNum);
/* 313 */     autoSignOrder.setAutoSignAppId(autoSignAppId);
/* 314 */     autoSignOrder.setPrice(mealPrice);
/* 315 */     autoSignOrder.setOrderDesc(autoSignMeal.getMealPrice() + "元 " + autoSignMealType.getMealName() + " " + autoSignMeal.getEffectiveDays() + "天 续费");
/* 316 */     autoSignOrder.setCreateTime(new Date());
     
/* 318 */     boolean insert = this.autoSignOrderService.insert(autoSignOrder);
/* 319 */     if (!insert) {
/* 320 */       throw new HandlerException(35, "订单创建失败");
     }
/* 322 */     if (payWay == 1) {
/* 323 */       WXCreateOrderParams wxCreateOrderParams = new WXCreateOrderParams();
/* 324 */       wxCreateOrderParams.setNotifyUrl(this.serverHostName + "/wxPay/autoSign/delay/notify");
/* 325 */       wxCreateOrderParams.setBody(autoSignOrder.getOrderDesc());
/* 326 */       wxCreateOrderParams.setOutTradeNo(orderNum);
/* 327 */       wxCreateOrderParams.setSpbillCreateIp("114.113.63.84");
/* 328 */       wxCreateOrderParams.setTradeType("NATIVE");
/* 329 */       HashMap<String, String> attach = new HashMap();
/* 330 */       wxCreateOrderParams.setAttach(attach);
/* 331 */       wxCreateOrderParams.setTotalFee(mealPrice.intValue() / 1.0D);
/* 332 */       IPay iPay = new PayFactory().init(1);
       
/* 334 */       Map<String, Object> data = (Map)iPay.createOrder(wxCreateOrderParams);
/* 335 */       if (data == null) {
/* 336 */         throw new HandlerException(32, "充值失败！请重新尝试");
       }
/* 338 */       return data; }
/* 339 */     if (payWay == 2) {
/* 340 */       AliPayService.CreateOrderParam createOrderParam = new AliPayService.CreateOrderParam();
/* 341 */       double money = autoSignOrder.getPrice().intValue() / 1.0D;
/* 342 */       createOrderParam.setTotalAmount(money);
/* 343 */       createOrderParam.setOutTradeNo(orderNum);
/* 344 */       createOrderParam.setNotifyUrl(this.serverHostName + "/aliPay/autoSign/delay/notify");
/* 345 */       createOrderParam.setReturnUrl(this.serverHostName + "/#/sign/manager");
/* 346 */       createOrderParam.setPassbackParams(orderNum);
/* 347 */       createOrderParam.setSubject(autoSignOrder.getOrderDesc());
/* 348 */       String form = (String)PayDirector.build().getALiPay().createOrder(createOrderParam);
/* 349 */       return form;
     }
/* 351 */     return "";
   }
   
   @RequestMapping({"/auth/mobileconfig/make/pay"})
   public Object makeMobileConfigPay(HttpServletRequest request, @RequestParam String orderNum, @RequestParam int payWay)
     throws HandlerException
   {
/* 358 */     MobileConfigAppOrder mobileConfigAppOrder = new MobileConfigAppOrder();
/* 359 */     mobileConfigAppOrder.setOrderNum(orderNum);
/* 360 */     mobileConfigAppOrder = (MobileConfigAppOrder)this.mobileConfigAppOrderService.selectOne(mobileConfigAppOrder);
/* 361 */     if (mobileConfigAppOrder == null) {
/* 362 */       throw new HandlerException(39, "订单不存在");
     }
/* 364 */     MobileConfigAppOrder mobileConfigAppOrder1 = new MobileConfigAppOrder();
/* 365 */     mobileConfigAppOrder1.setId(mobileConfigAppOrder.getId());
/* 366 */     mobileConfigAppOrder1.setPayWay(Integer.valueOf(payWay));
/* 367 */     boolean update = this.mobileConfigAppOrderService.update(mobileConfigAppOrder1);
/* 368 */     if (!update) {
/* 369 */       throw new HandlerException(32, "支付失败");
     }
/* 371 */     if (payWay == 1) {
/* 372 */       WXCreateOrderParams wxCreateOrderParams = new WXCreateOrderParams();
/* 373 */       wxCreateOrderParams.setNotifyUrl(this.serverHostName + "/wxPay/mobileConfig/make/notify");
/* 374 */       wxCreateOrderParams.setBody("在线描述文件生成");
/* 375 */       wxCreateOrderParams.setOutTradeNo(orderNum);
/* 376 */       wxCreateOrderParams.setSpbillCreateIp("114.113.63.84");
/* 377 */       wxCreateOrderParams.setTradeType("NATIVE");
/* 378 */       HashMap<String, String> attach = new HashMap();
/* 379 */       wxCreateOrderParams.setAttach(attach);
/* 380 */       wxCreateOrderParams.setTotalFee(mobileConfigAppOrder.getPrice().intValue() / 100.0D);
/* 381 */       IPay iPay = new PayFactory().init(1);
       
/* 383 */       Map<String, Object> data = (Map)iPay.createOrder(wxCreateOrderParams);
/* 384 */       if (data == null) {
/* 385 */         throw new HandlerException(32, "充值失败！请重新尝试");
       }
/* 387 */       return data; }
/* 388 */     if (payWay == 2) {
/* 389 */       AliPayService.CreateOrderParam createOrderParam = new AliPayService.CreateOrderParam();
/* 390 */       double money = mobileConfigAppOrder.getPrice().intValue() / 1.0D;
/* 391 */       createOrderParam.setTotalAmount(money);
/* 392 */       createOrderParam.setOutTradeNo(orderNum);
/* 393 */       createOrderParam.setNotifyUrl(this.serverHostName + "/aliPay/mobileConfig/make/notify");
/* 394 */       createOrderParam.setReturnUrl(this.serverHostName + "/#/app/mobielconfig");
/* 395 */       createOrderParam.setPassbackParams(orderNum);
/* 396 */       createOrderParam.setSubject("在线描述文件生成");
/* 397 */       String form = (String)PayDirector.build().getALiPay().createOrder(createOrderParam);
/* 398 */       return form;
     }
/* 400 */     return "";
   }
 }

