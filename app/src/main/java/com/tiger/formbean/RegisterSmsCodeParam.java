/*    */ package com.tiger.formbean;
/*    */ 
/*    */ import javax.validation.constraints.NotBlank;
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
/*    */ public class RegisterSmsCodeParam
/*    */ {
/*    */   @NotBlank
/*    */   private String phone;
/*    */   @NotBlank(message="图片验证码不能为空")
/*    */   private String verifyCode;
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
/*    */   public String getVerifyCode() {
/* 31 */     return this.verifyCode;
/*    */   }
/*    */   
/*    */   public void setVerifyCode(String verifyCode) {
/* 35 */     this.verifyCode = verifyCode;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\RegisterSmsCodeParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */