/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.MobileConfigAppOrderMapper;
/*    */ import com.tiger.pojo.MobileConfigAppOrder;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.MobileConfigAppOrderService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class MobileConfigAppOrderServiceImpl
/*    */   extends BaseServiceManager<MobileConfigAppOrder, MobileConfigAppOrderMapper>
/*    */   implements MobileConfigAppOrderService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(MobileConfigAppOrderMapper mobileConfigAppOrderMapper)
/*    */   {
/* 21 */     this.dao = mobileConfigAppOrderMapper;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\MobileConfigAppOrderServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */