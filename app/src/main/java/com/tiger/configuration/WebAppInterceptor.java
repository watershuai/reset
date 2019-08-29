/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import com.tiger.interceptor.BaseInterceptor;
/*    */ import com.tiger.interceptor.BmsUserValidateInterceptor;
/*    */ import com.tiger.interceptor.UserValidateInterceptor;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
/*    */ import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class WebAppInterceptor
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   @Bean
/*    */   public UserValidateInterceptor buildUserValidateInterceptor()
/*    */   {
/* 21 */     return new UserValidateInterceptor();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public BaseInterceptor buildBaseInterceptor() {
/* 26 */     return new BaseInterceptor();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public BaseInterceptor buildBmsUserValidateInterceptor() {
/* 31 */     return new BmsUserValidateInterceptor();
/*    */   }
/*    */   
/*    */   public void addInterceptors(InterceptorRegistry registry)
/*    */   {
/* 36 */     super.addInterceptors(registry);
/* 37 */     registry.addInterceptor(buildBaseInterceptor()).addPathPatterns(new String[] { "/**" });
/* 38 */     registry.addInterceptor(buildUserValidateInterceptor()).addPathPatterns(new String[] { "/auth/**" });
/* 39 */     registry.addInterceptor(buildBmsUserValidateInterceptor()).addPathPatterns(new String[] { "/bms/**" });
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\WebAppInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */