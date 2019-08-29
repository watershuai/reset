/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.tiger.pojo.Advertisement;
/*    */ import com.tiger.service.AdvertisementService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.data.redis.core.ListOperations;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class AdvertisementController
/*    */ {
/*    */   @Value("${sys.fileupload.path}")
/*    */   private String FILE_UPLOAD_PATH;
/*    */   @Value("${cdn.advertisement.url}")
/*    */   private String advertisementUrl;
/*    */   @Autowired
/*    */   private AdvertisementService advertisementService;
/*    */   @Resource
/*    */   private RedisTemplate redisTemplate;
/*    */   
/*    */   @RequestMapping({"/advertisement/list"})
/*    */   public Object advertisementList()
/*    */   {
/* 43 */     List<Advertisement> advertisements = this.advertisementService.selectList(new Advertisement());
/* 44 */     return advertisements;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/advertisement/cache/refresh"})
/*    */   public Object advertisementRefresh() {
/* 49 */     List<Advertisement> advertisements = this.advertisementService.selectList(new Advertisement());
/* 50 */     this.redisTemplate.delete("advertisement_all_list");
/* 51 */     if (CollectionUtils.isEmpty(advertisements)) {
/* 52 */       return Integer.valueOf(1);
/*    */     }
/* 54 */     Long aLong = this.redisTemplate.opsForList().leftPushAll("advertisement_all_list", advertisements);
/* 55 */     return aLong;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\AdvertisementController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */