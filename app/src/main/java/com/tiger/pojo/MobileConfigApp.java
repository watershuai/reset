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
/*     */ @Table(name="`mobileconfig_app`")
/*     */ public class MobileConfigApp
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`user_id`")
/*     */   private Long userId;
/*     */   @Column(name="`app_name`")
/*     */   private String appName;
/*     */   @Column(name="`icon_url`")
/*     */   private String iconUrl;
/*     */   @Column(name="`mobile_config_url`")
/*     */   private String mobileConfigUrl;
/*     */   @Column(name="`download_num`")
/*     */   private Long downloadNum;
/*     */   @Column(name="`status`")
/*     */   private Integer status;
/*     */   @Column(name="`expire_time`")
/*     */   private Date expireTime;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
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
/*     */   public Long getUserId()
/*     */   {
/*  64 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/*  71 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAppName()
/*     */   {
/*  78 */     return this.appName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppName(String appName)
/*     */   {
/*  85 */     this.appName = (appName == null ? null : appName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getIconUrl()
/*     */   {
/*  92 */     return this.iconUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIconUrl(String iconUrl)
/*     */   {
/*  99 */     this.iconUrl = (iconUrl == null ? null : iconUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMobileConfigUrl()
/*     */   {
/* 106 */     return this.mobileConfigUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMobileConfigUrl(String mobileConfigUrl)
/*     */   {
/* 113 */     this.mobileConfigUrl = (mobileConfigUrl == null ? null : mobileConfigUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getDownloadNum()
/*     */   {
/* 120 */     return this.downloadNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDownloadNum(Long downloadNum)
/*     */   {
/* 127 */     this.downloadNum = downloadNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getStatus()
/*     */   {
/* 136 */     return this.status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStatus(Integer status)
/*     */   {
/* 145 */     this.status = status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getExpireTime()
/*     */   {
/* 152 */     return this.expireTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpireTime(Date expireTime)
/*     */   {
/* 159 */     this.expireTime = expireTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 166 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 173 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 180 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 187 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 192 */     StringBuilder sb = new StringBuilder();
/* 193 */     sb.append(getClass().getSimpleName());
/* 194 */     sb.append(" [");
/* 195 */     sb.append("Hash = ").append(hashCode());
/* 196 */     sb.append(", id=").append(this.id);
/* 197 */     sb.append(", userId=").append(this.userId);
/* 198 */     sb.append(", appName=").append(this.appName);
/* 199 */     sb.append(", iconUrl=").append(this.iconUrl);
/* 200 */     sb.append(", mobileConfigUrl=").append(this.mobileConfigUrl);
/* 201 */     sb.append(", downloadNum=").append(this.downloadNum);
/* 202 */     sb.append(", status=").append(this.status);
/* 203 */     sb.append(", expireTime=").append(this.expireTime);
/* 204 */     sb.append(", createTime=").append(this.createTime);
/* 205 */     sb.append(", updateTime=").append(this.updateTime);
/* 206 */     sb.append(", serialVersionUID=").append(1L);
/* 207 */     sb.append("]");
/* 208 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\MobileConfigApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */