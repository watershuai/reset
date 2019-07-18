package com.water.reset.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reptile")
@Slf4j
public class ReptileController {
  @RequestMapping("/task")
  public String task(String id){
      return id+"访问成功了";
  }

}
