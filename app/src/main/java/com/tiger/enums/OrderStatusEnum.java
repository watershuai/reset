/*    */ package com.tiger.enums;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderStatusEnum
/*    */ {
/* 10 */   NO_PAY(1),  SUCCESS(2);
/*    */   
/*    */   private int flag;
/*    */   
/*    */   public int getFlag() {
/* 15 */     return this.flag;
/*    */   }
/*    */   
/*    */   private OrderStatusEnum(int flag) {
/* 19 */     this.flag = flag;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\enums\OrderStatusEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */