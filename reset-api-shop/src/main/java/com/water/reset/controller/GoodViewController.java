package com.water.reset.controller;

import com.water.reset.dto.GoodInfo;
import com.water.reset.dto.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodViewController {
    @Autowired
    private GoodInfoController goodInfoController;

}
