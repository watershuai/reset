package com.water.reset.dao;

import com.water.reset.dto.UserMember;

public interface UserMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserMember record);

    int insertSelective(UserMember record);

    UserMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserMember record);

    int updateByPrimaryKey(UserMember record);
}