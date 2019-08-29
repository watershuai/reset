/*    */ package com.tiger.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PayOrderQuery
/*    */ {
/*    */   private String phone;
/*    */   private Integer orderStatus;
/*    */   private Integer month;
/*    */   private Date startTime;
/*    */   private Date endTime;
/*    */   
/*    */   public String getPhone()
/*    */   {
/* 23 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 27 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public Integer getOrderStatus() {
/* 31 */     return this.orderStatus;
/*    */   }
/*    */   
/*    */   public void setOrderStatus(Integer orderStatus) {
/* 35 */     this.orderStatus = orderStatus;
/*    */   }
/*    */   
/*    */   public Date getStartTime() {
/* 39 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public void setStartTime(Date startTime) {
/* 43 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public Date getEndTime() {
/* 47 */     return this.endTime;
/*    */   }
/*    */   
/*    */   public void setEndTime(Date endTime) {
/* 51 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */   public Integer getMonth() {
/* 55 */     return this.month;
/*    */   }
/*    */   
/*    */   public void setMonth(Integer month) {
/* 59 */     this.month = month;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\model\PayOrderQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */