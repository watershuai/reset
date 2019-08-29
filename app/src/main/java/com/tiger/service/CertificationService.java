package com.tiger.service;

import com.tiger.pojo.Certification;
import com.yz.common.core.exception.HandlerException;
import com.yz.common.core.service.BaseService;

public abstract interface CertificationService
  extends BaseService<Certification>
{
  public abstract boolean updateByUserId(Certification paramCertification)
    throws HandlerException;
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\CertificationService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */