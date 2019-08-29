package com.tiger.service;

import com.tiger.model.Page;
import com.tiger.pojo.MobileConfigApp;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface MobileConfigAppService
  extends BaseService<MobileConfigApp>
{
  public abstract List<MobileConfigApp> selectPageList(MobileConfigApp paramMobileConfigApp, Page paramPage);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\MobileConfigAppService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */