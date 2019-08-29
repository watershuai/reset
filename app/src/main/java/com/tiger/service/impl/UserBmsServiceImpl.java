package com.tiger.service.impl;

import com.tiger.dao.UserBmsMapper;
import com.tiger.pojo.UserBms;
import com.tiger.service.BaseServiceManager;
import com.tiger.service.UserBmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserBmsServiceImpl extends BaseServiceManager<UserBms, UserBmsMapper> implements UserBmsService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    public void setDao(UserBmsMapper userBmsMapper) {
        this.dao = userBmsMapper;
    }

    public UserBms getUserBmsByTokenForCache(String token) {
        UserBms userBms = (UserBms)redisTemplate.opsForHash().get("hash_bms_user_token", token);
        if (userBms == null) {
            userBms = new UserBms();
            userBms.setToken(token);
            userBms =  dao.selectOne(userBms);
            if (userBms != null) {
                this.redisTemplate.opsForHash().put("hash_bms_user_token", token, userBms);
            }
        }
        return userBms;
    }
}