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
    @Autowired
    private GoodInfoService goodInfoService;
    @Autowired
    private IpUtils ipUtils;
    public static final String ss="3333";
    @PostMapping("/goods/insertGoods")
    public ResultInfo insertGoods(@RequestBody GoodInfo goodInfo){
        int row=goodInfoService.insertSelective(goodInfo);
        if (row == 0){
            return new ResultInfo(201, "新增商品失败");
        }
        return new ResultInfo(200, "新增商品成功");
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
