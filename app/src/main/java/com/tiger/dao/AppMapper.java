package com.tiger.dao;

import com.tiger.pojo.App;
import com.tiger.utils.MapperUtils;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface AppMapper
  extends MapperUtils<App>
{
  public abstract List<App> selectByIdList(List<Long> paramList);
  
  public abstract boolean appDownNumIncrementById(@Param("id") Long paramLong);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\AppMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */