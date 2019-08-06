package com.water.reset.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description: redis操作工具类
 * @author:water
 * @Data:
 */
@Component
@Slf4j
public class RedisUtils {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 释放资源
     * @param jedis
     */
    @SuppressWarnings("deprecation")
    public void returnResource(Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedisPool.returnResource(jedis);
        }
    }
    /**
     * @param key 键
     * @author:water
     * @Data 2019/07/18
     * @Description: 根据键获取值
     */
    public String getValueByKey(String key){
        Jedis jedis=jedisPool.getResource();
        String value="";
        if (StringUtils.isEmpty(key)){
            return "";
        }
        try {
            value=jedis.get(key);
        }catch (Exception e){
            log.info("根据key获取值异常",e);
            returnResource(jedis);
        }finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * @param key 键
     * @param value 值
     * @author:water
     * @Data 2019/07/18
     * @Description: 存在String类型字符串
     */
    public void setString(String key,String value){
        Jedis jedis=jedisPool.getResource();
        try {
            System.out.println(jedis.set(key,value));
        }catch (Exception e){
            log.info("存入String字符串异常",e);
            returnResource(jedis);
        }finally {
            returnResource(jedis);
        }
    }
    /**
     * @param key 键
     * @author:water
     * @Data 2019/07/18
     * @Description: 判断是否存在该key
     */
    public boolean isExist(String key){
        Jedis jedis=jedisPool.getResource();
        boolean flag=false;
        try {
           flag=jedis.exists(key);
        }catch (Exception e){
            log.info("判断key是否存在异常",e);
            returnResource(jedis);
        }finally {
            returnResource(jedis);
        }
        return flag;
    }
    /**
     * @param key 键
     * @param time 过期时间，单位s
     * @author:water
     * @Data 2019/07/18
     * @Description: 给key设置过期时间
     */
    public void expire(String key,int time){
        Jedis jedis=jedisPool.getResource();
        try {
           jedis.expire(key,time);
        }catch (Exception e){
            log.info("设置key过期时间异常",e);
            returnResource(jedis);
        }finally {
            returnResource(jedis);
        }
    }
    /**
     * 删除key
     *
     * @param keys
     * @return -5：Jedis实例获取失败，1：成功，0：失败
     * @author water
     */
    public void delete(String... keys) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(keys);
        } catch (Exception e) {
            log.info(String.format("删除key=%s失败：" + e.getMessage(), keys), e);
            returnResource(jedis);
        } finally {
            returnResource(jedis);
        }
    }
}
