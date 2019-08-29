package com.tiger.service;

import com.tiger.pojo.AppMerge;
import com.yz.common.core.service.BaseService;

public abstract interface AppMergeService
  extends BaseService<AppMerge>
{
  public abstract AppMerge getByActiveLinkOrPassiveLink(String paramString);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AppMergeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */