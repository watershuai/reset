/*     */ package com.tiger.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WebUtil
/*     */ {
/*  21 */   private static final Logger logger = LoggerFactory.getLogger(WebUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void serverReturn(HttpServletResponse response, String info)
/*     */   {
/*  29 */     logger.info("返回数据：" + info);
/*  30 */     PrintWriter writer = null;
/*     */     try {
/*  32 */       writer = response.getWriter();
/*  33 */       writer.write(info);
/*  34 */       writer.flush();
/*     */     } catch (IOException e) {
/*  36 */       e.printStackTrace();
/*     */     } finally {
/*  38 */       writer.close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, String> parseFromToMap(HttpServletRequest request)
/*     */   {
/*  50 */     Map<String, String> parameters = new HashMap();
/*     */     
/*  52 */     Enumeration<String> parameterNames = request.getParameterNames();
/*     */     
/*  54 */     while (parameterNames.hasMoreElements())
/*     */     {
/*  56 */       String parameterName = (String)parameterNames.nextElement();
/*     */       
/*  58 */       parameters.put(parameterName, request.getParameter(parameterName));
/*     */     }
/*     */     
/*  61 */     return parameters;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getIPAddress(HttpServletRequest request)
/*     */   {
/*  70 */     String ip = null;
/*     */     
/*     */ 
/*  73 */     String ipAddresses = request.getHeader("X-Forwarded-For");
/*     */     
/*  75 */     if ((ipAddresses == null) || (ipAddresses.length() == 0) || ("unknown".equalsIgnoreCase(ipAddresses)))
/*     */     {
/*  77 */       ipAddresses = request.getHeader("Proxy-Client-IP");
/*     */     }
/*     */     
/*  80 */     if ((ipAddresses == null) || (ipAddresses.length() == 0) || ("unknown".equalsIgnoreCase(ipAddresses)))
/*     */     {
/*  82 */       ipAddresses = request.getHeader("WL-Proxy-Client-IP");
/*     */     }
/*     */     
/*  85 */     if ((ipAddresses == null) || (ipAddresses.length() == 0) || ("unknown".equalsIgnoreCase(ipAddresses)))
/*     */     {
/*  87 */       ipAddresses = request.getHeader("HTTP_CLIENT_IP");
/*     */     }
/*     */     
/*  90 */     if ((ipAddresses == null) || (ipAddresses.length() == 0) || ("unknown".equalsIgnoreCase(ipAddresses)))
/*     */     {
/*  92 */       ipAddresses = request.getHeader("X-Real-IP");
/*     */     }
/*     */     
/*     */ 
/*  96 */     if ((ipAddresses != null) && (ipAddresses.length() != 0)) {
/*  97 */       ip = ipAddresses.split(",")[0];
/*     */     }
/*     */     
/*     */ 
/* 101 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ipAddresses))) {
/* 102 */       ip = request.getRemoteAddr();
/*     */     }
/* 104 */     return ip;
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\WebUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */