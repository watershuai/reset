package com.tiger.service;

import com.tiger.pojo.AutoSignMeal;
import com.tiger.pojo.AutoSignMealType;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface MealService
  extends BaseService<AutoSignMeal>
{
  public abstract List<AutoSignMealType> getAutoSignMealTypeList();
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\MealService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */