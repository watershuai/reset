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
/*     */ @Table(name="`cert_manage`")
/*     */ public class CertManage
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Integer id;
/*     */   @Column(name="`cert_name`")
/*     */   private String certName;
/*     */   @Column(name="`max_num`")
/*     */   private Integer maxNum;
/*     */   @Column(name="`meal_type`")
/*     */   private Integer mealType;
/*     */   @Column(name="`cert_status`")
/*     */   private Integer certStatus;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   @Column(name="`use_num`")
/*     */   private Integer useNum;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  50 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCertName()
/*     */   {
/*  64 */     return this.certName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCertName(String certName)
/*     */   {
/*  71 */     this.certName = (certName == null ? null : certName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getMaxNum()
/*     */   {
/*  80 */     return this.maxNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaxNum(Integer maxNum)
/*     */   {
/*  89 */     this.maxNum = maxNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getMealType()
/*     */   {
/*  98 */     return this.mealType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMealType(Integer mealType)
/*     */   {
/* 107 */     this.mealType = mealType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCertStatus()
/*     */   {
/* 116 */     return this.certStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCertStatus(Integer certStatus)
/*     */   {
/* 125 */     this.certStatus = certStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 132 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 139 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 146 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 153 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public Integer getUseNum() {
/* 157 */     return this.useNum;
/*     */   }
/*     */   
/*     */   public void setUseNum(Integer useNum) {
/* 161 */     this.useNum = useNum;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 166 */     StringBuilder sb = new StringBuilder();
/* 167 */     sb.append(getClass().getSimpleName());
/* 168 */     sb.append(" [");
/* 169 */     sb.append("Hash = ").append(hashCode());
/* 170 */     sb.append(", id=").append(this.id);
/* 171 */     sb.append(", certName=").append(this.certName);
/* 172 */     sb.append(", maxNum=").append(this.maxNum);
/* 173 */     sb.append(", mealType=").append(this.mealType);
/* 174 */     sb.append(", certStatus=").append(this.certStatus);
/* 175 */     sb.append(", createTime=").append(this.createTime);
/* 176 */     sb.append(", updateTime=").append(this.updateTime);
/* 177 */     sb.append(", serialVersionUID=").append(1L);
/* 178 */     sb.append("]");
/* 179 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\CertManage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */