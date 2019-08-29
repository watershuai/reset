 package com.tiger.formbean;
 
 import org.hibernate.validator.constraints.NotBlank;
 
 
 
 
 
 
 
 
 
 public class AppForm
 {
   @NotBlank
   private String shortLink;
   private String appDesc;
   private String appName;
   private Long iconId;
   
   public String getAppDesc()
   {
/* 23 */     return this.appDesc;
   }
   
   public void setAppDesc(String appDesc) {
/* 27 */     this.appDesc = appDesc;
   }
   
   public String getAppName() {
/* 31 */     return this.appName;
   }
   
   public void setAppName(String appName) {
/* 35 */     this.appName = appName;
   }
   
   public String getShortLink() {
/* 39 */     return this.shortLink;
   }
   
   public void setShortLink(String shortLink) {
/* 43 */     this.shortLink = shortLink;
   }
   
   public Long getIconId() {
/* 47 */     return this.iconId;
   }
   
   public void setIconId(Long iconId) {
/* 51 */     this.iconId = iconId;
   }
 }