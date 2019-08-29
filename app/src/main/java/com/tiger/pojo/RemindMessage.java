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
/*     */ @Table(name="`remind_message`")
/*     */ public class RemindMessage
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="`id`")
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(name="`user_id`")
/*     */   private Integer userId;
/*     */   @Column(name="`phone`")
/*     */   private String phone;
/*     */   @Column(name="`content`")
/*     */   private String content;
/*     */   @Column(name="`num`")
/*     */   private Integer num;
/*     */   @Column(name="`flag`")
/*     */   private Integer flag;
/*     */   @Column(name="`next_send`")
/*     */   private String nextSend;
/*     */   @Column(name="`create_time`")
/*     */   private Date createTime;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  53 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  60 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getUserId()
/*     */   {
/*  67 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Integer userId)
/*     */   {
/*  74 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/*  81 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/*  88 */     this.phone = (phone == null ? null : phone.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  97 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 106 */     this.content = (content == null ? null : content.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getNum()
/*     */   {
/* 115 */     return this.num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNum(Integer num)
/*     */   {
/* 124 */     this.num = num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getFlag()
/*     */   {
/* 133 */     return this.flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFlag(Integer flag)
/*     */   {
/* 142 */     this.flag = flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNextSend()
/*     */   {
/* 151 */     return this.nextSend;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNextSend(String nextSend)
/*     */   {
/* 160 */     this.nextSend = (nextSend == null ? null : nextSend.trim());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 167 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 174 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 179 */     StringBuilder sb = new StringBuilder();
/* 180 */     sb.append(getClass().getSimpleName());
/* 181 */     sb.append(" [");
/* 182 */     sb.append("Hash = ").append(hashCode());
/* 183 */     sb.append(", id=").append(this.id);
/* 184 */     sb.append(", userId=").append(this.userId);
/* 185 */     sb.append(", phone=").append(this.phone);
/* 186 */     sb.append(", content=").append(this.content);
/* 187 */     sb.append(", num=").append(this.num);
/* 188 */     sb.append(", flag=").append(this.flag);
/* 189 */     sb.append(", nextSend=").append(this.nextSend);
/* 190 */     sb.append(", createTime=").append(this.createTime);
/* 191 */     sb.append(", serialVersionUID=").append(1L);
/* 192 */     sb.append("]");
/* 193 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\RemindMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */