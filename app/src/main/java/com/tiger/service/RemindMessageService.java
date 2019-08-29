package com.tiger.service;

import com.tiger.pojo.RemindMessage;
import com.yz.common.core.service.BaseService;

public abstract interface RemindMessageService
  extends BaseService<RemindMessage>
{
  public abstract RemindMessage getLastSevenDayByUserId(Integer paramInteger);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\RemindMessageService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */