package com.water.reset.controller;
import com.water.reset.feign.IReptileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/spider")
@Slf4j
public class SpiderEntry {
    @Resource
    private IReptileService reptileService;
   /* @RequestMapping("/task")
    public String spiderTask(){
        String result=reptileService.task("147853");
        return result;
    }*/
}
