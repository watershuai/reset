package com.tiger.dao;

import com.tiger.pojo.RemindMessage;
import com.tiger.utils.MapperUtils;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface RemindMessageMapper
  extends MapperUtils<RemindMessage>
{
  public abstract List<RemindMessage> selectByTimeIntervalAndUserId(@Param("startTime") String paramString1, @Param("endTime") String paramString2, @Param("userId") Integer paramInteger);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\RemindMessageMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */