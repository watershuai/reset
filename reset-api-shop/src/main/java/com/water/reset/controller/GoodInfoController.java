package com.water.reset.controller;

import com.water.reset.dto.GoodInfo;
import com.water.reset.dto.ResultInfo;
import com.water.reset.service.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api-shop")
public class GoodInfoController {
    @Autowired
    private GoodInfoService goodInfoService;
    @PostMapping("/goods/insertGoods")
    public ResultInfo insertGoods(GoodInfo goodInfo){
        int row=goodInfoService.insertSelective(goodInfo);
        if (1 == row) {
            return new ResultInfo(200, "商品新增成功");
        }else {
            return new ResultInfo(203, "商品新增异常");
        }
    }
}
