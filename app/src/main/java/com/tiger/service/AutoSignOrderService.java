package com.tiger.service;

import com.tiger.model.Page;
import com.tiger.pojo.AutoSignOrder;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface AutoSignOrderService
  extends BaseService<AutoSignOrder>
{
  public abstract boolean updateByOrderNum(AutoSignOrder paramAutoSignOrder);
  
  public abstract List<AutoSignOrder> selectList(AutoSignOrder paramAutoSignOrder, Page paramPage);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\AutoSignOrderService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */