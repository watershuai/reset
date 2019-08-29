package com.water.reset.action;

import com.water.reset.crawler.CrawlerJob;
import com.water.reset.crawler.plugin.BossRecruit;
import com.water.reset.dto.UserTask;
import com.water.reset.redis.RedisUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

@RestController
@RequestMapping("/reptile")
@Slf4j
public class ReptileController {

    @PostMapping("/create/task")
    public String task(@RequestBody UserTask userTask) {
        return userTask.getToken()+"访问成功了";
    }

}
