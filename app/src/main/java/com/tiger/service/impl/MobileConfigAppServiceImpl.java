/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.tiger.dao.MobileConfigAppMapper;
/*    */ import com.tiger.pojo.MobileConfigApp;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.MobileConfigAppService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class MobileConfigAppServiceImpl
/*    */   extends BaseServiceManager<MobileConfigApp, MobileConfigAppMapper>
/*    */   implements MobileConfigAppService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(MobileConfigAppMapper mobileConfigAppMapper)
/*    */   {
/* 24 */     this.dao = mobileConfigAppMapper;
/*    */   }
/*    */   
/*    */   public List<MobileConfigApp> selectPageList(MobileConfigApp mobileConfigApp, com.tiger.model.Page page)
/*    */   {
/* 29 */     if ((page.getIndex() > 0) && (page.getPageSize() > 0)) {
/* 30 */       PageHelper.startPage(page.getIndex(), page.getPageSize());
/*    */     }
/* 32 */     PageHelper.orderBy("create_time desc");
/* 33 */     com.github.pagehelper.Page page1 = (com.github.pagehelper.Page)((MobileConfigAppMapper)this.dao).select(mobileConfigApp);
/* 34 */     page.setDataList(page1.getResult());
/* 35 */     page.setTotalPage(page1.getTotal() / page.getPageSize());
/* 36 */     return page1.getResult();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\MobileConfigAppServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */