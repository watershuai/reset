/*    */ package com.tiger.h5;
/*    */ 
/*    */ import com.tiger.pojo.MobileConfigApp;
/*    */ import com.tiger.service.MobileConfigAppService;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller("h5MobileConfigAppController")
/*    */ public class MobileConfigAppController
/*    */ {
/*    */   @Resource
/*    */   private MobileConfigAppService mobileConfigAppService;
/*    */   
/*    */   @RequestMapping({"/app/mobileconfig/{id}"})
/*    */   public String downPage(@PathVariable(name="id") Long id, ModelMap modelMap)
/*    */   {
/* 25 */     MobileConfigApp mobileConfigApp = (MobileConfigApp)this.mobileConfigAppService.selectById(id);
/* 26 */     mobileConfigApp.setMobileConfigUrl(null);
/* 27 */     modelMap.put("mobileConfigApp", mobileConfigApp);
/* 28 */     return "mobileconfig";
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\h5\MobileConfigAppController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */