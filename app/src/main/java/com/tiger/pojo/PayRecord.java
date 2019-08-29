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
/*     */ @Table(name="`pay_record`")
/*     */ public class PayRecord
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`account`")
/*     */   private String account;
/*     */   @Column(name="`pay_down_num`")
/*     */   private Integer payDownNum;
/*     */   @Column(name="`creator`")
/*     */   private Integer creator;
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
/*     */   public String getAccount()
/*     */   {
/*  46 */     return this.account;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccount(String account)
/*     */   {
/*  53 */     this.account = (account == null ? null : account.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPayDownNum()
/*     */   {
/*  60 */     return this.payDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPayDownNum(Integer payDownNum)
/*     */   {
/*  67 */     this.payDownNum = payDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getCreator()
/*     */   {
/*  74 */     return this.creator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreator(Integer creator)
/*     */   {
/*  81 */     this.creator = creator;
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
/* 105 */     sb.append(", account=").append(this.account);
/* 106 */     sb.append(", payDownNum=").append(this.payDownNum);
/* 107 */     sb.append(", creator=").append(this.creator);
/* 108 */     sb.append(", createTime=").append(this.createTime);
/* 109 */     sb.append(", serialVersionUID=").append(1L);
/* 110 */     sb.append("]");
/* 111 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\PayRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */