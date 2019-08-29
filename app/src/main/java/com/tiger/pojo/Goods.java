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
/*     */ @Table(name="`goods`")
/*     */ public class Goods
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Integer id;
/*     */   @Column(name="`pay_num`")
/*     */   private Integer payNum;
/*     */   @Column(name="`give_num`")
/*     */   private Integer giveNum;
/*     */   @Column(name="`price`")
/*     */   private Integer price;
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
/*     */   public Integer getPayNum()
/*     */   {
/*  49 */     return this.payNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPayNum(Integer payNum)
/*     */   {
/*  56 */     this.payNum = payNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getGiveNum()
/*     */   {
/*  63 */     return this.giveNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGiveNum(Integer giveNum)
/*     */   {
/*  70 */     this.giveNum = giveNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPrice()
/*     */   {
/*  77 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrice(Integer price)
/*     */   {
/*  84 */     this.price = price;
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
/* 122 */     sb.append(", payNum=").append(this.payNum);
/* 123 */     sb.append(", giveNum=").append(this.giveNum);
/* 124 */     sb.append(", price=").append(this.price);
/* 125 */     sb.append(", createTime=").append(this.createTime);
/* 126 */     sb.append(", updateTime=").append(this.updateTime);
/* 127 */     sb.append(", serialVersionUID=").append(1L);
/* 128 */     sb.append("]");
/* 129 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\Goods.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */