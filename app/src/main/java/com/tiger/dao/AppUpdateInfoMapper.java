package com.tiger.dao;

import com.tiger.pojo.AppUpdateInfo;
import com.tiger.utils.MapperUtils;
import java.util.List;

public abstract interface AppUpdateInfoMapper
  extends MapperUtils<AppUpdateInfo>
{
  public abstract List<AppUpdateInfo> queryLastVersionInfoByAppIds(List<Long> paramList);
  
  public abstract boolean deleteByAppId(Long paramLong);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\AppUpdateInfoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */