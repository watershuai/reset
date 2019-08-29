/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import com.alibaba.druid.pool.DruidDataSource;
/*    */ import javax.sql.DataSource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class DruidConfig
/*    */ {
/* 21 */   private Logger logger = LoggerFactory.getLogger(DruidConfig.class);
/*    */   
/*    */   @Value("${spring.datasource.url}")
/*    */   private String url;
/*    */   
/*    */   @Value("${spring.datasource.username}")
/*    */   private String username;
/*    */   
/*    */   @Value("${spring.datasource.password}")
/*    */   private String password;
/*    */   
/*    */   @Value("${spring.datasource.driver-class-name}")
/*    */   private String driverClassName;
/*    */   
/*    */   @Value("${spring.datasource.initialSize}")
/*    */   private int initialSize;
/*    */   
/*    */   @Value("${spring.datasource.minIdle}")
/*    */   private int minIdle;
/*    */   
/*    */   @Value("${spring.datasource.maxActive}")
/*    */   private int maxActive;
/*    */   
/*    */   @Value("${spring.datasource.maxWait}")
/*    */   private int maxWait;
/*    */   
/*    */   @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
/*    */   private int timeBetweenEvictionRunsMillis;
/*    */   
/*    */   @Value("${spring.datasource.minEvictableIdleTimeMillis}")
/*    */   private int minEvictableIdleTimeMillis;
/*    */   
/*    */   @Value("${spring.datasource.validationQuery}")
/*    */   private String validationQuery;
/*    */   
/*    */   @Value("${spring.datasource.testWhileIdle}")
/*    */   private boolean testWhileIdle;
/*    */   
/*    */   @Value("${spring.datasource.testOnBorrow}")
/*    */   private boolean testOnBorrow;
/*    */   
/*    */   @Value("${spring.datasource.testOnReturn}")
/*    */   private boolean testOnReturn;
/*    */   @Value("${spring.datasource.logSlowSql}")
/*    */   private String logSlowSql;
/*    */   
/*    */   @Bean
/*    */   public DataSource druidDataSource()
/*    */   {
/* 70 */     DruidDataSource datasource = new DruidDataSource();
/* 71 */     datasource.setUrl(this.url);
/* 72 */     datasource.setUsername(this.username);
/* 73 */     datasource.setPassword(this.password);
/* 74 */     datasource.setDriverClassName(this.driverClassName);
/* 75 */     datasource.setInitialSize(this.initialSize);
/* 76 */     datasource.setMinIdle(this.minIdle);
/* 77 */     datasource.setMaxActive(this.maxActive);
/* 78 */     datasource.setMaxWait(this.maxWait);
/* 79 */     datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
/* 80 */     datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
/* 81 */     datasource.setValidationQuery(this.validationQuery);
/* 82 */     datasource.setTestWhileIdle(this.testWhileIdle);
/* 83 */     datasource.setTestOnBorrow(this.testOnBorrow);
/* 84 */     datasource.setTestOnReturn(this.testOnReturn);
/* 85 */     return datasource;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\DruidConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */