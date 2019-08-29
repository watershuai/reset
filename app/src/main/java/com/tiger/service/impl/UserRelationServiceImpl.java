/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.UserRelationMapper;
/*    */ import com.tiger.pojo.UserRelation;
/*    */ import com.tiger.service.UserRelationService;
/*    */ import com.yz.common.core.service.BaseServiceManager;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class UserRelationServiceImpl
/*    */   extends BaseServiceManager<UserRelation, UserRelationMapper>
/*    */   implements UserRelationService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(UserRelationMapper dao)
/*    */   {
/* 23 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<UserRelation> selectPageList(UserRelation userRelation, int i, int i1)
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\UserRelationServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */