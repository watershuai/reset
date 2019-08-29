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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Table(name="`app`")
/*     */ public class App
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`icon_id`")
/*     */   private Long iconId;
/*     */   @Column(name="`account_id`")
/*     */   private Integer accountId;
/*     */   @Column(name="`bundle_id`")
/*     */   private String bundleId;
/*     */   @Column(name="`app_name`")
/*     */   private String appName;
/*     */   @Column(name="`os_name`")
/*     */   private String osName;
/*     */   @Column(name="`short_link`")
/*     */   private String shortLink;
/*     */   @Column(name="`app_desc`")
/*     */   private String appDesc;
/*     */   @Column(name="`down_num`")
/*     */   private Long downNum;
/*     */   @Column(name="`pkg_type`")
/*     */   private Integer pkgType;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  59 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getIconId()
/*     */   {
/*  73 */     return this.iconId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIconId(Long iconId)
/*     */   {
/*  80 */     this.iconId = iconId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getAccountId()
/*     */   {
/*  87 */     return this.accountId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccountId(Integer accountId)
/*     */   {
/*  94 */     this.accountId = accountId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBundleId()
/*     */   {
/* 101 */     return this.bundleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBundleId(String bundleId)
/*     */   {
/* 108 */     this.bundleId = (bundleId == null ? null : bundleId.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAppName()
/*     */   {
/* 115 */     return this.appName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppName(String appName)
/*     */   {
/* 122 */     this.appName = (appName == null ? null : appName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getOsName()
/*     */   {
/* 129 */     return this.osName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOsName(String osName)
/*     */   {
/* 136 */     this.osName = (osName == null ? null : osName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getShortLink()
/*     */   {
/* 145 */     return this.shortLink;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setShortLink(String shortLink)
/*     */   {
/* 154 */     this.shortLink = (shortLink == null ? null : shortLink.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAppDesc()
/*     */   {
/* 161 */     return this.appDesc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppDesc(String appDesc)
/*     */   {
/* 168 */     this.appDesc = (appDesc == null ? null : appDesc.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getDownNum()
/*     */   {
/* 175 */     return this.downNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDownNum(Long downNum)
/*     */   {
/* 182 */     this.downNum = downNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPkgType()
/*     */   {
/* 191 */     return this.pkgType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPkgType(Integer pkgType)
/*     */   {
/* 200 */     this.pkgType = pkgType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 207 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 214 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 221 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 228 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 233 */     StringBuilder sb = new StringBuilder();
/* 234 */     sb.append(getClass().getSimpleName());
/* 235 */     sb.append(" [");
/* 236 */     sb.append("Hash = ").append(hashCode());
/* 237 */     sb.append(", id=").append(this.id);
/* 238 */     sb.append(", iconId=").append(this.iconId);
/* 239 */     sb.append(", accountId=").append(this.accountId);
/* 240 */     sb.append(", bundleId=").append(this.bundleId);
/* 241 */     sb.append(", appName=").append(this.appName);
/* 242 */     sb.append(", osName=").append(this.osName);
/* 243 */     sb.append(", shortLink=").append(this.shortLink);
/* 244 */     sb.append(", appDesc=").append(this.appDesc);
/* 245 */     sb.append(", downNum=").append(this.downNum);
/* 246 */     sb.append(", pkgType=").append(this.pkgType);
/* 247 */     sb.append(", createTime=").append(this.createTime);
/* 248 */     sb.append(", updateTime=").append(this.updateTime);
/* 249 */     sb.append(", serialVersionUID=").append(1L);
/* 250 */     sb.append("]");
/* 251 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\App.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */