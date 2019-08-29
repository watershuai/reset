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
/*     */ @Table(name="`mobileconfig_app_order`")
/*     */ public class MobileConfigAppOrder
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`order_num`")
/*     */   private String orderNum;
/*     */   @Column(name="`pay_way`")
/*     */   private Integer payWay;
/*     */   @Column(name="`user_id`")
/*     */   private Long userId;
/*     */   @Column(name="`mobileconfig_app_id`")
/*     */   private Long mobileconfigAppId;
/*     */   @Column(name="`price`")
/*     */   private Integer price;
/*     */   @Column(name="`order_status`")
/*     */   private Integer orderStatus;
/*     */   @Column(name="`order_desc`")
/*     */   private String orderDesc;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  52 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPayWay()
/*     */   {
/*  68 */     return this.payWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayWay(Integer payWay)
/*     */   {
/*  77 */     this.payWay = payWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/*  84 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/*  91 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getMobileconfigAppId()
/*     */   {
/*  98 */     return this.mobileconfigAppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMobileconfigAppId(Long mobileconfigAppId)
/*     */   {
/* 105 */     this.mobileconfigAppId = mobileconfigAppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPrice()
/*     */   {
/* 112 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrice(Integer price)
/*     */   {
/* 119 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrderStatus()
/*     */   {
/* 128 */     return this.orderStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderStatus(Integer orderStatus)
/*     */   {
/* 137 */     this.orderStatus = orderStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 144 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 151 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 158 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 165 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getOrderNum() {
/* 169 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(String orderNum) {
/* 173 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public String getOrderDesc() {
/* 177 */     return this.orderDesc;
/*     */   }
/*     */   
/*     */   public void setOrderDesc(String orderDesc) {
/* 181 */     this.orderDesc = orderDesc;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 186 */     StringBuilder sb = new StringBuilder();
/* 187 */     sb.append(getClass().getSimpleName());
/* 188 */     sb.append(" [");
/* 189 */     sb.append("Hash = ").append(hashCode());
/* 190 */     sb.append(", id=").append(this.id);
/* 191 */     sb.append(", payWay=").append(this.payWay);
/* 192 */     sb.append(", userId=").append(this.userId);
/* 193 */     sb.append(", mobileconfigAppId=").append(this.mobileconfigAppId);
/* 194 */     sb.append(", price=").append(this.price);
/* 195 */     sb.append(", orderStatus=").append(this.orderStatus);
/* 196 */     sb.append(", createTime=").append(this.createTime);
/* 197 */     sb.append(", updateTime=").append(this.updateTime);
/* 198 */     sb.append(", serialVersionUID=").append(1L);
/* 199 */     sb.append("]");
/* 200 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\MobileConfigAppOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */