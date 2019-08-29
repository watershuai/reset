package com.tiger.service;

import com.tiger.pojo.IconData;
import com.yz.common.core.service.BaseService;

public abstract interface IconDataService
  extends BaseService<IconData>
{
  public abstract IconData getLastVersionIconData(String paramString);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\IconDataService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */