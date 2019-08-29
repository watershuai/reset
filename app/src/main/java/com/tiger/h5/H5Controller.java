/*     */ package com.tiger.h5;
/*     */ 
/*     */ import com.tiger.model.PkgInfo;
/*     */ import com.tiger.pojo.Account;
/*     */ import com.tiger.pojo.Advertisement;
/*     */ import com.tiger.pojo.App;
/*     */ import com.tiger.pojo.AppMerge;
/*     */ import com.tiger.pojo.AppUpdateInfo;
/*     */ import com.tiger.pojo.IconData;
/*     */ import com.tiger.service.AccountService;
/*     */ import com.tiger.service.AdvertisementService;
/*     */ import com.tiger.service.AppMergeService;
/*     */ import com.tiger.service.AppService;
/*     */ import com.tiger.service.IconDataService;
/*     */ import com.yz.common.core.exception.HandlerException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class H5Controller
/*     */ {
/*     */   @Resource
/*     */   private AppService appService;
/*     */   @Resource
/*     */   private IconDataService iconDataService;
/*     */   @Resource
/*     */   private AppMergeService appMergeService;
/*     */   @Resource
/*     */   private AccountService accountService;
/*     */   @Resource
/*     */   private AdvertisementService advertisementService;
/*     */   
/*     */   @RequestMapping({"/{link}"})
/*     */   public String downPage(@PathVariable("link") String link, ModelMap modelMap)
/*     */     throws HandlerException
/*     */   {
/*  43 */     App app = new App();
/*  44 */     app.setShortLink(link);
/*  45 */     app = (App)this.appService.selectOne(app);
/*     */     
/*  47 */     if (app == null) {
/*  48 */       throw new HandlerException(11, "该应用不存在");
/*     */     }
/*  50 */     Account account = new Account();
/*  51 */     account.setId(app.getAccountId());
/*  52 */     account = (Account)this.accountService.selectOne(account);
/*  53 */     if (account.getIsVip().intValue() != 1) {
/*  54 */       Advertisement randomAdvertisement = this.advertisementService.getRandomAdvertisement();
/*  55 */       if (randomAdvertisement != null) {
/*  56 */         modelMap.put("url", randomAdvertisement.getUrl());
/*  57 */         modelMap.put("linkUrl", randomAdvertisement.getLinkUrl());
/*     */       }
/*     */     }
/*     */     
/*  61 */     List<PkgInfo> pkgInfos = new ArrayList();
/*     */     
/*  63 */     ArrayList<Long> appIds = new ArrayList();
/*  64 */     appIds.add(app.getId());
/*  65 */     AppUpdateInfo appUpdateInfo = (AppUpdateInfo)this.appService.getLastVersionInfoByAppIds(appIds).get(0);
/*     */     
/*  67 */     PkgInfo pkgInfo = new PkgInfo();
/*  68 */     BeanUtils.copyProperties(app, pkgInfo);
/*  69 */     BeanUtils.copyProperties(appUpdateInfo, pkgInfo);
/*  70 */     IconData iconData = new IconData();
/*  71 */     iconData.setId(app.getIconId());
/*  72 */     iconData = (IconData)this.iconDataService.selectOne(iconData);
/*  73 */     pkgInfo.setiConData(iconData.getiData());
/*  74 */     pkgInfo.setUpdateTime(appUpdateInfo.getCreateTime());
/*  75 */     pkgInfo.setOssUrl("");
/*  76 */     pkgInfo.setPlistUrl("");
/*     */     
/*  78 */     pkgInfos.add(pkgInfo);
/*  79 */     modelMap.put("pkgInfos", pkgInfos);
/*     */     
/*  81 */     AppMerge appMerge = this.appMergeService.getByActiveLinkOrPassiveLink(link);
/*     */     
/*  83 */     if (appMerge == null) {
/*  84 */       return "yran";
/*     */     }
/*  86 */     String activeLink = appMerge.getActiveLink();
/*  87 */     String passiveLink = appMerge.getPassiveLink();
/*  88 */     String sl = "";
/*  89 */     if (!activeLink.equalsIgnoreCase(link)) {
/*  90 */       sl = activeLink;
/*  91 */     } else if (!passiveLink.equalsIgnoreCase(link)) {
/*  92 */       sl = passiveLink;
/*     */     }
/*  94 */     app = new App();
/*  95 */     app.setShortLink(sl);
/*  96 */     app = (App)this.appService.selectOne(app);
/*     */     
/*  98 */     appIds = new ArrayList();
/*  99 */     appIds.add(app.getId());
/*     */     
/* 101 */     appUpdateInfo = (AppUpdateInfo)this.appService.getLastVersionInfoByAppIds(appIds).get(0);
/* 102 */     pkgInfo = new PkgInfo();
/* 103 */     BeanUtils.copyProperties(app, pkgInfo);
/* 104 */     BeanUtils.copyProperties(appUpdateInfo, pkgInfo);
/* 105 */     iconData = new IconData();
/* 106 */     iconData.setId(app.getIconId());
/* 107 */     iconData = (IconData)this.iconDataService.selectOne(iconData);
/* 108 */     pkgInfo.setiConData(iconData.getiData());
/* 109 */     pkgInfo.setUpdateTime(appUpdateInfo.getCreateTime());
/* 110 */     pkgInfo.setOssUrl("");
/* 111 */     pkgInfo.setPlistUrl("");
/* 112 */     pkgInfos.add(pkgInfo);
/* 113 */     modelMap.put("pkgInfos", pkgInfos);
/* 114 */     return "yran";
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\h5\H5Controller.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */