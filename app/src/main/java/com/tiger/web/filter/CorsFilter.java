/*    */ package com.tiger.web.filter;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class CorsFilter
/*    */   implements Filter
/*    */ {
/*    */   public void init(FilterConfig filterConfig)
/*    */     throws ServletException
/*    */   {}
/*    */   
/*    */   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
/*    */   {
/* 23 */     HttpServletResponse response = (HttpServletResponse)servletResponse;
/* 24 */     response.setHeader("Access-Control-Allow-Origin", "*");
/* 25 */     response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
/* 26 */     response.setHeader("Access-Control-Max-Age", "3600");
/* 27 */     response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
/* 28 */     filterChain.doFilter(servletRequest, servletResponse);
/*    */   }
/*    */   
/*    */   public void destroy() {}
/*    */ }


