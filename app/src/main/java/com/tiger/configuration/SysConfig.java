/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import com.yz.common.core.json.JSON;
/*    */ import com.yz.common.core.utils.SnowflakeID;
/*    */ import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
/*    */ import javax.annotation.PostConstruct;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class SysConfig
/*    */ {
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 22 */     JSON.init(1);
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
/* 27 */     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
/* 28 */     executor.setCorePoolSize(10);
/* 29 */     executor.setMaxPoolSize(200);
/* 30 */     executor.setKeepAliveSeconds(1);
/* 31 */     executor.setQueueCapacity(50);
/* 32 */     executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
/* 33 */     executor.initialize();
/* 34 */     return executor;
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public SnowflakeID getSnowFlakeID() {
/* 39 */     SnowflakeID.instance(9L, 20L);
/* 40 */     return SnowflakeID.getInstance();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\SysConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */