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
/*     */ @Table(name="`user_app_download_count`")
/*     */ public class UserAppDownloadCount
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`user_id`")
/*     */   private Integer userId;
/*     */   @Column(name="`app_id`")
/*     */   private Long appId;
/*     */   @Column(name="`app_name`")
/*     */   private String appName;
/*     */   @Column(name="`app_os_name`")
/*     */   private String appOsName;
/*     */   @Column(name="`num`")
/*     */   private Integer num;
/*     */   @Column(name="`count_time`")
/*     */   private String countTime;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  54 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getUserId()
/*     */   {
/*  61 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Integer userId)
/*     */   {
/*  68 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getAppId()
/*     */   {
/*  75 */     return this.appId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppId(Long appId)
/*     */   {
/*  82 */     this.appId = appId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAppName()
/*     */   {
/*  89 */     return this.appName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppName(String appName)
/*     */   {
/*  96 */     this.appName = (appName == null ? null : appName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAppOsName()
/*     */   {
/* 105 */     return this.appOsName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAppOsName(String appOsName)
/*     */   {
/* 114 */     this.appOsName = (appOsName == null ? null : appOsName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getNum()
/*     */   {
/* 121 */     return this.num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNum(Integer num)
/*     */   {
/* 128 */     this.num = num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCountTime()
/*     */   {
/* 137 */     return this.countTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTime(String countTime)
/*     */   {
/* 146 */     this.countTime = (countTime == null ? null : countTime.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 153 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 160 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 165 */     StringBuilder sb = new StringBuilder();
/* 166 */     sb.append(getClass().getSimpleName());
/* 167 */     sb.append(" [");
/* 168 */     sb.append("Hash = ").append(hashCode());
/* 169 */     sb.append(", id=").append(this.id);
/* 170 */     sb.append(", userId=").append(this.userId);
/* 171 */     sb.append(", appId=").append(this.appId);
/* 172 */     sb.append(", appName=").append(this.appName);
/* 173 */     sb.append(", appOsName=").append(this.appOsName);
/* 174 */     sb.append(", num=").append(this.num);
/* 175 */     sb.append(", countTime=").append(this.countTime);
/* 176 */     sb.append(", createTime=").append(this.createTime);
/* 177 */     sb.append(", serialVersionUID=").append(1L);
/* 178 */     sb.append("]");
/* 179 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\UserAppDownloadCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */