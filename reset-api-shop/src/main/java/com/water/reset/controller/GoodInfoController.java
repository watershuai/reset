package com.water.reset.controller;

import com.water.reset.annotation.InputLog;
import com.water.reset.dto.GoodInfo;
import com.water.reset.dto.ResultInfo;
import com.water.reset.service.GoodInfoService;
import com.water.reset.utils.IpUtils;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api-shop")
public class GoodInfoController {
    /*@Autowired
    private GoodInfoService goodInfoService;
    @Autowired
    private IpUtils ipUtils;*/
    public static final String ss="3333";
    @GetMapping("/goods/insertGoods/{id}/{name}")
    public ResultInfo insertGoods(@PathVariable("id") String id, @PathVariable("name") String name){
        //int row=goodInfoService.insertSelective(goodInfo);
        String s1=id+"......"+name;
        return new ResultInfo(200, s1);
    }
    @InputLog(value = "45545")
    @RequestMapping(value = "/say")
    public String sayHello() {
        System.out.println("方法种得值");
        return "hello spring boot";
    }
    @InputLog(value = "99999")
    @RequestMapping(value = "/say2")
    public String sayHello2() {
        System.out.println("方法种得值2");
        return "hello spring boot2";
    }

}
