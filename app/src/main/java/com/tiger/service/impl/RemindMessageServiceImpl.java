/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.RemindMessageMapper;
/*    */ import com.tiger.pojo.RemindMessage;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.RemindMessageService;
/*    */ import com.yz.common.core.utils.DateUtils;
/*    */ import java.util.Calendar;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class RemindMessageServiceImpl
/*    */   extends BaseServiceManager<RemindMessage, RemindMessageMapper>
/*    */   implements RemindMessageService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(RemindMessageMapper dao)
/*    */   {
/* 24 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public RemindMessage getLastSevenDayByUserId(Integer userId)
/*    */   {
/* 29 */     Calendar calendar = Calendar.getInstance();
/* 30 */     String endTime = DateUtils.FormatFullDate(calendar.getTime());
/* 31 */     calendar.add(6, -7);
/* 32 */     calendar.set(11, 0);
/* 33 */     calendar.set(12, 0);
/* 34 */     calendar.set(13, 0);
/* 35 */     calendar.set(14, 0);
/* 36 */     String startTime = DateUtils.FormatFullDate(calendar.getTime());
/* 37 */     List<RemindMessage> remindMessages = ((RemindMessageMapper)this.dao).selectByTimeIntervalAndUserId(startTime, endTime, userId);
/* 38 */     if (CollectionUtils.isEmpty(remindMessages)) {
/* 39 */       return null;
/*    */     }
/* 41 */     return (RemindMessage)remindMessages.get(0);
/*    */   }
/*    */   
/*    */   public List<RemindMessage> selectPageList(RemindMessage remindMessage, int pageIndex, int pageSize)
/*    */   {
/* 46 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\RemindMessageServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */