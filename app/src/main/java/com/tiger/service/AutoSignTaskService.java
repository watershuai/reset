package com.tiger.service;

import com.tiger.pojo.AutoSignTask;
import com.yz.common.core.service.BaseService;

public abstract interface AutoSignTaskService
  extends BaseService<AutoSignTask>
{
  public abstract boolean updateByTaskNum(AutoSignTask paramAutoSignTask);
  
  public abstract boolean deleteByAutoSignAppId(Long paramLong);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AutoSignTaskService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */