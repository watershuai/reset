/*    */ package com.tiger.advice;
/*    */ 
/*    */ import com.tiger.pojo.Account;
/*    */ import com.tiger.pojo.AutoSignApp;
/*    */ import com.tiger.service.AccountService;
/*    */ import com.tiger.utils.SMSUtil;
/*    */ import org.aspectj.lang.JoinPoint;
/*    */ import org.aspectj.lang.annotation.After;
/*    */ import org.aspectj.lang.annotation.Aspect;
/*    */ import org.aspectj.lang.annotation.Pointcut;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;

/*    */ @Aspect
/*    */ @Component
/*    */ public class AutoSignAppSupplementSignSmsRemindAdvice
/*    */ {
/*    */   @Autowired
/*    */   private AccountService accountService;

/*    */   @Pointcut("execution(public * com.tiger.service.impl.AutoSignAppServiceImpl.supplementSign(..))")
/*    */   public void pointCut() {}
/*    */   
/*    */   @After("pointCut()")
/*    */   public void after(JoinPoint joinPoint)
/*    */   {
/* 32 */     Object[] args = joinPoint.getArgs();
/* 33 */     AutoSignApp autoSignApp = (AutoSignApp)args[0];
/* 34 */     Account account = (Account)this.accountService.selectById(autoSignApp.getUserId());
/* 35 */     String smsContext = "尊敬的用户，您的应用 <" + autoSignApp.getDisplayName() + "> 已掉签，系统正在执行自动签名，请及时登录平台查看!";
/* 36 */     SMSUtil.sendSMS(account.getAccount(), smsContext);
/*    */   }
/*    */ }
