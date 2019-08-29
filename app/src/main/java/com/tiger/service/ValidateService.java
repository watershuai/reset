package com.tiger.service;

import com.yz.common.core.exception.HandlerException;
import java.util.concurrent.TimeUnit;

public abstract interface ValidateService
{
  public abstract boolean validateSmsCode(String paramString1, String paramString2, String paramString3)
    throws HandlerException;
  
  public abstract boolean validatePictureVerifyCode(String paramString1, String paramString2)
    throws HandlerException;
  
  public abstract String generatePictureVerifyCode(int paramInt, String paramString, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\ValidateService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */