/*    */ package com.tiger.formbean;
/*    */ 
/*    */ import javax.validation.constraints.NotBlank;
/*    */ import org.hibernate.validator.constraints.Length;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegisterForm
/*    */ {
/*    */   @NotBlank
/*    */   private String account;
/*    */   @NotBlank
/*    */   @Length(min=6, max=18, message="密码长度在6-18之间")
/*    */   private String password;
/*    */   private String smsCode;
/*    */   private String verifyCode;
/*    */   
/*    */   public String getAccount()
/*    */   {
/* 27 */     return this.account;
/*    */   }
/*    */   
/*    */   public void setAccount(String account) {
/* 31 */     this.account = account;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 35 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 39 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getSmsCode() {
/* 43 */     return this.smsCode;
/*    */   }
/*    */   
/*    */   public void setSmsCode(String smsCode) {
/* 47 */     this.smsCode = smsCode;
/*    */   }
/*    */   
/*    */   public String getVerifyCode() {
/* 51 */     return this.verifyCode;
/*    */   }
/*    */   
/*    */   public void setVerifyCode(String verifyCode) {
/* 55 */     this.verifyCode = verifyCode;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\RegisterForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */