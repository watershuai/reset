package com.water.reset.service;

import com.water.reset.dto.GoodInfo;

public interface GoodInfoService {
    int deleteByPrimaryKey(Long id);

    int insert(GoodInfo record);

    int insertSelective(GoodInfo record);

    GoodInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodInfo record);

    int updateByPrimaryKey(GoodInfo record);
}
