package com.water.reset.crawler;


import com.water.reset.crawler.http.HttpHelp;
import com.water.reset.service.IHttpCheck;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
public abstract class CrawlerJob implements IHttpCheck {
    private static final Integer POOL_SIZE = 6;
    private static final Integer MAX_POOL_SIZE = 17;
    private static final Integer QUEUE = 10;
    private static final Long ALIVE_TIME = 0L;
    private ThreadPoolExecutor executorService;
    @Setter
    private HttpHelp httpHelp;

    protected HttpHelp getHttpHelp(){
        return httpHelp;
    }
    public CrawlerJob(){
        httpHelp=new HttpHelp();
    }
    /**
    * 对外爬虫入口
    **/
    public void grasp() {
       doGrasp();
    }

    @Override
    public String advanceResult(String result) {
        return result;
    }

    @Override
    public Boolean resultRetry(String result) {
        return true;
    }
    /**
     * 开启并发抓取
     * */
    private void doGrasp() {
        executorService = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(QUEUE));
        long startTime=System.currentTimeMillis();
        executorService.execute(() -> {
            try {
                crawl();
            }catch (Exception e){
                log.error("爬虫任务出现异常",e);
            }
        });
        executorService.shutdown();
        log.info("任务执行结束，耗时:"+(System.currentTimeMillis()-startTime)+"ms");
    }
    /**
     * 具体实现重写入口
     **/
    protected abstract void crawl();
}
