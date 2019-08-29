/*    */ package com.tiger.pojo;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public class UserRelation
/*    */ {
/*    */   private Integer id;
/*    */   private String inviteCode;
/*    */   private Integer beInviteId;
/*    */   private Date createTime;
/*    */   
/*    */   public Integer getId()
/*    */   {
/* 15 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 19 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getInviteCode() {
/* 23 */     return this.inviteCode;
/*    */   }
/*    */   
/*    */   public void setInviteCode(String inviteCode) {
/* 27 */     this.inviteCode = (inviteCode == null ? null : inviteCode.trim());
/*    */   }
/*    */   
/*    */   public Integer getBeInviteId() {
/* 31 */     return this.beInviteId;
/*    */   }
/*    */   
/*    */   public void setBeInviteId(Integer beInviteId) {
/* 35 */     this.beInviteId = beInviteId;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 39 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 43 */     this.createTime = createTime;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\pojo\UserRelation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */