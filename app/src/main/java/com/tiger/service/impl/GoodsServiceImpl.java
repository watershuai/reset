/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.GoodsMapper;
/*    */ import com.tiger.pojo.Goods;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.GoodsService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class GoodsServiceImpl
/*    */   extends BaseServiceManager<Goods, GoodsMapper>
/*    */   implements GoodsService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(GoodsMapper dao)
/*    */   {
/* 23 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<Goods> selectPageList(Goods goods, int i, int i1)
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\GoodsServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */