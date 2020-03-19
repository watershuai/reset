package com.water.reset.service.impl;

import com.water.reset.annotation.InputLog;
import com.water.reset.dao.GoodInfoMapper;
import com.water.reset.dto.GoodInfo;
import com.water.reset.service.GoodInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoodInfoServiceImpl implements GoodInfoService {
    private GoodInfoMapper goodInfoMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(GoodInfo record) {
        return 0;
    }

    @Override
    @InputLog(value = "吃鸡腿")
    public int insertSelective(GoodInfo record) {
        //return goodInfoMapper.insertSelective(record);
        return 1;
    }

    @Override
    public GoodInfo selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GoodInfo record) {
        return 0;
    }
}
