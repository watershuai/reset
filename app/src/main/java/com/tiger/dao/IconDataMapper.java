package com.tiger.dao;

import com.tiger.pojo.IconData;
import com.tiger.utils.MapperUtils;
import java.util.List;

public abstract interface IconDataMapper
  extends MapperUtils<IconData>
{
  public abstract boolean deleteByBundleId(String paramString);
  
  public abstract List<IconData> selectByIdList(List<Long> paramList);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\IconDataMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */