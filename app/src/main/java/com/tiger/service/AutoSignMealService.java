package com.tiger.service;

import com.tiger.pojo.AutoSignMeal;
import com.tiger.pojo.AutoSignMealType;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface AutoSignMealService
  extends BaseService<AutoSignMeal>
{
  public abstract List<AutoSignMealType> getAutoSignMealTypeList();
  
  public abstract AutoSignMealType getAutoSignMealTypeById(Integer paramInteger);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AutoSignMealService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */