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
/*     */ @Table(name="`auto_sign_app`")
/*     */ public class AutoSignApp
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`meal_id`")
/*     */   private Integer mealId;
/*     */   @Column(name="`bundle_id`")
/*     */   private String bundleId;
/*     */   @Column(name="`display_name`")
/*     */   private String displayName;
/*     */   @Column(name="`cc_name`")
/*     */   private String ccName;
/*     */   @Column(name="`user_id`")
/*     */   private Long userId;
/*     */   @Column(name="`free_update_num`")
/*     */   private Integer freeUpdateNum;
/*     */   @Column(name="`meal_desc`")
/*     */   private String mealDesc;
/*     */   @Column(name="`app_status`")
/*     */   private Integer appStatus;
/*     */   @Column(name="`expire_time`")
/*     */   private Date expireTime;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  53 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  60 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getMealId()
/*     */   {
/*  67 */     return this.mealId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMealId(Integer mealId)
/*     */   {
/*  74 */     this.mealId = mealId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBundleId()
/*     */   {
/*  81 */     return this.bundleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBundleId(String bundleId)
/*     */   {
/*  88 */     this.bundleId = (bundleId == null ? null : bundleId.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDisplayName()
/*     */   {
/*  95 */     return this.displayName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDisplayName(String displayName)
/*     */   {
/* 102 */     this.displayName = (displayName == null ? null : displayName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCcName()
/*     */   {
/* 109 */     return this.ccName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCcName(String ccName)
/*     */   {
/* 116 */     this.ccName = (ccName == null ? null : ccName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 123 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 130 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getFreeUpdateNum()
/*     */   {
/* 137 */     return this.freeUpdateNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFreeUpdateNum(Integer freeUpdateNum)
/*     */   {
/* 144 */     this.freeUpdateNum = freeUpdateNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getExpireTime()
/*     */   {
/* 153 */     return this.expireTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExpireTime(Date expireTime)
/*     */   {
/* 162 */     this.expireTime = expireTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 169 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 176 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getMealDesc() {
/* 180 */     return this.mealDesc;
/*     */   }
/*     */   
/*     */   public void setMealDesc(String mealDesc) {
/* 184 */     this.mealDesc = mealDesc;
/*     */   }
/*     */   
/*     */   public Integer getAppStatus() {
/* 188 */     return this.appStatus;
/*     */   }
/*     */   
/*     */   public void setAppStatus(Integer appStatus) {
/* 192 */     this.appStatus = appStatus;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 197 */     StringBuilder sb = new StringBuilder();
/* 198 */     sb.append(getClass().getSimpleName());
/* 199 */     sb.append(" [");
/* 200 */     sb.append("Hash = ").append(hashCode());
/* 201 */     sb.append(", id=").append(this.id);
/* 202 */     sb.append(", mealId=").append(this.mealId);
/* 203 */     sb.append(", bundleId=").append(this.bundleId);
/* 204 */     sb.append(", displayName=").append(this.displayName);
/* 205 */     sb.append(", ccName=").append(this.ccName);
/* 206 */     sb.append(", userId=").append(this.userId);
/* 207 */     sb.append(", freeUpdateNum=").append(this.freeUpdateNum);
/* 208 */     sb.append(", expireTime=").append(this.expireTime);
/* 209 */     sb.append(", createTime=").append(this.createTime);
/* 210 */     sb.append(", serialVersionUID=").append(1L);
/* 211 */     sb.append("]");
/* 212 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AutoSignApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */