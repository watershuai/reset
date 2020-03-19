package com.water.reset.aop;

import com.alibaba.fastjson.JSON;
import com.water.reset.annotation.InputLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AnnotationAspect {
    @Pointcut("@annotation(com.water.reset.annotation.InputLog)")
    public void annotationPointcut() {
    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        InputLog annotation = method.getAnnotation(InputLog.class);
        String value = annotation.value();
        System.out.println("准备"+value);
    }
    /***
     * 没有环绕方法可以不调joinPoint1.proceed() 方法，也可以执行到实际业务接口的方法里
     * **/
    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        InputLog annotation = method.getAnnotation(InputLog.class);
        String value = annotation.value();
        System.out.println("结束"+value);
    }
    /***
     * 有环绕方法必须要有joinPoint1.proceed() 方法，才可以执行到实际业务接口的方法里
     * **/
  /*  @Around("annotationPointcut()")
    public void aroundPointcut(JoinPoint joinPoint) throws Throwable {
        ProceedingJoinPoint joinPoint1=(ProceedingJoinPoint)joinPoint;
        String result= JSON.toJSONString(joinPoint1.proceed());
        System.out.println("方法返回值:"+result);
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        InputLog annotation = method.getAnnotation(InputLog.class);
        String value = annotation.value();
        System.out.println("结束"+value);
    }*/
}
