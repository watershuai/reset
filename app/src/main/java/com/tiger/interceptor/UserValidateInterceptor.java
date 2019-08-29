/*    */ package com.tiger.interceptor;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.tiger.pojo.Account;
/*    */ import com.tiger.service.AccountService;
/*    */ import com.tiger.utils.ResponseMessage;
/*    */ import com.tiger.utils.WebUtil;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserValidateInterceptor
/*    */   extends BaseInterceptor
/*    */ {
/*    */   @Resource
/*    */   private AccountService accountService;
/*    */   
/*    */   public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
/*    */     throws Exception
/*    */   {
/* 28 */     String authToken = httpServletRequest.getParameter("authToken");
/* 29 */     if (StringUtils.isEmpty(authToken)) {
/* 30 */       WebUtil.serverReturn(httpServletResponse, JSON.toJSONString(ResponseMessage.error(1, "authToken不能为空")));
/* 31 */       return false;
/*    */     }
/* 33 */     Account account = this.accountService.getAccoutByTokenForCache(authToken);
/* 34 */     if (account == null) {
/* 35 */       WebUtil.serverReturn(httpServletResponse, JSON.toJSONString(ResponseMessage.error(8, "authToken失效")));
/* 36 */       return false;
/*    */     }
/* 38 */     httpServletRequest.setAttribute("account", account);
/* 39 */     return true;
/*    */   }
/*    */ }
