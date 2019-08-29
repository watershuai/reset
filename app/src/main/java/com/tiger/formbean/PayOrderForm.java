 package com.tiger.formbean;
 
 
 
 public class PayOrderForm
 {
   private String phone;
   private Integer orderStatus;
   
   private Integer month;
   public String getPhone()
   {
/* 17 */     return this.phone;
   }
   
   public void setPhone(String phone) {
/* 21 */     this.phone = phone;
   }
   
   public Integer getOrderStatus() {
/* 25 */     return this.orderStatus;
   }
   
   public void setOrderStatus(Integer orderStatus) {
/* 29 */     this.orderStatus = orderStatus;
   }
   
   public Integer getMonth() {
/* 33 */     return this.month;
   }
   
   public void setMonth(Integer month) {
/* 37 */     this.month = month;
   }
 }
