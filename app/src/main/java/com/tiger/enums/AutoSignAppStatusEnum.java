/*    */ package com.tiger.enums;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum AutoSignAppStatusEnum
/*    */ {
/* 10 */   NO_ACTIVE(0),  ACTIVE(1);
/*    */   
/*    */   private int code;
/*    */   
/*    */   private AutoSignAppStatusEnum(int code) {
/* 15 */     this.code = code;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 19 */     return this.code;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\enums\AutoSignAppStatusEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */