/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.tiger.pojo.CertManage;
/*    */ import com.tiger.service.CertManageService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class CertController
/*    */ {
/*    */   @Resource
/*    */   private CertManageService certManageService;
/*    */   
/*    */   @RequestMapping({"/cert/list"})
/*    */   public Object getAllCertList()
/*    */   {
/* 24 */     List<CertManage> certManages = this.certManageService.selectList(new CertManage());
/* 25 */     return certManages;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\CertController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */