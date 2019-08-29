package com.tiger.dao;

import com.tiger.pojo.AppMerge;
import com.tiger.utils.MapperUtils;
import java.util.List;

public abstract interface AppMergeMapper
  extends MapperUtils<AppMerge>
{
  public abstract List<AppMerge> selectByActiveLinkOrPassiveLink(String paramString);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\AppMergeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */