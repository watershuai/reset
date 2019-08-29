/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.tiger.dao.AdvertisementMapper;
/*    */ import com.tiger.pojo.Advertisement;
/*    */ import com.tiger.service.AdvertisementService;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.redis.core.ListOperations;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class AdvertisementServiceImpl
/*    */   extends BaseServiceManager<Advertisement, AdvertisementMapper>
/*    */   implements AdvertisementService
/*    */ {
/*    */   @Autowired
/*    */   private RedisTemplate redisTemplate;
/*    */   
/*    */   @Autowired
/*    */   public void setDao(AdvertisementMapper dao)
/*    */   {
/* 30 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public Advertisement getRandomAdvertisement()
/*    */   {
/* 35 */     List<Advertisement> advertisements = this.redisTemplate.opsForList().range("advertisement_all_list", 0L, -1L);
/*    */     
/* 37 */     if (CollectionUtils.isEmpty(advertisements)) {
/* 38 */       return null;
/*    */     }
/*    */     
/* 41 */     Collections.shuffle(advertisements);
/* 42 */     return (Advertisement)advertisements.get(0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Advertisement> selectPageList(Advertisement advertisement, int pageIndex, int pageSize)
/*    */   {
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\AdvertisementServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */