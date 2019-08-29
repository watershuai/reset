/*    */ package com.tiger.formbean;
/*    */ 
/*    */ import org.hibernate.validator.constraints.NotBlank;
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
/*    */ 
/*    */ 
/*    */ public class AppUpdateForm
/*    */ {
/*    */   @NotBlank
/*    */   private String bundleId;
/*    */   private String updateLog;
/*    */   @NotBlank
/*    */   private String osName;
/*    */   private Long iConId;
/* 24 */   private Integer pkgType = Integer.valueOf(2);
/*    */   
/*    */   public String getBundleId() {
/* 27 */     return this.bundleId;
/*    */   }
/*    */   
/*    */   public void setBundleId(String bundleId) {
/* 31 */     this.bundleId = bundleId;
/*    */   }
/*    */   
/*    */   public String getUpdateLog() {
/* 35 */     return this.updateLog;
/*    */   }
/*    */   
/*    */   public void setUpdateLog(String updateLog) {
/* 39 */     this.updateLog = updateLog;
/*    */   }
/*    */   
/*    */   public Long getiConId() {
/* 43 */     return this.iConId;
/*    */   }
/*    */   
/*    */   public void setiConId(Long iConId) {
/* 47 */     this.iConId = iConId;
/*    */   }
/*    */   
/*    */   public String getOsName() {
/* 51 */     return this.osName;
/*    */   }
/*    */   
/*    */   public void setOsName(String osName) {
/* 55 */     this.osName = osName;
/*    */   }
/*    */   
/*    */   public Integer getPkgType() {
/* 59 */     return this.pkgType;
/*    */   }
/*    */   
/*    */   public void setPkgType(Integer pkgType) {
/* 63 */     this.pkgType = pkgType;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\AppUpdateForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */