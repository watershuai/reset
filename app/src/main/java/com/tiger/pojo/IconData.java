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
/*    */ @Table(name="`icon_data`")
/*    */ public class IconData
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name="`id`")
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   private Long id;
/*    */   @Column(name="`bundle_id`")
/*    */   private String bundleId;
/*    */   @Column(name="`create_time`")
/*    */   private Date createTime;
/*    */   @Column(name="`i_data`")
/*    */   private String iData;
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 29 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setId(Long id)
/*    */   {
/* 36 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getBundleId()
/*    */   {
/* 43 */     return this.bundleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setBundleId(String bundleId)
/*    */   {
/* 50 */     this.bundleId = (bundleId == null ? null : bundleId.trim());
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
/*    */   public String getiData()
/*    */   {
/* 71 */     return this.iData;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setiData(String iData)
/*    */   {
/* 78 */     this.iData = (iData == null ? null : iData.trim());
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 83 */     StringBuilder sb = new StringBuilder();
/* 84 */     sb.append(getClass().getSimpleName());
/* 85 */     sb.append(" [");
/* 86 */     sb.append("Hash = ").append(hashCode());
/* 87 */     sb.append(", id=").append(this.id);
/* 88 */     sb.append(", bundleId=").append(this.bundleId);
/* 89 */     sb.append(", createTime=").append(this.createTime);
/* 90 */     sb.append(", iData=").append(this.iData);
/* 91 */     sb.append(", serialVersionUID=").append(1L);
/* 92 */     sb.append("]");
/* 93 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\IconData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */