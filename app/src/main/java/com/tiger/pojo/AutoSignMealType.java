/*    */ package com.tiger.pojo;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Table(name="`auto_sign_meal_type`")
/*    */ public class AutoSignMealType
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name="`id`")
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   private Integer id;
/*    */   @Column(name="`meal_name`")
/*    */   private String mealName;
/*    */   @Column(name="`create_time`")
/*    */   private Date createTime;
/*    */   @Column(name="`update_time`")
/*    */   private Date updateTime;
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Integer getId()
/*    */   {
/* 29 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 36 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getMealName()
/*    */   {
/* 43 */     return this.mealName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setMealName(String mealName)
/*    */   {
/* 50 */     this.mealName = (mealName == null ? null : mealName.trim());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Date getCreateTime()
/*    */   {
/* 57 */     return this.createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCreateTime(Date createTime)
/*    */   {
/* 64 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Date getUpdateTime()
/*    */   {
/* 71 */     return this.updateTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setUpdateTime(Date updateTime)
/*    */   {
/* 78 */     this.updateTime = updateTime;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 83 */     StringBuilder sb = new StringBuilder();
/* 84 */     sb.append(getClass().getSimpleName());
/* 85 */     sb.append(" [");
/* 86 */     sb.append("Hash = ").append(hashCode());
/* 87 */     sb.append(", id=").append(this.id);
/* 88 */     sb.append(", mealName=").append(this.mealName);
/* 89 */     sb.append(", createTime=").append(this.createTime);
/* 90 */     sb.append(", updateTime=").append(this.updateTime);
/* 91 */     sb.append(", serialVersionUID=").append(1L);
/* 92 */     sb.append("]");
/* 93 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AutoSignMealType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */