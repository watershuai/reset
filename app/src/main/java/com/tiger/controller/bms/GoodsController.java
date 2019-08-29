 package com.tiger.controller.bms;
 
 import com.tiger.pojo.Goods;
 import com.tiger.service.GoodsService;
 import java.util.List;
 import javax.annotation.Resource;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 
 
 
 
 
 @RestController("bmsGoodsController")
 @RequestMapping({"/bms"})
 public class GoodsController
 {
   @Resource
   private GoodsService goodsService;
   
   @RequestMapping({"/goods/list"})
   public Object getGoods()
   {
     List<Goods> goodses = this.goodsService.selectList(new Goods());
     return goodses;
   }
   
   @RequestMapping({"/goods/update"})
   public Object updateGoods(Goods goods) {
     boolean update = this.goodsService.update(goods);
    return Boolean.valueOf(update);
   }
 }

