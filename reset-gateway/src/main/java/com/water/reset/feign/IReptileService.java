package com.water.reset.feign;

import com.water.reset.dto.ResultInfo;
import com.water.reset.dto.UserTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "reset-reptile")
@Component
public interface IReptileService {
    /**
    * 向爬虫推送任务
    */
    @PostMapping(value = "/reptile/create/task")
    ResultInfo task(@RequestBody UserTask userTask);
    /**
     * 向爬虫发送消息
     */
    @PostMapping(value = "/reptile/receiveNews")
    String sendNews(@RequestBody ResultInfo resultInfo);
}
