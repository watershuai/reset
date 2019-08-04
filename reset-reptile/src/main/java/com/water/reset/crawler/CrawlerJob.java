package com.water.reset.crawler;


import com.water.reset.service.IHttpCheck;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public abstract class CrawlerJob implements IHttpCheck {


   public abstract void grasp();

   @Override
   public String advanceResult(String result) {
      return result;
   }

   @Override
   public Boolean resultRetry(String result) {
      return true;
   }

}
