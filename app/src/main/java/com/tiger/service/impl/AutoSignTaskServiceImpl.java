/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.AutoSignTaskMapper;
/*    */ import com.tiger.pojo.AutoSignTask;
/*    */ import com.tiger.service.AutoSignTaskService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tk.mybatis.mapper.entity.Example;
/*    */ import tk.mybatis.mapper.entity.Example.Criteria;
/*    */ 
/*    */ @Service
/*    */ public class AutoSignTaskServiceImpl
/*    */   extends BaseServiceManager<AutoSignTask, AutoSignTaskMapper>
/*    */   implements AutoSignTaskService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(AutoSignTaskMapper autoSignTaskMapper)
/*    */   {
/* 21 */     this.dao = autoSignTaskMapper;
/*    */   }
/*    */   
/*    */   public boolean updateByTaskNum(AutoSignTask autoSignTask)
/*    */   {
/* 26 */     Long taskNum = autoSignTask.getTaskNum();
/* 27 */     if (taskNum == null) {
/* 28 */       logger.info("条件参数有误");
/* 29 */       return false;
/*    */     }
/* 31 */     Example example = new Example(AutoSignTask.class);
/* 32 */     example.createCriteria().andEqualTo("taskNum", taskNum);
/* 33 */     autoSignTask.setTaskNum(null);
/* 34 */     int i = ((AutoSignTaskMapper)this.dao).updateByExampleSelective(autoSignTask, example);
/* 35 */     return i >= 1;
/*    */   }
/*    */   
/*    */   public boolean deleteByAutoSignAppId(Long autoSignAppId)
/*    */   {
/* 40 */     Example example = new Example(AutoSignTask.class);
/* 41 */     example.createCriteria().andEqualTo("autoSignAppId", autoSignAppId);
/* 42 */     int i = ((AutoSignTaskMapper)this.dao).deleteByExample(example);
/* 43 */     return i > 1;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\AutoSignTaskServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */