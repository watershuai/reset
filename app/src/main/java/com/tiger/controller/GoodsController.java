/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.tiger.pojo.Goods;
/*    */ import com.tiger.service.GoodsService;
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
/*    */ public class GoodsController
/*    */ {
/*    */   @Resource
/*    */   private GoodsService goodsService;
/*    */   
/*    */   @RequestMapping({"/auth/goods"})
/*    */   public Object getGoods()
/*    */   {
/* 24 */     List<Goods> goodses = this.goodsService.selectList(new Goods());
/* 25 */     return goodses;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\GoodsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */