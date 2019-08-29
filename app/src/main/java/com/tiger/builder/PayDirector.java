/*    */ package com.tiger.builder;
/*    */ 
/*    */ import com.tiger.service.impl.AliPayService;
/*    */ import com.yz.common.pay.service.IPay;
/*    */ import com.yz.common.pay.service.WXPay;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class PayDirector
/*    */ {
/*    */   private static AliPayService aliPayService;
/*    */   
/*    */   @Autowired
/*    */   public void setAliPayService(AliPayService aliPayService)
/*    */   {
/* 21 */     aliPayService = aliPayService;
/*    */   }
/*    */   
/*    */   public static PayDirector build() {
/* 25 */     return new PayDirector();
/*    */   }
/*    */   
/*    */   public IPay getWXPay() {
/* 29 */     return new WXPay();
/*    */   }
/*    */   
/*    */   public IPay getALiPay() {
/* 33 */     if (aliPayService == null) {
/* 34 */       aliPayService = new AliPayService();
/*    */     }
/* 36 */     return aliPayService;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\builder\PayDirector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */