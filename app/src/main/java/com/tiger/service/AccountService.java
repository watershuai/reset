package com.tiger.service;

import com.tiger.model.Page;
import com.tiger.pojo.Account;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface AccountService
  extends BaseService<Account>
{
  public abstract Account getByToken(String paramString);
  
  public abstract boolean updateByAccount(Account paramAccount);
  
  public abstract Account getAccoutByTokenForCache(String paramString);
  
  public abstract List<Account> getAccoutsForPage(Account paramAccount, Page paramPage);
  
  public abstract String createToken();
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AccountService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */