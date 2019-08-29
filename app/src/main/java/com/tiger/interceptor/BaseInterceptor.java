/*    */ package com.tiger.interceptor;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaseInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/* 19 */   public final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);
/*    */   
/*    */   public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
/*    */   {
/* 23 */     this.logger.info(httpServletRequest.getRequestURL().toString());
/*    */     
/* 25 */     httpServletResponse.setContentType("content-type: application/json; charset=utf-8;");
/* 26 */     this.logger.info("请求参数：" + JSON.toJSONString(httpServletRequest.getParameterMap()));
/*    */     
/* 28 */     httpServletResponse.addHeader("Access-Control-Max-Age", "1800");
/* 29 */     httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
/* 30 */     httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,Content-Type,token");
/* 31 */     httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
/* 32 */     httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
/*    */     
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)
/*    */     throws Exception
/*    */   {}
/*    */ }

