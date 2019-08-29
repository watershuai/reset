/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.tiger.dao.PayOrderMapper;
/*    */ import com.tiger.model.PayOrderQuery;
/*    */ import com.tiger.pojo.Account;
/*    */ import com.tiger.pojo.PayOrder;
/*    */ import com.tiger.service.AccountService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.OrderService;
/*    */ import com.yz.common.core.exception.HandlerException;
/*    */ import com.yz.common.core.utils.DateUtils;
/*    */ import com.yz.common.core.utils.StringUtils;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.BeanUtils;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class OrderServiceImpl
/*    */   extends BaseServiceManager<PayOrder, PayOrderMapper>
/*    */   implements OrderService
/*    */ {
/*    */   @Autowired
/*    */   private AccountService accountService;
/*    */   
/*    */   public List<PayOrder> getPayOrderList(PayOrder payOrder, com.tiger.model.Page page)
/*    */   {
/* 36 */     if ((page.getIndex() != 0) && (page.getPageSize() != 0)) {
/* 37 */       PageHelper.startPage(page.getIndex(), page.getPageSize());
/*    */     }
/* 39 */     List<PayOrder> payOrders = selectList(payOrder);
/*    */     
/* 41 */     com.github.pagehelper.Page<PayOrder> listCountry = (com.github.pagehelper.Page)payOrders;
/* 42 */     page.setTotalPage(listCountry.getPages());
/* 43 */     return payOrders;
/*    */   }
/*    */   
/*    */   public List<PayOrder> getPayOrderListByCreateTimeMonth(PayOrderQuery payOrderQuery, com.tiger.model.Page page)
/*    */     throws HandlerException
/*    */   {
/* 49 */     PayOrder payOrder = new PayOrder();
/* 50 */     BeanUtils.copyProperties(payOrderQuery, payOrder);
/* 51 */     if (payOrderQuery.getOrderStatus().intValue() == 0) {
/* 52 */       payOrder.setOrderStatus(null);
/*    */     }
/* 54 */     if (!StringUtils.isEmpty(payOrderQuery.getPhone())) {
/* 55 */       Account account = new Account();
/* 56 */       account.setAccount(payOrderQuery.getPhone());
/* 57 */       account = (Account)this.accountService.selectOne(account);
/* 58 */       if (account == null) {
/* 59 */         throw new HandlerException(3, "该手机号用户不存在");
/*    */       }
/* 61 */       payOrder.setAccountId(Long.valueOf(account.getId().longValue()));
/*    */     }
/*    */     
/* 64 */     Integer month = payOrderQuery.getMonth();
/*    */     
/* 66 */     PageHelper.orderBy("create_time desc");
/* 67 */     if ((page.getIndex() != 0) && (page.getPageSize() != 0)) {
/* 68 */       PageHelper.startPage(page.getIndex(), page.getPageSize());
/*    */     }
/*    */     List<PayOrder> payOrders;
/*    */     List<PayOrder> payOrders;
/* 72 */     if ((month.intValue() > 0) && (month.intValue() <= 12)) {
/* 73 */       int year = new Date().getYear() + 1900;
/* 74 */       String endTime = DateUtils.getLastDayOfMonth(year, month.intValue());
/* 75 */       String startTime = DateUtils.getFirstDayOfMonth(year, month.intValue());
/* 76 */       payOrders = ((PayOrderMapper)this.dao).selectByCreateTimeInterval(payOrder, startTime + " 00:00:00", endTime + " 23:59:59");
/*    */     } else {
/* 78 */       payOrders = selectList(payOrder);
/*    */     }
/* 80 */     if ((page.getIndex() != 0) && (page.getPageSize() != 0)) {
/* 81 */       com.github.pagehelper.Page<PayOrder> listCountry = (com.github.pagehelper.Page)payOrders;
/* 82 */       page.setTotalPage(listCountry.getPages());
/*    */     }
/*    */     
/* 85 */     return payOrders;
/*    */   }
/*    */   
/*    */   @Autowired
/*    */   public void setDao(PayOrderMapper dao)
/*    */   {
/* 91 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<PayOrder> selectPageList(PayOrder payOrder, int i, int i1)
/*    */   {
/* 96 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\OrderServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */