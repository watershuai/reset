package com.water.reset.dao;

import com.water.reset.dto.GoodView;

public interface GoodViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodView record);

    int insertSelective(GoodView record);

    GoodView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodView record);

    int updateByPrimaryKey(GoodView record);
}