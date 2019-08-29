/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.AppUpdateInfoMapper;
/*    */ import com.tiger.pojo.AppUpdateInfo;
/*    */ import com.tiger.service.AppUpdateInfoService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class AppUpdateInfoServiceImpl
/*    */   extends BaseServiceManager<AppUpdateInfo, AppUpdateInfoMapper>
/*    */   implements AppUpdateInfoService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(AppUpdateInfoMapper dao)
/*    */   {
/* 23 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<AppUpdateInfo> selectPageList(AppUpdateInfo appUpdateInfo, int i, int i1)
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\AppUpdateInfoServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */