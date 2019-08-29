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
/*     */ @Table(name="`auto_sign_meal`")
/*     */ public class AutoSignMeal
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Integer id;
/*     */   @Column(name="`meal_type_id`")
/*     */   private Integer mealTypeId;
/*     */   @Column(name="`effective_days`")
/*     */   private Integer effectiveDays;
/*     */   @Column(name="`meal_price`")
/*     */   private Integer mealPrice;
/*     */   @Column(name="`free_update_num`")
/*     */   private Integer freeUpdateNum;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  41 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  48 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getMealTypeId()
/*     */   {
/*  55 */     return this.mealTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMealTypeId(Integer mealTypeId)
/*     */   {
/*  62 */     this.mealTypeId = mealTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getEffectiveDays()
/*     */   {
/*  71 */     return this.effectiveDays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEffectiveDays(Integer effectiveDays)
/*     */   {
/*  80 */     this.effectiveDays = effectiveDays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getMealPrice()
/*     */   {
/*  87 */     return this.mealPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMealPrice(Integer mealPrice)
/*     */   {
/*  94 */     this.mealPrice = mealPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getFreeUpdateNum()
/*     */   {
/* 101 */     return this.freeUpdateNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFreeUpdateNum(Integer freeUpdateNum)
/*     */   {
/* 108 */     this.freeUpdateNum = freeUpdateNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 115 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 122 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 129 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 136 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append(getClass().getSimpleName());
/* 143 */     sb.append(" [");
/* 144 */     sb.append("Hash = ").append(hashCode());
/* 145 */     sb.append(", id=").append(this.id);
/* 146 */     sb.append(", mealTypeId=").append(this.mealTypeId);
/* 147 */     sb.append(", effectiveDays=").append(this.effectiveDays);
/* 148 */     sb.append(", mealPrice=").append(this.mealPrice);
/* 149 */     sb.append(", freeUpdateNum=").append(this.freeUpdateNum);
/* 150 */     sb.append(", createTime=").append(this.createTime);
/* 151 */     sb.append(", updateTime=").append(this.updateTime);
/* 152 */     sb.append(", serialVersionUID=").append(1L);
/* 153 */     sb.append("]");
/* 154 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AutoSignMeal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */