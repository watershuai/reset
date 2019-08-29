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
/*     */ @Table(name="`auto_sign_task`")
/*     */ public class AutoSignTask
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`task_num`")
/*     */   private Long taskNum;
/*     */   @Column(name="`auto_sign_app_id`")
/*     */   private Long autoSignAppId;
/*     */   @Column(name="`task_status`")
/*     */   private Integer taskStatus;
/*     */   @Column(name="`download_url`")
/*     */   private String downloadUrl;
/*     */   @Column(name="`user_download_url`")
/*     */   private String userDownloadUrl;
/*     */   @Column(name="`cc_name`")
/*     */   private String ccName;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
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
/*     */   public Long getTaskNum()
/*     */   {
/*  61 */     return this.taskNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaskNum(Long taskNum)
/*     */   {
/*  68 */     this.taskNum = taskNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getAutoSignAppId()
/*     */   {
/*  75 */     return this.autoSignAppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAutoSignAppId(Long autoSignAppId)
/*     */   {
/*  82 */     this.autoSignAppId = autoSignAppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getTaskStatus()
/*     */   {
/*  91 */     return this.taskStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTaskStatus(Integer taskStatus)
/*     */   {
/* 100 */     this.taskStatus = taskStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDownloadUrl()
/*     */   {
/* 107 */     return this.downloadUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDownloadUrl(String downloadUrl)
/*     */   {
/* 114 */     this.downloadUrl = (downloadUrl == null ? null : downloadUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getUserDownloadUrl()
/*     */   {
/* 121 */     return this.userDownloadUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserDownloadUrl(String userDownloadUrl)
/*     */   {
/* 128 */     this.userDownloadUrl = (userDownloadUrl == null ? null : userDownloadUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 135 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 142 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 149 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 156 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getCcName() {
/* 160 */     return this.ccName;
/*     */   }
/*     */   
/*     */   public void setCcName(String ccName) {
/* 164 */     this.ccName = ccName;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append(getClass().getSimpleName());
/* 171 */     sb.append(" [");
/* 172 */     sb.append("Hash = ").append(hashCode());
/* 173 */     sb.append(", id=").append(this.id);
/* 174 */     sb.append(", taskNum=").append(this.taskNum);
/* 175 */     sb.append(", autoSignAppId=").append(this.autoSignAppId);
/* 176 */     sb.append(", taskStatus=").append(this.taskStatus);
/* 177 */     sb.append(", downloadUrl=").append(this.downloadUrl);
/* 178 */     sb.append(", userDownloadUrl=").append(this.userDownloadUrl);
/* 179 */     sb.append(", createTime=").append(this.createTime);
/* 180 */     sb.append(", updateTime=").append(this.updateTime);
/* 181 */     sb.append(", serialVersionUID=").append(1L);
/* 182 */     sb.append("]");
/* 183 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AutoSignTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */