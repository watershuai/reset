package com.water.reset.feign;

import com.water.reset.domain.ResultInfo;
import com.water.reset.domain.UserTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "reset-reptile")
@Component
public interface IReptileService {
    /**
    * 向爬虫推送任务
    */
    @PostMapping(value = "/reptile/task")
    String task(@RequestBody UserTask userTask);
    /**
     * 向爬虫发送消息
     */
    @PostMapping(value = "/reptile/receiveNews")
    String sendNews(@RequestBody ResultInfo resultInfo);
}
