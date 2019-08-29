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
/*     */ @Table(name="`pay_order`")
/*     */ public class PayOrder
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`account_id`")
/*     */   private Long accountId;
/*     */   @Column(name="`order_id`")
/*     */   private String orderId;
/*     */   @Column(name="`pay_way`")
/*     */   private Integer payWay;
/*     */   @Column(name="`goods_name`")
/*     */   private String goodsName;
/*     */   @Column(name="`goods_price`")
/*     */   private Integer goodsPrice;
/*     */   @Column(name="`pay_down_num`")
/*     */   private Integer payDownNum;
/*     */   @Column(name="`order_status`")
/*     */   private Integer orderStatus;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  50 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getAccountId()
/*     */   {
/*  64 */     return this.accountId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccountId(Long accountId)
/*     */   {
/*  71 */     this.accountId = accountId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getOrderId()
/*     */   {
/*  78 */     return this.orderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOrderId(String orderId)
/*     */   {
/*  85 */     this.orderId = (orderId == null ? null : orderId.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getGoodsName()
/*     */   {
/*  92 */     return this.goodsName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGoodsName(String goodsName)
/*     */   {
/*  99 */     this.goodsName = (goodsName == null ? null : goodsName.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getGoodsPrice()
/*     */   {
/* 106 */     return this.goodsPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGoodsPrice(Integer goodsPrice)
/*     */   {
/* 113 */     this.goodsPrice = goodsPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPayDownNum()
/*     */   {
/* 120 */     return this.payDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPayDownNum(Integer payDownNum)
/*     */   {
/* 127 */     this.payDownNum = payDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrderStatus()
/*     */   {
/* 136 */     return this.orderStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderStatus(Integer orderStatus)
/*     */   {
/* 145 */     this.orderStatus = orderStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 152 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 159 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 166 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 173 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public Integer getPayWay() {
/* 177 */     return this.payWay;
/*     */   }
/*     */   
/*     */   public void setPayWay(Integer payWay) {
/* 181 */     this.payWay = payWay;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 186 */     StringBuilder sb = new StringBuilder();
/* 187 */     sb.append(getClass().getSimpleName());
/* 188 */     sb.append(" [");
/* 189 */     sb.append("Hash = ").append(hashCode());
/* 190 */     sb.append(", id=").append(this.id);
/* 191 */     sb.append(", accountId=").append(this.accountId);
/* 192 */     sb.append(", orderId=").append(this.orderId);
/* 193 */     sb.append(", goodsName=").append(this.goodsName);
/* 194 */     sb.append(", goodsPrice=").append(this.goodsPrice);
/* 195 */     sb.append(", payDownNum=").append(this.payDownNum);
/* 196 */     sb.append(", orderStatus=").append(this.orderStatus);
/* 197 */     sb.append(", createTime=").append(this.createTime);
/* 198 */     sb.append(", updateTime=").append(this.updateTime);
/* 199 */     sb.append(", serialVersionUID=").append(1L);
/* 200 */     sb.append("]");
/* 201 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\PayOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */