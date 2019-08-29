/*    */ package com.tiger.formbean;
/*    */ 
/*    */ import javax.validation.constraints.Min;
/*    */ import javax.validation.constraints.NotBlank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AccountUpdateForm
/*    */ {
/*    */   @NotBlank
/*    */   private String account;
/*    */   @Min(value=1L, message="请输入大于0的整数")
/*    */   private int payDownNum;
/*    */   
/*    */   public String getAccount()
/*    */   {
/* 18 */     return this.account;
/*    */   }
/*    */   
/*    */   public void setAccount(String account) {
/* 22 */     this.account = account;
/*    */   }
/*    */   
/*    */   public int getPayDownNum() {
/* 26 */     return this.payDownNum;
/*    */   }
/*    */   
/*    */   public void setPayDownNum(int payDownNum) {
/* 30 */     this.payDownNum = payDownNum;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\AccountUpdateForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */