package com.water.reset.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class IntercpetorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private RepeatInterceptor repeatInterceptor;
    /**
     * 不需要登录拦截的url:登录注册和验证码
     */
    final String[] notLoginInterceptPaths = {"/login/**","/index/**","/register/**"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatInterceptor).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
    }

}
