/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.tiger.dao.AutoSignOrderMapper;
/*    */ import com.tiger.pojo.AutoSignOrder;
/*    */ import com.tiger.service.AutoSignAppService;
/*    */ import com.tiger.service.AutoSignMealService;
/*    */ import com.tiger.service.AutoSignOrderService;
/*    */ import com.tiger.service.AutoSignTaskService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.yz.common.core.utils.StringUtils;
/*    */ import java.util.List;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.amqp.core.AmqpTemplate;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tk.mybatis.mapper.entity.Example;
/*    */ import tk.mybatis.mapper.entity.Example.Criteria;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class AutoSignOrderServiceImpl
/*    */   extends BaseServiceManager<AutoSignOrder, AutoSignOrderMapper>
/*    */   implements AutoSignOrderService
/*    */ {
/*    */   @Autowired
/*    */   private AutoSignTaskService autoSignTaskService;
/*    */   @Autowired
/*    */   private AutoSignAppService autoSignAppService;
/*    */   @Autowired
/*    */   private AutoSignMealService autoSignMealService;
/*    */   @Autowired
/*    */   private AmqpTemplate amqpTemplate;
/*    */   
/*    */   @Autowired
/*    */   public void setDao(AutoSignOrderMapper autoSignOrderMapper)
/*    */   {
/* 48 */     this.dao = autoSignOrderMapper;
/*    */   }
/*    */   
/*    */   public boolean updateByOrderNum(AutoSignOrder autoSignOrder)
/*    */   {
/* 53 */     if (StringUtils.isEmpty(autoSignOrder.getOrderNum())) {
/* 54 */       logger.warn("orderNum is empty");
/* 55 */       return false;
/*    */     }
/* 57 */     Example example = new Example(AutoSignOrder.class);
/* 58 */     example.createCriteria().andEqualTo("orderNum", autoSignOrder.getOrderNum());
/* 59 */     autoSignOrder.setOrderNum(null);
/* 60 */     int i = ((AutoSignOrderMapper)this.dao).updateByExampleSelective(autoSignOrder, example);
/* 61 */     return i > 0;
/*    */   }
/*    */   
/*    */   public List<AutoSignOrder> selectList(AutoSignOrder autoSignOrder, com.tiger.model.Page page)
/*    */   {
/* 66 */     PageHelper.orderBy("create_time desc");
/* 67 */     if ((page.getIndex() > 0) && (page.getPageSize() > 0)) {
/* 68 */       PageHelper.startPage(page.getIndex(), page.getPageSize());
/*    */     }
/* 70 */     com.github.pagehelper.Page<AutoSignOrder> autoSignOrderPage = (com.github.pagehelper.Page)((AutoSignOrderMapper)this.dao).select(autoSignOrder);
/* 71 */     page.setTotalPage(autoSignOrderPage.getPages());
/* 72 */     page.setDataList(autoSignOrderPage.getResult());
/* 73 */     return autoSignOrderPage.getResult();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\AutoSignOrderServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */