package com.water.reset.action;

import com.water.reset.dto.ResultInfo;
import com.water.reset.dto.UserTask;
import com.water.reset.feign.IReptileService;
import com.water.reset.utils.Tool;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
@Slf4j
public class ReptileEnter {
    @Resource
    private IReptileService reptileService;

    @PostMapping("/create/task")
    @ApiOperation(value = "网关推爬虫入口")
    public ResultInfo commonReptile() {
        UserTask userTask = new UserTask();
        userTask.setToken(Tool.getToken());
        ResultInfo resultInfo = reptileService.task(userTask);
        return resultInfo;
    }

    public static void main(String[] args) {

    }


}
