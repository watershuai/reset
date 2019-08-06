package com.water.reset.action;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;

@RestController
@RequestMapping("/reptile")
@Slf4j
public class ReptileController {
    @PostMapping("/task")
    public String task(String id) {
        return id + "访问成功了";
    }

    @PostMapping("/testTask")
    @ApiOperation(value = "测试入口")
    public void testTask() {
        CrawlerJob crawlerJob = new BossRecruit();
        crawlerJob.grasp();
    }

}
