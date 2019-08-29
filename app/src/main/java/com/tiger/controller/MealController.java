/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.tiger.pojo.AutoSignMeal;
/*    */ import com.tiger.service.MealService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class MealController
/*    */ {
/*    */   @Resource
/*    */   private MealService mealService;
/*    */   
/*    */   @RequestMapping({"/meal/list"})
/*    */   public Object getMealList()
/*    */   {
/* 24 */     List<AutoSignMeal> autoSignMeals = this.mealService.selectList(new AutoSignMeal());
/* 25 */     return autoSignMeals;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/meal/type/list"})
/*    */   public Object getMealTypeList() {
/* 30 */     return this.mealService.getAutoSignMealTypeList();
/*    */   }
/*    */   
/*    */   @RequestMapping({"/meal/list_mealId"})
/*    */   public Object getMealListByMealId(Long mealId) {
/* 35 */     AutoSignMeal autoSignMeal = (AutoSignMeal)this.mealService.selectById(mealId);
/* 36 */     Integer mealTypeId = autoSignMeal.getMealTypeId();
/* 37 */     autoSignMeal = new AutoSignMeal();
/* 38 */     autoSignMeal.setMealTypeId(mealTypeId);
/* 39 */     List<AutoSignMeal> autoSignMeals = this.mealService.selectList(autoSignMeal);
/* 40 */     return autoSignMeals;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\MealController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */