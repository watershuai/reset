package com.water.reset.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
@Component
public final class RedisUtils {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 默认超时时间 3day
     */
    private final static Long DEFAULT_TIME_OUT = 259200L;

    /**
     * redis新增记录(默认超时时间 72小时)
     *
     * @param key 新增key
     * @param obj 新增对象
     */
    public void insertObject(String key, Object obj) {
        insertObject(key, obj, DEFAULT_TIME_OUT);
    }

    /**
     * redis新增记录
     *
     * @param key     新增key
     * @param obj     新增对象
     * @param timeOut 超时时间(单位:s 负数表示永不过期)
     */
    public void insertObject(String key, Object obj, Long timeOut) {
        try {
            String jsonValue = JSON.toJSONString(obj);
            if (timeOut > 0) {
                redisTemplate.opsForValue().set(key, jsonValue, timeOut, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, jsonValue);
            }
        } catch (Exception e) {
            log.error("插入redis数据异常", e);
        }

    }


    /**
     * 获取redis记录
     *
     * @param key       查询key
     * @param beanClass 需要转换对象的class
     * @param <T>       泛型class
     * @return 查询结果
     */
    public <T> T queryObject(String key, Class<T> beanClass) {
        String jsonValue = null;
        try {
            jsonValue = redisTemplate.opsForValue().get(key);
            if (StringUtils.isBlank(jsonValue)) {
                return null;
            }
            return JSON.parseObject(jsonValue, beanClass);
        } catch (Exception e) {
            log.error("redis 获取数据异常，获取到结果: {},转换对象: {}", jsonValue, beanClass);
            return null;
        }
    }

    /**
     * 获取redis记录
     *
     * @param key 查询key
     * @return 查询结果
     */
    public String queryString(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("queryString异常", e);
            return null;
        }
    }

    public Long incrBy(String key, Long count) {
        try {
            return redisTemplate.opsForValue().increment(key, count);
        } catch (Exception e) {
            log.error("redis incrBy异常", e);
            return 0L;
        }
    }

    /**
     * 删除redis key
     *
     * @param key redis key
     */
    public void deleteKey(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            log.error("redis deleteKey:[{}] 异常", key, e);
        }
    }

    /**
     * 从set 集合中随机获取一个元素(并从集合中移除)
     *
     * @param key redis key
     * @return 移除的元素
     */
    public String popSetKey(String key) {
        try {
            return redisTemplate.opsForSet().pop(key);
        } catch (Exception e) {
            log.error("redis 从{} set集合中随机获取数据失败,原因:", key, e);
        }
        return null;
    }

    /**
     * 从set 集合中随机获取一个元素
     *
     * @param key redis key
     * @return 获取到的元素
     */
    public String randomMemberSetKey(String key) {
        try {
            return redisTemplate.opsForSet().randomMember(key);
        } catch (Exception e) {
            log.error("redis 从{} set集合中随机获取数据失败,原因:", key, e);
        }
        return null;
    }

    /**
     * 往set集合中插入一个值
     *
     * @param key   redis key
     * @param value 新增值
     * @return set集合长度
     */
    public Long addSetKey(String key, String value) {
        try {
            return redisTemplate.opsForSet().add(key, value);
        } catch (Exception e) {
            log.error("redis 往{} set集合中新增数据: {},失败,原因:", key, value, e);
        }
        return null;
    }

    /**
     * 获取set集合长度
     *
     * @param key redis key
     * @return set集合长度
     */
    public Long countSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            log.error("redis 获取 {} set集合长度,失败,原因:", key, e);
        }
        return null;
    }

    /**
     * 从set 集合中随机获取一个元素
     *
     * @param key   redis key
     * @param value 需要删除的key
     * @return 当前set集合长度
     */
    public Long removeSetValue(String key, String value) {
        try {
            return redisTemplate.opsForSet().remove(key, value);
        } catch (Exception e) {
            log.error("redis 从{} set集合中删除指定数据: {},失败,原因:", key, value, e);
        }
        return null;
    }

    /**
     * 从redis获取有序集合(倒序)
     *
     * @param key 集合key
     * @return 查询结果(权重 高->低)
     */
    public Set<String> getZSetValue(String key, Double start, Double end, int offset, int size) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, start, end, offset, size);
    }

    /**
     * 从redis获取有序集合(倒序且附带权重信息)
     *
     * @param key   集合key
     * @param start 开始权重
     * @param end   结束权重
     * @return 查询结果(权重 高->低)
     */
    public Set<ZSetOperations.TypedTuple<String>> getZSetScoreValue(String key, Double start, Double end) {
        Set<ZSetOperations.TypedTuple<String>> set = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, start, end);
        return set;
    }

    /**
     * 增加记录信息
     *
     * @param key      redis键
     * @param value    需要添加的值
     * @param score    权重
     * @param timeOut  超时时长
     * @param timeUnit 时间单位
     */
    public void addZSetValue(String key, String value, double score, long timeOut, TimeUnit timeUnit) {
        redisTemplate.opsForZSet().add(key, value, score);
        redisTemplate.expire(key, timeOut, timeUnit);
    }

    /**
     * 次数累加-缓存
     *
     * @param key   redis键
     * @param value 需要累计的值
     * @param score 累计分数
     */
    public void incrementScore(String key, String value, Double score) {
        redisTemplate.opsForZSet().incrementScore(key, value, score);
    }

    public Set<String> getZsetByIndex(String key, Long start, Long end) {
        try {
            return redisTemplate.opsForZSet().range(key, start, end);
        } catch (Exception e) {
            log.error("getZsetByIndex异常", e);
        }
        return null;
    }

    public Set<String> getZsetWithRetry(String key, Long start, Long end) {
        Set<String> set = getZsetByIndex(key, start, end);
        if (set == null) {
            set = getZsetByIndex(key, start, end);
        }
        return set;
    }


    /**
     * 增加记录信息
     *
     * @param key   redis键
     * @param value 需要添加的值
     * @param score 权重
     */
    public void addZSetValue(String key, String value, double score) {
        try {
            redisTemplate.opsForZSet().add(key, value, score);
        } catch (Exception e) {
            log.error("addZSetValue异常", e);
        }
    }

    /**
     * 增加记录信息
     *
     * @param key   redis键
     * @param value 需要添加的值
     */
    public void addZSetValueWithTimeScore(String key, String value) {
        try {
            redisTemplate.opsForZSet().add(key, value, System.currentTimeMillis());
        } catch (Exception e) {
            log.error("addZSetValueWithTimeScore异常", e);
        }
    }

    /**
     * 根据值删除zset
     *
     * @param key          key
     * @param deleteValues 需要删除的key之前的值
     */
    public Long deleteZSetValues(String key, Object... deleteValues) {
        try {
            return redisTemplate.opsForZSet().remove(key, deleteValues);
        } catch (Exception e) {
            log.error("deleteZSetValues异常", e);
            return 0L;
        }
    }

    /**
     * 获取Zset集合大小
     *
     * @param key key
     */
    public Long getZSetSize(String key) {
        try {
            return redisTemplate.opsForZSet().size(key);
        } catch (Exception e) {
            log.error("getZSetSize异常", e);
            return null;
        }
    }


    /**
     * 获取锁
     *
     * @param key      锁key
     * @param lockTime 锁时间(锁最大存在时间)
     * @return 锁钥(用于解锁)
     */
    public String lock(String key, long lockTime) {
        String lockValue = (System.currentTimeMillis() + lockTime * 1000) + "";
        //对应setnx命令
        if (redisTemplate.opsForValue().setIfAbsent(key, lockValue)) {   //返回false之前已经存在
            redisTemplate.expire(key, lockTime, TimeUnit.SECONDS);
            //可以成功设置,也就是key不存在
            return lockValue;
        }
        //判断锁超时 - 防止原来的操作异常，没有运行解锁操作  防止死锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期 currentValue不为空且小于当前时间
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间value  对应getset，如果key存在
            String oldValue = redisTemplate.opsForValue().getAndSet(key, lockValue);
            //假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentValue=A(get取的旧的值肯定是一样的),两个线程的value都是B,key都是K.锁时间已经过期了。
            //而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的value已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                //oldValue不为空且oldValue等于currentValue，也就是校验是不是上个对应的商品时间戳，也是防止并发
                return lockValue;
            }
        }
        return null;
    }


    /**
     * 解锁
     *
     * @param key   解锁key
     * @param value 锁值
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                //删除key
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("[Redis分布式锁] 解锁出现异常了，{}", e);
        }
    }

    /**
     * 查找所有符合给定模式( pattern)的 key
     *
     * @param pattern
     * @return
     */
    public Set<String> getKeys(String pattern) {
        try {
            return redisTemplate.keys(pattern);
        } catch (Exception e) {
            log.error("redisTemplate获取keys异常:[{}]", e);
        }
        return null;
    }

    public Boolean exists(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("redisTemplate判断是否存在key异常:[{}]", e);
        }
        return Boolean.FALSE;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @return
     */
    public Boolean expire(String key, long timeOut) {
        try {
            return redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("redisTemplate设置过期时间异常:[{}]", e);
        }
        return Boolean.FALSE;
    }

    public Boolean expireFor2Times(String key, long timeOut) {
        for (int i = 0; i < 2; i++) {
            if (expire(key, timeOut)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

    /**
     * 从redis获取有序集合(附带权重信息)
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> getZSetWithScores(String key, long start, long end) {
        try {
            return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
        } catch (Exception e) {
            log.error("getZSetWithScores异常:[{}]", e);
        }
        return null;
    }

    /**
     * hash 添加字段
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void hPut(String key, String hashKey, String value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
        } catch (Exception e) {
            log.error("hPut异常:[{}]", e);
        }
    }

    public Boolean hExists(String key, String field) {
        try {
            return redisTemplate.opsForHash().hasKey(key, field);
        } catch (Exception e) {
            log.error("hExists异常:[{}]", e);
            return Boolean.FALSE;
        }
    }

    public Long hIncrBy(String key, String field, long increment) {
        try {
            return redisTemplate.opsForHash().increment(key, field, increment);
        } catch (Exception e) {
            log.error("hIncrBy异常:[{}]", e);
            return null;
        }
    }

    public Boolean hPutIfAbsent(String key, String hashKey, Object value) {
        try {
            return redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
        } catch (Exception e) {
            log.error("hPutIfAbsent异常:[{}]", e);
            return Boolean.FALSE;
        }
    }

    public Long hDelete(String key, Object... fields) {
        try {
            return redisTemplate.opsForHash().delete(key, fields);
        } catch (Exception e) {
            log.error("hDelete异常:[{}]", e);
            return null;
        }
    }

    public Object hGet(String key, String field) {
        try {
            return redisTemplate.opsForHash().get(key, field);
        } catch (Exception e) {
            log.error("hGet异常:[{}]", e);
            return null;
        }
    }

    public Map<Object, Object> hGetAll(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            log.error("hGetAll异常:[{}]", e);
            return null;
        }
    }

}

