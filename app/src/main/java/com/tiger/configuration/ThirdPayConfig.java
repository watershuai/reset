/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import javax.annotation.PostConstruct;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class ThirdPayConfig
/*    */ {
/*    */   @Value("${wxpay.appid}")
/*    */   private String wxAppId;
/*    */   @Value("${wxpay.key}")
/*    */   private String wxKey;
/*    */   @Value("${wxpay.mchid}")
/*    */   private String wxMchId;
/*    */   
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 28 */     com.yz.common.pay.util.WXPayUtil.APPID = this.wxAppId;
/* 29 */     com.yz.common.pay.util.WXPayUtil.KEY = this.wxKey;
/* 30 */     com.yz.common.pay.util.WXPayUtil.MCHID = this.wxMchId;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\ThirdPayConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */