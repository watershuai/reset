package com.water.reset.aop;

import com.water.reset.redis.RedisUtils;
import com.water.reset.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
@Aspect
@Configuration
@Slf4j
public class PageViewAspect {
    @Autowired
    private RedisUtils redisUtils;
    /**
    * 切入点
    */
    @Pointcut("@annotation(com.water.reset.annotation.pageView)")
    public void pageViewAspect() {

    }
    /**
     * 切入处理
     * @param joinPoint
     * @return
     */
    @Around("pageViewAspect()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object[] object = joinPoint.getArgs();
        Object goodId = object[0];
        log.info("goodId:{}", goodId);
        Object obj = null;
        try {
            String ipAddr = IpUtils.getIpAddr();
            log.info("ipAddr:{}", ipAddr);
            String key = "goodId_" + goodId;
            // 浏览量存入redis中
            redisUtils.addSetKey(key,ipAddr);
            /*if (num == 0) {
                log.info("该ip:{},访问的浏览量已经新增过了", ipAddr);
            }*/
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }
}
