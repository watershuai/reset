/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.UserAppDownloadCountMapper;
/*    */ import com.tiger.model.AppDownloadData;
/*    */ import com.tiger.pojo.App;
/*    */ import com.tiger.pojo.UserAppDownloadCount;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.UserAppDownloadCountService;
/*    */ import com.yz.common.core.utils.DateUtils;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class UserAppDownloadCountServiceImpl
/*    */   extends BaseServiceManager<UserAppDownloadCount, UserAppDownloadCountMapper>
/*    */   implements UserAppDownloadCountService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(UserAppDownloadCountMapper dao)
/*    */   {
/* 25 */     this.dao = dao;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean addUserAppDownloadCountRecord(App app, Integer userId)
/*    */   {
/* 31 */     UserAppDownloadCount userAppDownloadCount = new UserAppDownloadCount();
/* 32 */     userAppDownloadCount.setUserId(userId);
/* 33 */     userAppDownloadCount.setAppId(app.getId());
/* 34 */     Date now = new Date();
/* 35 */     userAppDownloadCount.setCountTime(DateUtils.FormatDate(now));
/*    */     
/* 37 */     UserAppDownloadCount uadc = (UserAppDownloadCount)selectOne(userAppDownloadCount);
/* 38 */     boolean result = false;
/* 39 */     if (uadc == null) {
/* 40 */       userAppDownloadCount.setAppName(app.getAppName());
/* 41 */       userAppDownloadCount.setAppOsName(app.getOsName());
/* 42 */       userAppDownloadCount.setNum(Integer.valueOf(1));
/* 43 */       userAppDownloadCount.setCreateTime(now);
/* 44 */       result = insert(userAppDownloadCount);
/* 45 */       if (!result) {
/* 46 */         logger.error("用户应用下载统计添加记录失败");
/*    */       }
/*    */     } else {
/* 49 */       UserAppDownloadCount uadcUpdate = (UserAppDownloadCount)selectOne(userAppDownloadCount);
/* 50 */       uadcUpdate.setId(uadc.getId());
/* 51 */       uadcUpdate.setNum(Integer.valueOf(uadc.getNum().intValue() + 1));
/* 52 */       result = update(uadcUpdate);
/* 53 */       if (!result) {
/* 54 */         logger.error("修改用户应用下载统计次数失败");
/*    */       }
/*    */     }
/* 57 */     return result;
/*    */   }
/*    */   
/*    */   public List<UserAppDownloadCount> selectPageList(UserAppDownloadCount userAppDownloadCount, int pageIndex, int pageSize)
/*    */   {
/* 62 */     return null;
/*    */   }
/*    */   
/*    */   public List<AppDownloadData> getAppDownloadDataCountByTimeInterval(String startTime, String endTime)
/*    */   {
/* 67 */     return ((UserAppDownloadCountMapper)this.dao).selectAppDownloadDataCountByTimeInterval(startTime, endTime);
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\UserAppDownloadCountServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */