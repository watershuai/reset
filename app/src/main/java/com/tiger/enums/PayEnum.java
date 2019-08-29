/*    */ package com.tiger.enums;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PayEnum
/*    */ {
/* 10 */   WX(1), 
/* 11 */   ALI(2);
/*    */   
/*    */   private int code;
/*    */   
/*    */   private PayEnum(int code) {
/* 16 */     this.code = code;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 20 */     return this.code;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\enums\PayEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */