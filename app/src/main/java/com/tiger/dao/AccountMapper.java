package com.tiger.dao;

import com.tiger.pojo.Account;
import com.tiger.utils.MapperUtils;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface AccountMapper
  extends MapperUtils<Account>
{
  public abstract boolean updateByAccount(Account paramAccount);
  
  public abstract boolean payDownNumDecrementById(@Param("id") Integer paramInteger1, @Param("num") Integer paramInteger2);
  
  public abstract boolean freeDownNumDecrementById(@Param("id") Integer paramInteger1, @Param("num") Integer paramInteger2);
  
  public abstract List<Account> selectByIdList(List<Long> paramList);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\AccountMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */