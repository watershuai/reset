/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.tiger.pojo.Account;
/*    */ import com.tiger.pojo.App;
/*    */ import com.tiger.service.AccountService;
/*    */ import com.tiger.service.AppService;
/*    */ import com.yz.common.core.exception.HandlerException;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class ApiController
/*    */ {
/*    */   @Resource
/*    */   private AccountService accountService;
/*    */   @Resource
/*    */   private AppService appService;
/*    */   
/*    */   @RequestMapping({"/account/info"})
/*    */   public Object getAccount(@RequestParam(required=true) String phone)
/*    */     throws HandlerException
/*    */   {
/* 30 */     if (!phone.equals("13082839999")) {
/* 31 */       throw new HandlerException(22, "当前账户暂无权限调用");
/*    */     }
/*    */     
/* 34 */     Account account = new Account();
/* 35 */     account.setAccount(phone);
/* 36 */     account = (Account)this.accountService.selectOne(account);
/* 37 */     if (account == null) {
/* 38 */       throw new HandlerException(3, "当前账户不存在");
/*    */     }
/* 40 */     account.setPassword(null);
/* 41 */     account.setToken(null);
/* 42 */     return account;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/app/info"})
/*    */   public Object getAppInfo(@RequestParam(required=true) String phone, @RequestParam(required=true) String bundleId) throws HandlerException
/*    */   {
/* 48 */     if (!phone.equals("13082839999")) {
/* 49 */       throw new HandlerException(22, "当前账户暂无权限调用");
/*    */     }
/*    */     
/* 52 */     Account account = new Account();
/* 53 */     account.setAccount(phone);
/* 54 */     account = (Account)this.accountService.selectOne(account);
/*    */     
/* 56 */     if (account == null) {
/* 57 */       throw new HandlerException(3, "当前账户不存在");
/*    */     }
/*    */     
/* 60 */     App app = new App();
/* 61 */     app.setAccountId(account.getId());
/* 62 */     app.setBundleId(bundleId);
/* 63 */     app = (App)this.appService.selectOne(app);
/* 64 */     app.setId(null);
/* 65 */     app.setAccountId(null);
/* 66 */     app.setIconId(null);
/* 67 */     app.setPkgType(null);
/* 68 */     app.setShortLink(null);
/* 69 */     return app;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\ApiController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */