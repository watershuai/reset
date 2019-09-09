package com.water.reset.action;

import com.alibaba.fastjson.JSONObject;
import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import com.water.reset.dto.Message;
import com.water.reset.redis.RedisUtils;
import com.water.reset.utils.KafkaService;
import com.water.reset.utils.Tool;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@RestController
@RequestMapping("/reptile")
@Slf4j
public class TestController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/testTask")
    @ApiOperation(value = "测试入口")
    public void testTask() {
        CrawlerJob crawlerJob = new BossRecruit();
        String proxy= redisUtils.getValueByKey("proxyip:118.26.170.209:8080");
        /*if (StringUtils.isNotEmpty(proxy)){
            log.info("获取到的代理为:"+proxy);
            JSONObject jsonObject= Tool.getJSONObject(proxy);
            String ip=jsonObject.getString("proxyIp");
            int port=Integer.parseInt(jsonObject.getString("proxyPort"));
            String proxyType=jsonObject.getString("proxyType").toLowerCase();
            crawlerJob.getHttpHelp().setProxy(ip,port,proxyType);
        }else {
            log.info("获取到的代理为空");
        }*/
        crawlerJob.setKafkaService(kafkaService);
        crawlerJob.grasp();
    }

    @PostMapping("/testRedis")
    @ApiOperation(value = "测试redis")
    public void testRedis() {
        String proxy= redisUtils.getValueByKey("proxyip:118.26.170.209:8080");
        if (StringUtils.isNotEmpty(proxy)){
            log.info("获取到的代理为:"+proxy);
        }else {
            log.info("获取到的代理为空");
        }
    }

    @PostMapping("/testKafka")
    @ApiOperation(value = "测试kafka")
    public void   sendKafka() {
        Message message1 = new Message();
        message1.setMsg("599632114");
       kafkaService.sendMessage(message1);
    }


}
