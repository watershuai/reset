package com.tiger.controller.bms; /*    */

import com.tiger.pojo.UserBms;
import com.tiger.service.AccountService;
import com.tiger.service.UserBmsService;
import com.yz.common.core.exception.HandlerException;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("bmsUserController")
@Validated
public class UserController {
    @Resource
    private UserBmsService userBmsService;
    @Resource
    private AccountService accountService;
    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping({"/bms_user/login"})
    public Object bmsUserLogin(String userName, String password) throws HandlerException {
        UserBms userBms = new UserBms();
        userBms.setUserName(userName);
        userBms = userBmsService.selectOne(userBms);
        if (userBms == null) {
            throw new HandlerException(3, "账号不存在");
        }
        if (!password.equals(userBms.getPassword())) {
            throw new HandlerException(4, "密码错误");
        }
        String token = this.accountService.createToken();
        UserBms ub = new UserBms();
        ub.setToken(token);
        ub.setId(userBms.getId());
        boolean update = this.userBmsService.update(ub);
        if (!update) {
            throw new HandlerException(32, "登录失败请重新尝试！");
        }
        userBms.setToken(token);
        redisTemplate.opsForHash().delete("hash_bms_user_token", new Object[]{userBms.getToken()});
        redisTemplate.opsForHash().put("hash_bms_user_token", token, userBms);
        userBms.setPassword("");
        return userBms;
    }
}