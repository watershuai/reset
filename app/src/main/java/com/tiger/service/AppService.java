package com.tiger.service;

import com.tiger.model.Page;
import com.tiger.model.PkgInfo;
import com.tiger.pojo.App;
import com.tiger.pojo.AppUpdateInfo;
import com.yz.common.core.exception.HandlerException;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface AppService
  extends BaseService<App>
{
  public abstract boolean appUpload(PkgInfo paramPkgInfo, int paramInt)
    throws HandlerException;
  
  public abstract List<AppUpdateInfo> getLastVersionInfoByAppIds(List<Long> paramList);
  
  public abstract boolean deleteApp(App paramApp)
    throws HandlerException;
  
  public abstract List<App> getAppForDownNumDesc(App paramApp, Page paramPage);
  
  public abstract List<App> selectPageList(App paramApp, Page paramPage);
  
  public abstract String getAppDownloadLink(App paramApp)
    throws HandlerException;
  
  public abstract String getAppDownloadLink(String paramString1, String paramString2)
    throws HandlerException;
  
  public abstract List<App> likeByAppName(String paramString, Page paramPage);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AppService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */