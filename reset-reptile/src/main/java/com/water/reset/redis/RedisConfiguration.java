package com.water.reset.redis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Configuration
@Slf4j
public class RedisConfiguration extends CachingConfigurerSupport {
    private static final String HOST="127.0.0.1";
    private static final int PORT=6379;
    private static final int MAX_ACTIVE=8;
    private static final int MAX_WAIT=-1;
    private static final long TIMEOUT=6;
    private JedisPoolConfig jedisPoolConfig;

   /* # REDIS (RedisProperties)
# Redis数据库索引（默认为0）
    spring.redis.database=0
            # Redis服务器地址
    spring.redis.host=127.0.0.1
            # Redis服务器连接端口
    spring.redis.port=6379
            # Redis服务器连接密码（默认为空）
    spring.redis.password=
            # 连接池最大连接数（使用负值表示没有限制）
    spring.redis.pool.max-active=8
            # 连接池最大阻塞等待时间（使用负值表示没有限制）
    spring.redis.pool.max-wait=-1
            # 连接池中的最大空闲连接
    spring.redis.pool.max-idle=8
            # 连接池中的最小空闲连接
    spring.redis.pool.min-idle=0
            # 连接超时时间（毫秒）
    spring.redis.timeout=0*/
   @Bean
   public JedisPool redisPoolFactory() {
       log.info("redis地址：" + HOST + ":" + PORT);
       JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
       // 最大空闲数
       jedisPoolConfig.setMaxIdle(50);
      // 最大连接数
       jedisPoolConfig.setMaxTotal(100);
     // 最大等待毫秒数
       jedisPoolConfig.setMaxWaitMillis(20000);
       JedisPool jedisPool = new JedisPool(jedisPoolConfig,HOST, PORT);
       return jedisPool;
   }

}
