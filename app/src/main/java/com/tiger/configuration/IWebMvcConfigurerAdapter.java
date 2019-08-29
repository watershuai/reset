/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class IWebMvcConfigurerAdapter
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   public void addResourceHandlers(ResourceHandlerRegistry registry)
/*    */   {
/* 16 */     registry.addResourceHandler(new String[] { "/templates/**" }).addResourceLocations(new String[] { "classpath:/templates/" });
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\IWebMvcConfigurerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */