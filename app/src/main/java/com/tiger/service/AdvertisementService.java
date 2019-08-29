package com.tiger.service;

import com.tiger.pojo.Advertisement;
import com.yz.common.core.service.BaseService;

public abstract interface AdvertisementService
  extends BaseService<Advertisement>
{
  public abstract Advertisement getRandomAdvertisement();
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AdvertisementService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */