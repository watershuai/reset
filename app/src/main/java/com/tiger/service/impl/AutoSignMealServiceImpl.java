/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.AutoSignMealMapper;
/*    */ import com.tiger.dao.AutoSignMealTypeMapper;
/*    */ import com.tiger.pojo.AutoSignMeal;
/*    */ import com.tiger.pojo.AutoSignMealType;
/*    */ import com.tiger.service.AutoSignMealService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class AutoSignMealServiceImpl
/*    */   extends BaseServiceManager<AutoSignMeal, AutoSignMealMapper>
/*    */   implements AutoSignMealService
/*    */ {
/*    */   @Autowired
/*    */   private AutoSignMealTypeMapper autoSignMealTypeMapper;
/*    */   
/*    */   @Autowired
/*    */   public void setDao(AutoSignMealMapper mealMapper)
/*    */   {
/* 28 */     this.dao = mealMapper;
/*    */   }
/*    */   
/*    */   public List<AutoSignMealType> getAutoSignMealTypeList()
/*    */   {
/* 33 */     return this.autoSignMealTypeMapper.selectAll();
/*    */   }
/*    */   
/*    */   public AutoSignMealType getAutoSignMealTypeById(Integer id)
/*    */   {
/* 38 */     AutoSignMealType autoSignMealType = new AutoSignMealType();
/* 39 */     autoSignMealType.setId(id);
/* 40 */     autoSignMealType = (AutoSignMealType)this.autoSignMealTypeMapper.selectOne(autoSignMealType);
/* 41 */     return autoSignMealType;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\AutoSignMealServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */