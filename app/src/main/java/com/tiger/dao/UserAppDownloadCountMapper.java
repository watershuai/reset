package com.tiger.dao;

import com.tiger.model.AppDownloadData;
import com.tiger.pojo.UserAppDownloadCount;
import com.tiger.utils.MapperUtils;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface UserAppDownloadCountMapper
  extends MapperUtils<UserAppDownloadCount>
{
  public abstract List<AppDownloadData> selectAppDownloadDataCountByTimeInterval(@Param("startTime") String paramString1, @Param("endTime") String paramString2);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\UserAppDownloadCountMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */