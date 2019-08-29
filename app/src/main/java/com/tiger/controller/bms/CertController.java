/*    */ package com.tiger.controller.bms;
/*    */ 
/*    */ import com.tiger.formbean.CertAddForm;
/*    */ import com.tiger.pojo.CertManage;
/*    */ import com.tiger.service.CertManageService;
/*    */ import java.util.Date;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.beans.BeanUtils;
/*    */ import org.springframework.validation.annotation.Validated;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController("bmsCertController")
/*    */ @RequestMapping({"/bms"})
/*    */ public class CertController
/*    */ {
/*    */   @Resource
/*    */   private CertManageService certManageService;
/*    */   
/*    */   @RequestMapping({"/cert/add"})
/*    */   public Object certAdd(@Validated CertAddForm certAddForm)
/*    */   {
/* 30 */     CertManage certManage = new CertManage();
/* 31 */     BeanUtils.copyProperties(certAddForm, certManage);
/* 32 */     Date date = new Date();
/* 33 */     certManage.setCreateTime(date);
/* 34 */     certManage.setUpdateTime(date);
/* 35 */     boolean insert = this.certManageService.insert(certManage);
/* 36 */     return Boolean.valueOf(insert);
/*    */   }
/*    */   
/*    */   @RequestMapping({"/cert/delete"})
/* 40 */   public Object certDelete(@RequestParam Long id) { return Boolean.valueOf(this.certManageService.deleteById(id)); }
/*    */   
/*    */   @RequestMapping({"/cert/update"})
/*    */   public Object updateCert(CertManage certManage)
/*    */   {
/* 45 */     return Boolean.valueOf(this.certManageService.update(certManage));
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\bms\CertController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */