package com.tiger.service;

import com.tiger.model.AppDownloadData;
import com.tiger.pojo.App;
import com.tiger.pojo.UserAppDownloadCount;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface UserAppDownloadCountService
  extends BaseService<UserAppDownloadCount>
{
  public abstract boolean addUserAppDownloadCountRecord(App paramApp, Integer paramInteger);
  
  public abstract List<AppDownloadData> getAppDownloadDataCountByTimeInterval(String paramString1, String paramString2);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\UserAppDownloadCountService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */