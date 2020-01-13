package com.water.reset.utils;

import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author:
 * @Description:
 * @date: 2017/10/30
 */
public class ThreadPoolUtil {

    private ThreadPoolUtil() {

    }

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    private static int maximumPoolSize = corePoolSize * 16 + 1;
    private static int workQueueSize = maximumPoolSize;
    private static long keepAliveTime = 60L;
    private static final ExecutorService threaPool = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(workQueueSize),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static ExecutorService threadPool() {
        return threaPool;
    }

    /**
     * 自定义异步线程池
     *
     * @return
     */

    public static AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Anno-Executor");
        //线程池维护线程的最大数量
        executor.setMaxPoolSize(30);
        //线程池所使用的缓冲队列
        executor.setQueueCapacity(50);
        //线程池维护线程的核心数
        executor.setCorePoolSize(5);
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(30000);
        executor.initialize();

        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                // .....
            }
        });
        // 使用预定义的异常处理类
        // executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }

    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(100);
       Thread myThread=new MyThread();
        Thread myThread2=new MyThread();
        Thread myThread3=new MyThread();
        Thread myThread4=new MyThread();
        Thread myThread5=new MyThread();
        for (int i=1;i<=100;i++){
            executorService.execute(myThread);
        }
        executorService.shutdown();

    }


}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
