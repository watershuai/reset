/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.AutoSignMealMapper;
/*    */ import com.tiger.dao.AutoSignMealTypeMapper;
/*    */ import com.tiger.pojo.AutoSignMeal;
/*    */ import com.tiger.pojo.AutoSignMealType;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.MealService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class MealServiceImpl
/*    */   extends BaseServiceManager<AutoSignMeal, AutoSignMealMapper>
/*    */   implements MealService
/*    */ {
/*    */   @Autowired
/*    */   private AutoSignMealTypeMapper autoSignMealTypeMapper;
/*    */   
/*    */   @Autowired
/*    */   public void setDao(AutoSignMealMapper autoSignMealMapper)
/*    */   {
/* 28 */     this.dao = autoSignMealMapper;
/*    */   }
/*    */   
/*    */   public List<AutoSignMealType> getAutoSignMealTypeList()
/*    */   {
/* 33 */     return this.autoSignMealTypeMapper.selectAll();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\MealServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */