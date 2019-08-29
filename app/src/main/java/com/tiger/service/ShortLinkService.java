package com.tiger.service;

import com.tiger.pojo.ShortLink;
import com.yz.common.core.service.BaseService;

public abstract interface ShortLinkService
  extends BaseService<ShortLink>
{
  public abstract String getShortLink();
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\ShortLinkService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */