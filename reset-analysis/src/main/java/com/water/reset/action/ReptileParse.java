package com.water.reset.action;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.water.reset.dto.BossJob;
import com.water.reset.parse.ParseJob;
import com.water.reset.parse.plugin.BossParse;
import com.water.reset.util.PluginManager;
import com.water.reset.util.RedisKey;
import com.water.reset.util.RedisUtils;
import com.water.reset.utils.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Controller
@Slf4j
public class ReptileParse {
    private static final Integer POOL_SIZE = 5;
    private static final Integer MAX_POOL_SIZE = 5;
    private static final Integer MAX_WAIT = 5;
    private static final Long ALIVE_TIME = 0L;
    private static final double TASK_IS_FULL = 0.9;
    private static final double TASK_NEARLY_FULL = 0.8;
    int count=0;
    private ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("parse-pool-%d").build();
    private ThreadPoolExecutor parsePool=new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, ALIVE_TIME, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(MAX_WAIT), threadFactory);

    @Autowired
    private RedisUtils redisUtils;
    @KafkaListener(groupId = "reptile",topics = "reptile-pages")
    public void crawlerParse(String message){
        parsePool.execute(()->{
            long startTime=System.currentTimeMillis();
            log.info(Thread.currentThread().getName()+"消费者收到消息:" + message);
            JSONObject object= Tool.getJSONObject(message);
            ParseJob parseJob= PluginManager.getPlugin(object.getString("site"));
            parseJob.parse(object);
            log.info(Thread.currentThread().getName()+"已处理完一批");
            log.info("解析任务执行结束，耗时:"+(System.currentTimeMillis()-startTime)+"ms");
            count++;
        });
        log.info("暂时kafka无任务:处理任务数为:"+count);
    }
    @RequestMapping("/test/thread")
    public void crawlerParse2(){
        parsePool.execute(()->{
            long startTime=System.currentTimeMillis();
            log.info(Thread.currentThread().getName()+"消费者收到消息:");
            Tool.sleep(8000);
            log.info(Thread.currentThread().getName()+"已处理完一批，耗时:"+(System.currentTimeMillis()-startTime)+"ms");
            count++;
        });
        parsePool.shutdown();
        log.info("暂时kafka无任务:处理任务数为:"+count);

    }
}
