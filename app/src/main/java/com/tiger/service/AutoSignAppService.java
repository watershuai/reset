package com.tiger.service;

import com.tiger.model.Page;
import com.tiger.pojo.AutoSignApp;
import com.yz.common.core.exception.HandlerException;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface AutoSignAppService
  extends BaseService<AutoSignApp>
{
  public abstract List<AutoSignApp> getAutoSignAppList(Page paramPage);
  
  public abstract boolean deleteAutoSignAppById(Long paramLong);
  
  public abstract boolean deleteAutoSignAppByIdAndUserId(Long paramLong1, Long paramLong2);
  
  public abstract List<AutoSignApp> getAutoSignAppListByExpireTimeInterval(String paramString1, String paramString2);
  
  public abstract List<AutoSignApp> likeByAppName(String paramString, Page paramPage);
  
  public abstract AutoSignApp getByIdForCache(Long paramLong);
  
  public abstract boolean supplementSign(AutoSignApp paramAutoSignApp)
    throws HandlerException;
  
  public abstract boolean supplementSignAvailableApp(Long paramLong)
    throws HandlerException;
  
  public abstract boolean supplementSignAvailableAppByCCName(String paramString)
    throws HandlerException;
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AutoSignAppService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */