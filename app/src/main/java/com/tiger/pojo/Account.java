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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Table(name="`account`")
/*     */ public class Account
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Integer id;
/*     */   @Column(name="`account`")
/*     */   private String account;
/*     */   @Column(name="`password`")
/*     */   private String password;
/*     */   @Column(name="`token`")
/*     */   private String token;
/*     */   @Column(name="`free_down_num`")
/*     */   private Integer freeDownNum;
/*     */   @Column(name="`pay_down_num`")
/*     */   private Integer payDownNum;
/*     */   @Column(name="`mobileconfig_down_num`")
/*     */   private Long mobileconfigDownNum;
/*     */   @Column(name="`is_vip`")
/*     */   private Integer isVip;
/*     */   @Column(name="`vip_expire_time`")
/*     */   private Date vipExpireTime;
/*     */   @Column(name="`type`")
/*     */   private Integer type;
/*     */   @Column(name="`ca_status`")
/*     */   private Integer caStatus;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  62 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  69 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAccount()
/*     */   {
/*  76 */     return this.account;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccount(String account)
/*     */   {
/*  83 */     this.account = (account == null ? null : account.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPassword()
/*     */   {
/*  90 */     return this.password;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/*  97 */     this.password = (password == null ? null : password.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getToken()
/*     */   {
/* 104 */     return this.token;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToken(String token)
/*     */   {
/* 111 */     this.token = (token == null ? null : token.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getFreeDownNum()
/*     */   {
/* 118 */     return this.freeDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFreeDownNum(Integer freeDownNum)
/*     */   {
/* 125 */     this.freeDownNum = freeDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPayDownNum()
/*     */   {
/* 132 */     return this.payDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPayDownNum(Integer payDownNum)
/*     */   {
/* 139 */     this.payDownNum = payDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getMobileconfigDownNum()
/*     */   {
/* 146 */     return this.mobileconfigDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMobileconfigDownNum(Long mobileconfigDownNum)
/*     */   {
/* 153 */     this.mobileconfigDownNum = mobileconfigDownNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getVipExpireTime()
/*     */   {
/* 163 */     return this.vipExpireTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVipExpireTime(Date vipExpireTime)
/*     */   {
/* 172 */     this.vipExpireTime = vipExpireTime;
/*     */   }
/*     */   
/*     */   public Integer getType() {
/* 176 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Integer type) {
/* 180 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 187 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 194 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Integer getIsVip() {
/* 198 */     return this.isVip;
/*     */   }
/*     */   
/*     */   public void setIsVip(Integer isVip) {
/* 202 */     this.isVip = isVip;
/*     */   }
/*     */   
/*     */   public Integer getCaStatus() {
/* 206 */     return this.caStatus;
/*     */   }
/*     */   
/*     */   public void setCaStatus(Integer caStatus) {
/* 210 */     this.caStatus = caStatus;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 215 */     StringBuilder sb = new StringBuilder();
/* 216 */     sb.append(getClass().getSimpleName());
/* 217 */     sb.append(" [");
/* 218 */     sb.append("Hash = ").append(hashCode());
/* 219 */     sb.append(", id=").append(this.id);
/* 220 */     sb.append(", account=").append(this.account);
/* 221 */     sb.append(", password=").append(this.password);
/* 222 */     sb.append(", token=").append(this.token);
/* 223 */     sb.append(", freeDownNum=").append(this.freeDownNum);
/* 224 */     sb.append(", payDownNum=").append(this.payDownNum);
/* 225 */     sb.append(", mobileconfigDownNum=").append(this.mobileconfigDownNum);
/* 226 */     sb.append(", isVip=").append(this.isVip);
/* 227 */     sb.append(", vipExpireTime=").append(this.vipExpireTime);
/* 228 */     sb.append(", type=").append(this.type);
/* 229 */     sb.append(", caStatus=").append(this.caStatus);
/* 230 */     sb.append(", createTime=").append(this.createTime);
/* 231 */     sb.append(", serialVersionUID=").append(1L);
/* 232 */     sb.append("]");
/* 233 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\Account.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */