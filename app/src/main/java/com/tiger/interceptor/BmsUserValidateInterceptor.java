package com.tiger.interceptor;

import com.alibaba.fastjson.JSON;
import com.tiger.pojo.UserBms;
import com.tiger.service.UserBmsService;
import com.tiger.utils.ResponseMessage;
import com.tiger.utils.WebUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class BmsUserValidateInterceptor extends BaseInterceptor {
    @Resource
    private UserBmsService userBmsService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String authToken = httpServletRequest.getParameter("token");
        if (StringUtils.isEmpty(authToken)) {
            WebUtil.serverReturn(httpServletResponse, JSON.toJSONString(ResponseMessage.error(1, "token不能为空")));
            return false;
        }
        UserBms userBms = this.userBmsService.getUserBmsByTokenForCache(authToken);
        if (userBms == null) {
            WebUtil.serverReturn(httpServletResponse, JSON.toJSONString(ResponseMessage.error(8, "token失效")));
            return false;
        }
        httpServletRequest.setAttribute("userBms", userBms);
        return true;
    }
}
