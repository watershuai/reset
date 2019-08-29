/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.AppMergeMapper;
/*    */ import com.tiger.pojo.AppMerge;
/*    */ import com.tiger.service.AppMergeService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class AppMergeServiceImpl
/*    */   extends BaseServiceManager<AppMerge, AppMergeMapper>
/*    */   implements AppMergeService
/*    */ {
/*    */   public AppMerge getByActiveLinkOrPassiveLink(String shortLink)
/*    */   {
/* 23 */     List<AppMerge> appMerges = ((AppMergeMapper)this.dao).selectByActiveLinkOrPassiveLink(shortLink);
/* 24 */     if (CollectionUtils.isEmpty(appMerges)) {
/* 25 */       return null;
/*    */     }
/* 27 */     return (AppMerge)appMerges.get(0);
/*    */   }
/*    */   
/*    */   @Autowired
/*    */   public void setDao(AppMergeMapper dao)
/*    */   {
/* 33 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<AppMerge> selectPageList(AppMerge appMerge, int i, int i1)
/*    */   {
/* 38 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\AppMergeServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */