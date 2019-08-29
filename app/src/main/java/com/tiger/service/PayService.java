package com.tiger.service;

import com.tiger.pojo.Account;
import com.tiger.pojo.MobileConfigAppOrder;
import com.tiger.pojo.PayOrder;
import com.yz.common.core.exception.HandlerException;
import com.yz.common.core.service.BaseService;

public abstract interface PayService
  extends BaseService<PayOrder>
{
  public abstract boolean buyPayDownNum(Account paramAccount)
    throws HandlerException;
  
  public abstract boolean paySuccessHandle(PayOrder paramPayOrder)
    throws HandlerException;
  
  public abstract boolean vipPaySuccessHandle(PayOrder paramPayOrder)
    throws HandlerException;
  
  public abstract boolean makeMobileConfigPaySuccessHandle(MobileConfigAppOrder paramMobileConfigAppOrder)
    throws HandlerException;
  
  public abstract boolean autoSignPaySuccessHandle(String paramString);
  
  public abstract boolean autoSignUpdateNumPaySuccessHandle(String paramString)
    throws HandlerException;
  
  public abstract boolean autoSignDelayPaySuccessHandle(String paramString)
    throws HandlerException;
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\PayService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */