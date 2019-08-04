package com.water.reset.service;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public interface IHttpCheck {
   String advanceResult(String result);

   Boolean resultRetry(String result);
}
