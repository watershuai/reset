/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.service.ValidateService;
/*    */ import com.yz.common.core.exception.HandlerException;
/*    */ import com.yz.common.core.utils.VerifyCodeUtil;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
/*    */ import org.springframework.data.redis.core.ValueOperations;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class ValidateServiceImpl
/*    */   implements ValidateService
/*    */ {
/*    */   @Autowired
/*    */   private RedisTemplate redisTemplate;
/*    */   
/*    */   public boolean validateSmsCode(String purpose, String phone, String code)
/*    */     throws HandlerException
/*    */   {
/* 23 */     Object o = this.redisTemplate.opsForValue().get(purpose + phone);
/*    */     
/* 25 */     if (o == null) {
/* 26 */       throw new HandlerException(29, "短信验证未通过");
/*    */     }
/*    */     
/* 29 */     if (!o.toString().equals(code)) {
/* 30 */       throw new HandlerException(29, "短信验证未通过");
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validatePictureVerifyCode(String purpose, String code) throws HandlerException
/*    */   {
/* 37 */     Object o = this.redisTemplate.opsForValue().get(purpose + code.toLowerCase());
/* 38 */     if (o == null) {
/* 39 */       throw new HandlerException(30, "图片验证码错误");
/*    */     }
/* 41 */     if (!o.toString().equalsIgnoreCase(code)) {
/* 42 */       throw new HandlerException(30, "图片验证码错误");
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public String generatePictureVerifyCode(int num, String purpose, long time, TimeUnit timeUnit)
/*    */   {
/* 49 */     String verifyCode = VerifyCodeUtil.generateVerifyCode(num);
/* 50 */     Object o = this.redisTemplate.opsForValue().get(purpose + verifyCode.toLowerCase());
/* 51 */     if (o != null) {
/* 52 */       verifyCode = generatePictureVerifyCode(num, purpose, time, timeUnit);
/*    */     }
/* 54 */     this.redisTemplate.opsForValue().set(purpose + verifyCode.toLowerCase(), verifyCode.toLowerCase(), 5L, TimeUnit.MINUTES);
/* 55 */     return verifyCode;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\ValidateServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */