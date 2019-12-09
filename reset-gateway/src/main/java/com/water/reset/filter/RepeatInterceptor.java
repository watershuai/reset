package com.water.reset.filter;

import com.alibaba.fastjson.JSON;
import com.hihen.point.common.Result;
import com.hihen.point.dto.Member;
import com.hihen.point.dto.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@Component
public class RepeatInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String basePath = request.getContextPath();
        String path = request.getRequestURI();
        if (!doLoginInterceptor(path, basePath)) {//是否进行登陆拦截
            return true;
        }
        int flag=0;
        String token=request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            flag=1;
        }else {
            Member user=(Member) request.getSession().getAttribute(token);
            if (user == null){
                flag=1;
            }
        }
        if (flag ==1){
            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            Result result=new Result(ResultCode.NO_LOGIN.getCode(),ResultCode.NO_LOGIN.getMessage());
            PrintWriter out = null ;
            out = response.getWriter();
            out.write(JSON.toJSONString(result));
            out.flush();
            out.close();
            return false;
        }
        return true;
    }
    /**
     * 是否进行登陆过滤
     * @param path
     * @param basePath
     * @return
     */
    private boolean doLoginInterceptor(String path,String basePath){
        path = path.substring(basePath.length());
        Set<String> notLoginPaths = new HashSet<>();
        //设置不进行登录拦截的路径：登录注册和验证码
        //notLoginPaths.add("/");
        notLoginPaths.add("/index");
        notLoginPaths.add("/login");
        notLoginPaths.add("/register");
        //notLoginPaths.add("/sys/logout");
        //notLoginPaths.add("/loginTimeout");
        if(notLoginPaths.contains(path)) {
            return false;
        }else {
            return true;
        }
    }

}
