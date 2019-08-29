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
/*     */ 
/*     */ @Table(name="`auto_sign_order`")
/*     */ public class AutoSignOrder
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`user_id`")
/*     */   private Long userId;
/*     */   @Column(name="`pay_way`")
/*     */   private Integer payWay;
/*     */   @Column(name="`order_num`")
/*     */   private String orderNum;
/*     */   @Column(name="`auto_sign_app_id`")
/*     */   private Long autoSignAppId;
/*     */   @Column(name="`task_num`")
/*     */   private Long taskNum;
/*     */   @Column(name="`price`")
/*     */   private Integer price;
/*     */   @Column(name="`order_status`")
/*     */   private Integer orderStatus;
/*     */   @Column(name="`order_desc`")
/*     */   private String orderDesc;
/*     */   @Column(name="`business_data`")
/*     */   private String businessData;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   @Column(name="`update_time`")
/*     */   private Date updateTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  59 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getOrderNum()
/*     */   {
/*  73 */     return this.orderNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOrderNum(String orderNum)
/*     */   {
/*  80 */     this.orderNum = (orderNum == null ? null : orderNum.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getTaskNum()
/*     */   {
/*  87 */     return this.taskNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaskNum(Long taskNum)
/*     */   {
/*  94 */     this.taskNum = taskNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPrice()
/*     */   {
/* 101 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrice(Integer price)
/*     */   {
/* 108 */     this.price = price;
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
/*     */   public Integer getOrderStatus() {
/* 140 */     return this.orderStatus;
/*     */   }
/*     */   
/*     */   public void setOrderStatus(Integer orderStatus) {
/* 144 */     this.orderStatus = orderStatus;
/*     */   }
/*     */   
/*     */   public String getOrderDesc() {
/* 148 */     return this.orderDesc;
/*     */   }
/*     */   
/*     */   public void setOrderDesc(String orderDesc) {
/* 152 */     this.orderDesc = orderDesc;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/* 156 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 160 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getAutoSignAppId() {
/* 164 */     return this.autoSignAppId;
/*     */   }
/*     */   
/*     */   public void setAutoSignAppId(Long autoSignAppId) {
/* 168 */     this.autoSignAppId = autoSignAppId;
/*     */   }
/*     */   
/*     */   public String getBusinessData() {
/* 172 */     return this.businessData;
/*     */   }
/*     */   
/*     */   public void setBusinessData(String businessData) {
/* 176 */     this.businessData = businessData;
/*     */   }
/*     */   
/*     */   public Integer getPayWay() {
/* 180 */     return this.payWay;
/*     */   }
/*     */   
/*     */   public void setPayWay(Integer payWay) {
/* 184 */     this.payWay = payWay;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 189 */     StringBuilder sb = new StringBuilder();
/* 190 */     sb.append(getClass().getSimpleName());
/* 191 */     sb.append(" [");
/* 192 */     sb.append("Hash = ").append(hashCode());
/* 193 */     sb.append(", id=").append(this.id);
/* 194 */     sb.append(", orderNum=").append(this.orderNum);
/* 195 */     sb.append(", taskNum=").append(this.taskNum);
/* 196 */     sb.append(", price=").append(this.price);
/* 197 */     sb.append(", createTime=").append(this.createTime);
/* 198 */     sb.append(", updateTime=").append(this.updateTime);
/* 199 */     sb.append(", serialVersionUID=").append(1L);
/* 200 */     sb.append("]");
/* 201 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\AutoSignOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */