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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Table(name="`certification`")
/*     */ public class Certification
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`Id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`user_id`")
/*     */   private Long userId;
/*     */   @Column(name="`id_card_up_url`")
/*     */   private String idCardUpUrl;
/*     */   @Column(name="`id_card_down_url`")
/*     */   private String idCardDownUrl;
/*     */   @Column(name="`company_license_url`")
/*     */   private String companyLicenseUrl;
/*     */   @Column(name="`finance_license_url`")
/*     */   private String financeLicenseUrl;
/*     */   @Column(name="`network_culture_license_url`")
/*     */   private String networkCultureLicenseUrl;
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
/*     */   public Long getUserId()
/*     */   {
/*  73 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/*  80 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdCardUpUrl()
/*     */   {
/*  89 */     return this.idCardUpUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdCardUpUrl(String idCardUpUrl)
/*     */   {
/*  98 */     this.idCardUpUrl = (idCardUpUrl == null ? null : idCardUpUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdCardDownUrl()
/*     */   {
/* 107 */     return this.idCardDownUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdCardDownUrl(String idCardDownUrl)
/*     */   {
/* 116 */     this.idCardDownUrl = (idCardDownUrl == null ? null : idCardDownUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyLicenseUrl()
/*     */   {
/* 125 */     return this.companyLicenseUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyLicenseUrl(String companyLicenseUrl)
/*     */   {
/* 134 */     this.companyLicenseUrl = (companyLicenseUrl == null ? null : companyLicenseUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFinanceLicenseUrl()
/*     */   {
/* 143 */     return this.financeLicenseUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFinanceLicenseUrl(String financeLicenseUrl)
/*     */   {
/* 152 */     this.financeLicenseUrl = (financeLicenseUrl == null ? null : financeLicenseUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNetworkCultureLicenseUrl()
/*     */   {
/* 161 */     return this.networkCultureLicenseUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetworkCultureLicenseUrl(String networkCultureLicenseUrl)
/*     */   {
/* 170 */     this.networkCultureLicenseUrl = (networkCultureLicenseUrl == null ? null : networkCultureLicenseUrl.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 177 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 184 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 191 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 198 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 203 */     StringBuilder sb = new StringBuilder();
/* 204 */     sb.append(getClass().getSimpleName());
/* 205 */     sb.append(" [");
/* 206 */     sb.append("Hash = ").append(hashCode());
/* 207 */     sb.append(", id=").append(this.id);
/* 208 */     sb.append(", userId=").append(this.userId);
/* 209 */     sb.append(", idCardUpUrl=").append(this.idCardUpUrl);
/* 210 */     sb.append(", idCardDownUrl=").append(this.idCardDownUrl);
/* 211 */     sb.append(", companyLicenseUrl=").append(this.companyLicenseUrl);
/* 212 */     sb.append(", financeLicenseUrl=").append(this.financeLicenseUrl);
/* 213 */     sb.append(", networkCultureLicenseUrl=").append(this.networkCultureLicenseUrl);
/* 214 */     sb.append(", createTime=").append(this.createTime);
/* 215 */     sb.append(", updateTime=").append(this.updateTime);
/* 216 */     sb.append(", serialVersionUID=").append(1L);
/* 217 */     sb.append("]");
/* 218 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\Certification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */