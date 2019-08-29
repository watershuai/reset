/*     */ package com.tiger.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PkgInfo
/*     */ {
/*     */   private Long id;
/*     */   private Long iconId;
/*     */   private Integer accountId;
/*     */   private String bundleId;
/*     */   private String appName;
/*     */   private String appVersion;
/*     */   private String minOsVersion;
/*     */   private String osName;
/*     */   private String shortLink;
/*     */   private String pkgLocalPath;
/*     */   private Long pkgFileSize;
/*     */   private String updateLog;
/*     */   private Date createTime;
/*     */   private Date updateTime;
/*     */   private String iConData;
/*     */   private String plistUrl;
/*     */   private String ossUrl;
/*     */   private String appDesc;
/*     */   private Long downNum;
/*     */   private Integer pkgType;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  51 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getIconId() {
/*  55 */     return this.iconId;
/*     */   }
/*     */   
/*     */   public void setIconId(Long iconId) {
/*  59 */     this.iconId = iconId;
/*     */   }
/*     */   
/*     */   public Integer getAccountId() {
/*  63 */     return this.accountId;
/*     */   }
/*     */   
/*     */   public void setAccountId(Integer accountId) {
/*  67 */     this.accountId = accountId;
/*     */   }
/*     */   
/*     */   public String getBundleId() {
/*  71 */     return this.bundleId;
/*     */   }
/*     */   
/*     */   public void setBundleId(String bundleId) {
/*  75 */     this.bundleId = (bundleId == null ? null : bundleId.trim());
/*     */   }
/*     */   
/*     */   public String getAppName() {
/*  79 */     return this.appName;
/*     */   }
/*     */   
/*     */   public void setAppName(String appName) {
/*  83 */     this.appName = (appName == null ? null : appName.trim());
/*     */   }
/*     */   
/*     */   public String getAppVersion() {
/*  87 */     return this.appVersion;
/*     */   }
/*     */   
/*     */   public void setAppVersion(String appVersion) {
/*  91 */     this.appVersion = (appVersion == null ? null : appVersion.trim());
/*     */   }
/*     */   
/*     */   public String getMinOsVersion() {
/*  95 */     return this.minOsVersion;
/*     */   }
/*     */   
/*     */   public void setMinOsVersion(String minOsVersion) {
/*  99 */     this.minOsVersion = (minOsVersion == null ? null : minOsVersion.trim());
/*     */   }
/*     */   
/*     */   public String getOsName() {
/* 103 */     return this.osName;
/*     */   }
/*     */   
/*     */   public void setOsName(String osName) {
/* 107 */     this.osName = (osName == null ? null : osName.trim());
/*     */   }
/*     */   
/*     */   public String getShortLink() {
/* 111 */     return this.shortLink;
/*     */   }
/*     */   
/*     */   public void setShortLink(String shortLink) {
/* 115 */     this.shortLink = (shortLink == null ? null : shortLink.trim());
/*     */   }
/*     */   
/*     */   public String getUpdateLog() {
/* 119 */     return this.updateLog;
/*     */   }
/*     */   
/*     */   public void setUpdateLog(String updateLog) {
/* 123 */     this.updateLog = (updateLog == null ? null : updateLog.trim());
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 127 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 131 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getPkgLocalPath() {
/* 135 */     return this.pkgLocalPath;
/*     */   }
/*     */   
/*     */   public void setPkgLocalPath(String pkgLocalPath) {
/* 139 */     this.pkgLocalPath = pkgLocalPath;
/*     */   }
/*     */   
/*     */   public Long getPkgFileSize() {
/* 143 */     return this.pkgFileSize;
/*     */   }
/*     */   
/*     */   public void setPkgFileSize(Long pkgFileSize) {
/* 147 */     this.pkgFileSize = pkgFileSize;
/*     */   }
/*     */   
/*     */   public String getiConData() {
/* 151 */     return this.iConData;
/*     */   }
/*     */   
/*     */   public void setiConData(String iConData) {
/* 155 */     this.iConData = iConData;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 159 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 163 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getPlistUrl() {
/* 167 */     return this.plistUrl;
/*     */   }
/*     */   
/*     */   public void setPlistUrl(String plistUrl) {
/* 171 */     this.plistUrl = plistUrl;
/*     */   }
/*     */   
/*     */   public String getOssUrl() {
/* 175 */     return this.ossUrl;
/*     */   }
/*     */   
/*     */   public void setOssUrl(String ossUrl) {
/* 179 */     this.ossUrl = ossUrl;
/*     */   }
/*     */   
/*     */   public String getAppDesc() {
/* 183 */     return this.appDesc;
/*     */   }
/*     */   
/*     */   public void setAppDesc(String appDesc) {
/* 187 */     this.appDesc = appDesc;
/*     */   }
/*     */   
/*     */   public Long getDownNum() {
/* 191 */     return this.downNum;
/*     */   }
/*     */   
/*     */   public void setDownNum(Long downNum) {
/* 195 */     this.downNum = downNum;
/*     */   }
/*     */   
/*     */   public Integer getPkgType() {
/* 199 */     return this.pkgType;
/*     */   }
/*     */   
/*     */   public void setPkgType(Integer pkgType) {
/* 203 */     this.pkgType = pkgType;
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\model\PkgInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */