package com.tiger.service;

import com.tiger.pojo.UserBms;
import com.yz.common.core.service.BaseService;

public abstract interface UserBmsService extends BaseService<UserBms>
{
  public abstract UserBms getUserBmsByTokenForCache(String paramString);
}

