/*     */ package com.tiger.pojo;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
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
/*     */ @Table(name="`app_update_info`")
/*     */ public class AppUpdateInfo
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`app_id`")
/*     */   private Long appId;
/*     */   @Column(name="`app_version`")
/*     */   private String appVersion;
/*     */   @Column(name="`min_os_version`")
/*     */   private String minOsVersion;
/*     */   @Column(name="`pkg_local_path`")
/*     */   private String pkgLocalPath;
/*     */   @Column(name="`pkg_file_size`")
/*     */   private Long pkgFileSize;
/*     */   @Column(name="`update_log`")
/*     */   private String updateLog;
/*     */   @Column(name="`oss_url`")
/*     */   private String ossUrl;
/*     */   @Column(name="`plist_url`")
/*     */   private String plistUrl;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  50 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getAppId()
/*     */   {
/*  64 */     return this.appId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppId(Long appId)
/*     */   {
/*  71 */     this.appId = appId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAppVersion()
/*     */   {
/*  78 */     return this.appVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppVersion(String appVersion)
/*     */   {
/*  85 */     this.appVersion = (appVersion == null ? null : appVersion.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMinOsVersion()
/*     */   {
/*  92 */     return this.minOsVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMinOsVersion(String minOsVersion)
/*     */   {
/*  99 */     this.minOsVersion = (minOsVersion == null ? null : minOsVersion.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPkgLocalPath()
/*     */   {
/* 108 */     return this.pkgLocalPath;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPkgLocalPath(String pkgLocalPath)
/*     */   {
/* 117 */     this.pkgLocalPath = (pkgLocalPath == null ? null : pkgLocalPath.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getPkgFileSize()
/*     */   {
/* 124 */     return this.pkgFileSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPkgFileSize(Long pkgFileSize)
/*     */   {
/* 131 */     this.pkgFileSize = pkgFileSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getUpdateLog()
/*     */   {
/* 138 */     return this.updateLog;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateLog(String updateLog)
/*     */   {
/* 145 */     this.updateLog = (updateLog == null ? null : updateLog.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getOssUrl()
/*     */   {
/* 152 */     return this.ossUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOssUrl(String ossUrl)
/*     */   {
/* 159 */     this.ossUrl = (ossUrl == null ? null : ossUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPlistUrl()
/*     */   {
/* 166 */     return this.plistUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlistUrl(String plistUrl)
/*     */   {
/* 173 */     this.plistUrl = (plistUrl == null ? null : plistUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 180 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 187 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 192 */     StringBuilder sb = new StringBuilder();
/* 193 */     sb.append(getClass().getSimpleName());
/* 194 */     sb.append(" [");
/* 195 */     sb.append("Hash = ").append(hashCode());
/* 196 */     sb.append(", id=").append(this.id);
/* 197 */     sb.append(", appId=").append(this.appId);
/* 198 */     sb.append(", appVersion=").append(this.appVersion);
/* 199 */     sb.append(", minOsVersion=").append(this.minOsVersion);
/* 200 */     sb.append(", pkgLocalPath=").append(this.pkgLocalPath);
/* 201 */     sb.append(", pkgFileSize=").append(this.pkgFileSize);
/* 202 */     sb.append(", updateLog=").append(this.updateLog);
/* 203 */     sb.append(", ossUrl=").append(this.ossUrl);
/* 204 */     sb.append(", plistUrl=").append(this.plistUrl);
/* 205 */     sb.append(", createTime=").append(this.createTime);
/* 206 */     sb.append(", serialVersionUID=").append(1L);
/* 207 */     sb.append("]");
/* 208 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AppUpdateInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */