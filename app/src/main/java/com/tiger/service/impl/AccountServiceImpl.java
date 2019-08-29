/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.tiger.dao.AccountMapper;
/*    */ import com.tiger.pojo.Account;
/*    */ import com.tiger.service.AccountService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.yz.common.cache.ICache;
/*    */ import com.yz.common.core.utils.MD5Util;
/*    */ import com.yz.common.core.utils.SnowflakeID;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class AccountServiceImpl
/*    */   extends BaseServiceManager<Account, AccountMapper>
/*    */   implements AccountService
/*    */ {
/*    */   @Autowired
/*    */   private ICache iCache;
/*    */   @Autowired
/*    */   private SnowflakeID snowflakeID;
/*    */   
/*    */   @Autowired
/*    */   public void setDao(AccountMapper dao)
/*    */   {
/* 35 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<Account> selectPageList(Account account, int pageIndex, int pageSize)
/*    */   {
/* 40 */     return null;
/*    */   }
/*    */   
/*    */   public Account getByToken(String token)
/*    */   {
/* 45 */     Account account = new Account();
/* 46 */     account.setToken(token);
/* 47 */     account = (Account)selectOne(account);
/* 48 */     return account;
/*    */   }
/*    */   
/*    */   public boolean updateByAccount(Account account)
/*    */   {
/* 53 */     return ((AccountMapper)this.dao).updateByAccount(account);
/*    */   }
/*    */   
/*    */   public List<Account> getAccoutsForPage(Account account, com.tiger.model.Page page)
/*    */   {
/* 58 */     PageHelper.orderBy("create_time desc");
/* 59 */     if ((page.getIndex() > 0) && (page.getPageSize() > 0)) {
/* 60 */       PageHelper.startPage(page.getIndex(), page.getPageSize());
/* 61 */       com.github.pagehelper.Page page1 = (com.github.pagehelper.Page)selectList(account);
/* 62 */       page.setDataList(page1.getResult());
/* 63 */       page.setTotalPage(page1.getPages());
/* 64 */       return page1.getResult();
/*    */     }
/* 66 */     List<Account> accounts = selectList(account);
/* 67 */     return accounts;
/*    */   }
/*    */   
/*    */   public Account getAccoutByTokenForCache(String token)
/*    */   {
/* 72 */     Account account = (Account)this.iCache.hashGet("account_catche", token, Account.class);
/* 73 */     if (account == null) {
/* 74 */       account = new Account();
/* 75 */       account.setToken(token);
/* 76 */       account = (Account)selectOne(account);
/* 77 */       if (account != null) {
/* 78 */         this.iCache.hashSet("account_catche", account.getToken(), account);
/*    */       }
/*    */     }
/* 81 */     return account;
/*    */   }
/*    */   
/*    */   public String createToken()
/*    */   {
/* 86 */     long l = this.snowflakeID.nextId();
/* 87 */     String md5 = MD5Util.md5(String.valueOf(l) + "yangzhaojava");
/* 88 */     return md5;
/*    */   }
/*    */   
/*    */   public List<Account> selectListByIdList(List<Long> idList)
/*    */   {
/* 93 */     return ((AccountMapper)this.dao).selectByIdList(idList);
/*    */   }
/*    */ }

