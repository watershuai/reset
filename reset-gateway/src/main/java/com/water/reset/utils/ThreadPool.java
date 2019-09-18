package com.water.reset.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class ThreadPool {
    private static final Integer poolSize = 20;
    private static final Integer maxPoolSize = 80;
    private static final Integer maxWait = 100;
    private static final Long aliveTime = 0L;
    public static ThreadPoolExecutor creatThread=new ThreadPoolExecutor(poolSize,maxPoolSize,aliveTime, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(maxWait));


}
