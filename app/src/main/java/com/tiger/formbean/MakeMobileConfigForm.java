/*    */ package com.tiger.formbean;
/*    */ 
/*    */ import javax.validation.constraints.Max;
/*    */ import javax.validation.constraints.Min;
/*    */ import javax.validation.constraints.NotEmpty;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MakeMobileConfigForm
/*    */ {
/*    */   @NotEmpty
/*    */   public String appName;
/*    */   @NotEmpty
/*    */   public String appUrl;
/*    */   @Min(0L)
/*    */   @Max(1L)
/*    */   public int allowDelete;
/*    */   @Min(180L)
/*    */   public int day;
/*    */   
/*    */   public String getAppName()
/*    */   {
/* 25 */     return this.appName;
/*    */   }
/*    */   
/*    */   public void setAppName(String appName) {
/* 29 */     this.appName = appName;
/*    */   }
/*    */   
/*    */   public String getAppUrl() {
/* 33 */     return this.appUrl;
/*    */   }
/*    */   
/*    */   public void setAppUrl(String appUrl) {
/* 37 */     this.appUrl = appUrl;
/*    */   }
/*    */   
/*    */   public int getAllowDelete() {
/* 41 */     return this.allowDelete;
/*    */   }
/*    */   
/*    */   public void setAllowDelete(int allowDelete) {
/* 45 */     this.allowDelete = allowDelete;
/*    */   }
/*    */   
/*    */   public int getDay() {
/* 49 */     return this.day;
/*    */   }
/*    */   
/*    */   public void setDay(int day) {
/* 53 */     this.day = day;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\MakeMobileConfigForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */