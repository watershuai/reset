/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import com.yz.common.cache.ICache;
/*    */ import com.yz.common.cache.redis.RedisTemplateImpl;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
/*    */ import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
/*    */ import org.springframework.data.redis.serializer.StringRedisSerializer;
/*    */ import redis.clients.jedis.JedisPoolConfig;
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
/*    */ @Configuration
/*    */ public class CacheConfig
/*    */ {
/*    */   @Value("${redis.pool.maxTotal}")
/*    */   private int maxTotal;
/*    */   @Value("${redis.pool.maxIdle}")
/*    */   private int maxIdle;
/*    */   @Value("${redis.pool.minIdle}")
/*    */   private int minIdle;
/*    */   @Value("${redis.pool.maxWaitMillis}")
/*    */   private long maxWaitMillis;
/*    */   @Value("${redis.pool.testOnBorrow}")
/*    */   private boolean testOnBorrow;
/*    */   @Value("${redis.pool.testOnReturn}")
/*    */   private boolean testOnReturn;
/*    */   @Value("${redis.pool.testWhileIdle}")
/*    */   private boolean testWhileIdle;
/*    */   @Value("${redis.hostName}")
/*    */   private String hostName;
/*    */   @Value("${redis.password}")
/*    */   private String password;
/*    */   @Value("${redis.database}")
/*    */   private int database;
/*    */   @Value("${redis.timeout}")
/*    */   private int timeout;
/*    */   
/*    */   @Bean
/*    */   public JedisPoolConfig createJedisPoolConfig()
/*    */   {
/* 52 */     JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
/* 53 */     jedisPoolConfig.setMaxTotal(this.maxTotal);
/* 54 */     jedisPoolConfig.setMaxIdle(this.maxIdle);
/* 55 */     jedisPoolConfig.setMinIdle(this.minIdle);
/* 56 */     jedisPoolConfig.setMaxWaitMillis(this.maxWaitMillis);
/* 57 */     jedisPoolConfig.setTestOnBorrow(this.testOnBorrow);
/* 58 */     jedisPoolConfig.setTestOnReturn(this.testOnReturn);
/* 59 */     jedisPoolConfig.setTestWhileIdle(this.testWhileIdle);
/* 60 */     return jedisPoolConfig;
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public JedisConnectionFactory createJedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
/* 65 */     JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
/* 66 */     jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
/* 67 */     jedisConnectionFactory.setHostName(this.hostName);
/* 68 */     jedisConnectionFactory.setPassword(this.password);
/* 69 */     jedisConnectionFactory.setDatabase(this.database);
/* 70 */     jedisConnectionFactory.setTimeout(this.timeout);
/* 71 */     return jedisConnectionFactory;
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public RedisTemplate createRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
/* 76 */     RedisTemplate redisTemplate = new RedisTemplate();
/* 77 */     redisTemplate.setConnectionFactory(jedisConnectionFactory);
/* 78 */     redisTemplate.setKeySerializer(new StringRedisSerializer());
/* 79 */     redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
/* 80 */     redisTemplate.setHashKeySerializer(new StringRedisSerializer());
/* 81 */     redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
/*    */     
/* 83 */     redisTemplate.setEnableTransactionSupport(true);
/* 84 */     return redisTemplate;
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public ICache createCacheInterface(RedisTemplate redisTemplate) {
/* 89 */     ICache iCache = new RedisTemplateImpl(redisTemplate);
/* 90 */     return iCache;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\CacheConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */