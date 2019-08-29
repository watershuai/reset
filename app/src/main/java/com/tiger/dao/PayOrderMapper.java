package com.tiger.dao;

import com.tiger.pojo.PayOrder;
import com.tiger.utils.MapperUtils;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface PayOrderMapper
  extends MapperUtils<PayOrder>
{
  public abstract boolean updateByOrderId(PayOrder paramPayOrder);
  
  public abstract List<PayOrder> selectByCreateTimeInterval(@Param("payOrder") PayOrder paramPayOrder, @Param("startTime") String paramString1, @Param("endTime") String paramString2);
  
  public abstract List<PayOrder> selectListByStatusAndIdList(@Param("accountList") List<Long> paramList, @Param("status") int paramInt);
}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\dao\PayOrderMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */