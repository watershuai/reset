 package com.tiger.formbean;
 
 import javax.validation.constraints.NotBlank;
 import org.hibernate.validator.constraints.Length;

 public class LoginForm
 {
   @NotBlank
   private String account;
   @NotBlank
   @Length(min=6, max=18, message="密码长度在6-18之间")
   private String password;
   
   public String getAccount()
   {
/* 24 */     return this.account;
   }
   
   public void setAccount(String account) {
/* 28 */     this.account = account;
   }
   
   public String getPassword() {
/* 32 */     return this.password;
   }
   
   public void setPassword(String password) {
/* 36 */     this.password = password;
   }
 }