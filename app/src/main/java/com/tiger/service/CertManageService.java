package com.tiger.service;

import com.tiger.pojo.CertManage;
import com.yz.common.core.exception.HandlerException;
import com.yz.common.core.service.BaseService;

public abstract interface CertManageService
  extends BaseService<CertManage>
{
  public abstract String getUsableCCName(int paramInt)
    throws HandlerException;
  
  public abstract boolean isUsableByCCName(String paramString);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\CertManageService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */