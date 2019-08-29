package com.tiger.service;

import com.tiger.model.Page;
import com.tiger.model.PayOrderQuery;
import com.tiger.pojo.PayOrder;
import com.yz.common.core.exception.HandlerException;
import com.yz.common.core.service.BaseService;
import java.util.List;

public abstract interface OrderService
  extends BaseService<PayOrder>
{
  public abstract List<PayOrder> getPayOrderList(PayOrder paramPayOrder, Page paramPage);
  
  public abstract List<PayOrder> getPayOrderListByCreateTimeMonth(PayOrderQuery paramPayOrderQuery, Page paramPage)
    throws HandlerException;
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\OrderService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */