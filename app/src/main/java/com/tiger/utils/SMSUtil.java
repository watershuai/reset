/*    */ package com.tiger.utils;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.yz.common.core.utils.HttpUtil;
/*    */ import java.security.SecureRandom;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class SMSUtil
/*    */ {
/* 25 */   private static final Logger logger = LoggerFactory.getLogger(SMSUtil.class);
/*    */   
/*    */   public static final String SIGN = "【MIX签名分发】";
/*    */   
/*    */   private static final String SYMBOLS = "0123456789";
/*    */   
/* 31 */   private static final Random RANDOM = new SecureRandom();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String createSMSCode(int num)
/*    */   {
/* 40 */     char[] nonceChars = new char[num];
/*    */     
/* 42 */     for (int index = 0; index < nonceChars.length; index++) {
/* 43 */       nonceChars[index] = "0123456789".charAt(RANDOM.nextInt("0123456789".length()));
/*    */     }
/*    */     
/* 46 */     return new String(nonceChars);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean sendSMS(String phone, String content)
/*    */   {
/* 58 */     Map params = new HashMap();
/* 59 */     params.put("account", "N6320145");
/* 60 */     params.put("password", "bivrgkY23c9814");
/* 61 */     params.put("msg", "【MIX签名分发】" + content);
/* 62 */     params.put("phone", phone);
/* 63 */     String s = HttpUtil.sendPost("http://smssh1.253.com/msg/send/json", JSON.toJSONString(params));
/* 64 */     HashMap result = (HashMap)JSON.parseObject(s, HashMap.class);
/* 65 */     if (!result.get("code").toString().equals("0")) {
/* 66 */       return false;
/*    */     }
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean sendSMSCode(String phone, String code)
/*    */   {
/* 79 */     Map params = new HashMap();
/* 80 */     params.put("account", "N6320145");
/* 81 */     params.put("password", "bivrgkY23c9814");
/* 82 */     params.put("msg", "【MIX签名分发】提示您的验证码是：" + code);
/* 83 */     params.put("phone", phone);
/* 84 */     String s = HttpUtil.sendPost("http://smssh1.253.com/msg/send/json", JSON.toJSONString(params));
/* 85 */     HashMap result = (HashMap)JSON.parseObject(s, HashMap.class);
/* 86 */     if (!result.get("code").toString().equals("0")) {
/* 87 */       return false;
/*    */     }
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\SMSUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */