package com.water.reset.action;

import com.water.reset.domain.UserTask;
import com.water.reset.feign.IReptileService;
import com.water.reset.utils.Tool;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String commonReptile() {
        UserTask userTask = new UserTask();
        userTask.setToken(Tool.getToken());
        String result = reptileService.task(userTask);
        return result;
    }

    public static void main(String[] args) {

    }


}
