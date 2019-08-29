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
/*     */ @Table(name="`advertisement`")
/*     */ public class Advertisement
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`url`")
/*     */   private String url;
/*     */   @Column(name="`link_url`")
/*     */   private String linkUrl;
/*     */   @Column(name="`remarks`")
/*     */   private String remarks;
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
/*     */   public String getUrl()
/*     */   {
/*  46 */     return this.url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUrl(String url)
/*     */   {
/*  53 */     this.url = (url == null ? null : url.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getLinkUrl()
/*     */   {
/*  60 */     return this.linkUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLinkUrl(String linkUrl)
/*     */   {
/*  67 */     this.linkUrl = (linkUrl == null ? null : linkUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRemarks()
/*     */   {
/*  74 */     return this.remarks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRemarks(String remarks)
/*     */   {
/*  81 */     this.remarks = (remarks == null ? null : remarks.trim());
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
/* 105 */     sb.append(", url=").append(this.url);
/* 106 */     sb.append(", linkUrl=").append(this.linkUrl);
/* 107 */     sb.append(", remarks=").append(this.remarks);
/* 108 */     sb.append(", createTime=").append(this.createTime);
/* 109 */     sb.append(", serialVersionUID=").append(1L);
/* 110 */     sb.append("]");
/* 111 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\Advertisement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */