/*    */ package com.tiger.lock;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
/*    */ import org.springframework.data.redis.core.ValueOperations;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class DistributedLock
/*    */ {
/*    */   @Autowired
/*    */   private RedisTemplate redisTemplate;
/*    */   
/*    */   public boolean lock(String key, int attempt)
/*    */   {
/* 19 */     Boolean absent = this.redisTemplate.opsForValue().setIfAbsent(key, Long.valueOf(System.currentTimeMillis()));
/* 20 */     if (absent.booleanValue()) {
/* 21 */       return true;
/*    */     }
/* 23 */     if (attempt > 0) {
/* 24 */       attempt--;
/*    */       try {
/* 26 */         Thread.sleep(1000L);
/*    */       } catch (InterruptedException e) {
/* 28 */         e.printStackTrace();
/*    */       }
/* 30 */       return lock(key, attempt);
/*    */     }
/* 32 */     return false;
/*    */   }
/*    */   
/*    */   public void unlock(String key) {
/* 36 */     this.redisTemplate.delete(key);
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\lock\DistributedLock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */