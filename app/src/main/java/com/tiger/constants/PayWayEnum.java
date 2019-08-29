/*    */ package com.tiger.constants;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PayWayEnum
/*    */ {
/* 10 */   WX_PAY(1, "WX_PAY"), 
/* 11 */   ALI_PAY(2, "ALI_PAY");
/*    */   
/*    */   private int payWay;
/*    */   private String code;
/*    */   
/* 16 */   private PayWayEnum(int payWay, String code) { this.code = code;
/* 17 */     this.payWay = payWay;
/*    */   }
/*    */   
/*    */   public int getPayWay() {
/* 21 */     return this.payWay;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 25 */     return this.code;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\constants\PayWayEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */