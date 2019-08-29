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
/*     */ @Table(name="`user_bms`")
/*     */ public class UserBms
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`Id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Integer id;
/*     */   @Column(name="`user_name`")
/*     */   private String userName;
/*     */   @Column(name="`password`")
/*     */   private String password;
/*     */   @Column(name="`token`")
/*     */   private String token;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  35 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  42 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  49 */     return this.userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserName(String userName)
/*     */   {
/*  56 */     this.userName = (userName == null ? null : userName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPassword()
/*     */   {
/*  63 */     return this.password;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/*  70 */     this.password = (password == null ? null : password.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getToken()
/*     */   {
/*  77 */     return this.token;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToken(String token)
/*     */   {
/*  84 */     this.token = (token == null ? null : token.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/*  91 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/*  98 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 105 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 112 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 117 */     StringBuilder sb = new StringBuilder();
/* 118 */     sb.append(getClass().getSimpleName());
/* 119 */     sb.append(" [");
/* 120 */     sb.append("Hash = ").append(hashCode());
/* 121 */     sb.append(", id=").append(this.id);
/* 122 */     sb.append(", userName=").append(this.userName);
/* 123 */     sb.append(", password=").append(this.password);
/* 124 */     sb.append(", token=").append(this.token);
/* 125 */     sb.append(", createTime=").append(this.createTime);
/* 126 */     sb.append(", updateTime=").append(this.updateTime);
/* 127 */     sb.append(", serialVersionUID=").append(1L);
/* 128 */     sb.append("]");
/* 129 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\UserBms.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */