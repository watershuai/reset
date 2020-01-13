package com.water.reset.crawler;


import com.water.reset.crawler.http.HttpHelp;
import com.water.reset.dto.Message;
import com.water.reset.dto.UserTask;
import com.water.reset.service.IHttpCheck;
import com.water.reset.utils.DataUtil;
import com.water.reset.utils.KafkaService;
import com.water.reset.utils.Tool;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Slf4j
@Service
public abstract class CrawlerJob implements IHttpCheck {
    private static final Integer POOL_SIZE = 6;
    private static final Integer MAX_POOL_SIZE = 17;
    private static final Integer QUEUE = 10;
    private static final Long ALIVE_TIME = 0L;
    private final ConcurrentHashMap<String, String> parsePage=new ConcurrentHashMap<>();
    private ThreadPoolExecutor executorService;
    @Setter
    private HttpHelp httpHelp;
    @Setter
    protected KafkaService kafkaService;
    @Setter
    protected UserTask userTask;

    public HttpHelp getHttpHelp(){
        return httpHelp;
    }
    public CrawlerJob(){
        httpHelp=new HttpHelp();
    }
    /**
    * 对外爬虫入口
    **/
    public void grasp() {
      long startTime=System.currentTimeMillis();
       doGrasp();
       log.info("爬虫任务执行结束，耗时:"+(System.currentTimeMillis()-startTime)+"ms");
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
        executorService.execute(() -> {
            try {
                crawl();
            }catch (Exception e){
                log.error("爬虫任务出现异常",e);
            }
        });
        executorService.shutdown();
    }
    /**
     * 具体实现重写入口
     **/
    public abstract void crawl();

    /**
     * 调用kafka解析服务
     */
    public void kafkaParse(String page){
        Message message=new Message();
       try {
           message.setId(Tool.getId(3));
           message.setMsg(page);
           message.setSendTime(DataUtil.getCurrentTime());
           message.setToken(userTask.getToken());
           kafkaService.sendMessage(message);
       }catch (Exception e){
           log.error("[{}]调用kafka服务异常：{}",message.getId(), e);
       }
    }
}
