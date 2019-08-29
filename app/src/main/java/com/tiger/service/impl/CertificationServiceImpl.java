/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.CertificationMapper;
/*    */ import com.tiger.pojo.Certification;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.CertificationService;
/*    */ import com.yz.common.core.exception.HandlerException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tk.mybatis.mapper.entity.Example;
/*    */ import tk.mybatis.mapper.entity.Example.Criteria;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class CertificationServiceImpl
/*    */   extends BaseServiceManager<Certification, CertificationMapper>
/*    */   implements CertificationService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(CertificationMapper certificationMapper)
/*    */   {
/* 24 */     this.dao = certificationMapper;
/*    */   }
/*    */   
/*    */   public boolean updateByUserId(Certification certification) throws HandlerException
/*    */   {
/* 29 */     Long userId = certification.getUserId();
/* 30 */     if ((userId == null) || (userId.longValue() <= 0L)) {
/* 31 */       throw new HandlerException(32, "invoke com.tiger.service.impl.updateByUserId method params userId is not null");
/*    */     }
/* 33 */     certification.setUserId(null);
/* 34 */     Example example = new Example(Certification.class);
/* 35 */     example.createCriteria().andEqualTo("userId", certification.getUserId());
/* 36 */     int i = ((CertificationMapper)this.dao).updateByExampleSelective(certification, example);
/* 37 */     return i > 0;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\CertificationServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */