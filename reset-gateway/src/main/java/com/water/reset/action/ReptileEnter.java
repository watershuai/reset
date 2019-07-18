package com.water.reset.action;

import com.water.reset.feign.IReptileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reptile")
@Slf4j
public class ReptileEnter {
    @Resource
    private IReptileService reptileService;

    @PostMapping("/")
    public  String commonReptile(){
      String result=reptileService.task("147853");
      return result;
    }

    public static void main(String[]args){

    }


}
