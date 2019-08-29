package com.tiger.controller.bms;

import com.tiger.service.MealService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("bmsMealController")
@RequestMapping({"/bms"})
public class MealController
{
  @Resource
  private MealService mealService;
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\bms\MealController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */