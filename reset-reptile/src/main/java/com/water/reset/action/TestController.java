package com.water.reset.action;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import com.water.reset.redis.RedisUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/testTask")
    @ApiOperation(value = "测试入口")
    public void testTask() {
        CrawlerJob crawlerJob = new BossRecruit();
        crawlerJob.grasp();
    }

    @PostMapping("/testRedis")
    @ApiOperation(value = "测试redis")
    public void testRedis() {
        redisUtils.setString("我是测试","测试时我");
    }
}
