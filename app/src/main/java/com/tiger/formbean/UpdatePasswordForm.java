/*    */ package com.tiger.formbean;
/*    */ 
/*    */ import javax.validation.constraints.NotBlank;
/*    */ 
/*    */ 
/*    */ public class UpdatePasswordForm
/*    */ {
/*    */   @NotBlank
/*    */   private String phone;
/*    */   @NotBlank
/*    */   private String password;
/*    */   @NotBlank
/*    */   private String verifyCode;
/*    */   @NotBlank
/*    */   private String smsCode;
/*    */   
/*    */   public String getPhone()
/*    */   {
/* 19 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 23 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 27 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 31 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getVerifyCode() {
/* 35 */     return this.verifyCode;
/*    */   }
/*    */   
/*    */   public void setVerifyCode(String verifyCode) {
/* 39 */     this.verifyCode = verifyCode;
/*    */   }
/*    */   
/*    */   public String getSmsCode() {
/* 43 */     return this.smsCode;
/*    */   }
/*    */   
/*    */   public void setSmsCode(String smsCode) {
/* 47 */     this.smsCode = smsCode;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\UpdatePasswordForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */