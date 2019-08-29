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
/*    */ @Table(name="`short_link`")
/*    */ public class ShortLink
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name="`id`")
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   private Integer id;
/*    */   @Column(name="`link_value`")
/*    */   private String linkValue;
/*    */   @Column(name="`sl_status`")
/*    */   private Integer slStatus;
/*    */   @Column(name="`create_time`")
/*    */   private Date createTime;
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
/*    */   public String getLinkValue()
/*    */   {
/* 43 */     return this.linkValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setLinkValue(String linkValue)
/*    */   {
/* 50 */     this.linkValue = (linkValue == null ? null : linkValue.trim());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Integer getSlStatus()
/*    */   {
/* 57 */     return this.slStatus;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setSlStatus(Integer slStatus)
/*    */   {
/* 64 */     this.slStatus = slStatus;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Date getCreateTime()
/*    */   {
/* 71 */     return this.createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCreateTime(Date createTime)
/*    */   {
/* 78 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 83 */     StringBuilder sb = new StringBuilder();
/* 84 */     sb.append(getClass().getSimpleName());
/* 85 */     sb.append(" [");
/* 86 */     sb.append("Hash = ").append(hashCode());
/* 87 */     sb.append(", id=").append(this.id);
/* 88 */     sb.append(", linkValue=").append(this.linkValue);
/* 89 */     sb.append(", slStatus=").append(this.slStatus);
/* 90 */     sb.append(", createTime=").append(this.createTime);
/* 91 */     sb.append(", serialVersionUID=").append(1L);
/* 92 */     sb.append("]");
/* 93 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\ShortLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */