package com.water.reset.action;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import com.water.reset.crawler.plugin.LeJIaCrawler;
import com.water.reset.dto.ResultInfo;
import com.water.reset.dto.UserTask;
import com.water.reset.redis.RedisUtils;
import com.water.reset.utils.KafkaService;
import com.water.reset.utils.PluginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reptile")
@Slf4j
public class ReptileController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private KafkaService kafkaService;
    @PostMapping("/create/task")
    public ResultInfo task(@RequestBody UserTask userTask) {
        ResultInfo resultInfo=null;
        try {
            CrawlerJob crawlerJob = PluginManager.getPlugin(userTask.getSite());
            if (crawlerJob != null) {
                crawlerJob.setKafkaService(kafkaService);
                crawlerJob.setUserTask(userTask);
                crawlerJob.grasp();
                resultInfo = new ResultInfo(200, "任务创建成功，并执行结束");
            }
        }catch (Exception e){
            resultInfo=new ResultInfo(203,"任务执行异常");
            log.error("爬虫异常信息",e);
        }
        return resultInfo;
    }

}
