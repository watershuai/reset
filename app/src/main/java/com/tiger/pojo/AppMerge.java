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
/*     */ @Table(name="`app_merge`")
/*     */ public class AppMerge
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`account_id`")
/*     */   private Integer accountId;
/*     */   @Column(name="`active_link`")
/*     */   private String activeLink;
/*     */   @Column(name="`passive_link`")
/*     */   private String passiveLink;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  32 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  39 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getAccountId()
/*     */   {
/*  46 */     return this.accountId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccountId(Integer accountId)
/*     */   {
/*  53 */     this.accountId = accountId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getActiveLink()
/*     */   {
/*  60 */     return this.activeLink;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActiveLink(String activeLink)
/*     */   {
/*  67 */     this.activeLink = (activeLink == null ? null : activeLink.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPassiveLink()
/*     */   {
/*  74 */     return this.passiveLink;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPassiveLink(String passiveLink)
/*     */   {
/*  81 */     this.passiveLink = (passiveLink == null ? null : passiveLink.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/*  88 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/*  95 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 100 */     StringBuilder sb = new StringBuilder();
/* 101 */     sb.append(getClass().getSimpleName());
/* 102 */     sb.append(" [");
/* 103 */     sb.append("Hash = ").append(hashCode());
/* 104 */     sb.append(", id=").append(this.id);
/* 105 */     sb.append(", accountId=").append(this.accountId);
/* 106 */     sb.append(", activeLink=").append(this.activeLink);
/* 107 */     sb.append(", passiveLink=").append(this.passiveLink);
/* 108 */     sb.append(", createTime=").append(this.createTime);
/* 109 */     sb.append(", serialVersionUID=").append(1L);
/* 110 */     sb.append("]");
/* 111 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AppMerge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */