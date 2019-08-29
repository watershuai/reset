 package com.tiger.controller.bms;
 
 import com.tiger.pojo.Advertisement;
 import com.tiger.service.AdvertisementService;
 import java.io.File;
 import java.io.IOException;
 import java.util.Date;
 import javax.annotation.Resource;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.data.redis.core.RedisTemplate;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.multipart.MultipartFile;

 
 @RestController("bmsAdvertisementController")
 @RequestMapping({"/bms"})
 public class AdvertisementController
 {
   @Value("${sys.fileupload.path}")
   private String FILE_UPLOAD_PATH;
   @Value("${cdn.advertisement.url}")
   private String advertisementUrl;
   @Autowired
   private AdvertisementService advertisementService;
   @Resource
   private RedisTemplate redisTemplate;
   
   @RequestMapping({"/advertisement/add"})
   public Object advertisementAdd(MultipartFile file, String remarks, String linkUrl)
     throws IOException
   {
/* 42 */     String originalFilename = file.getOriginalFilename();
/* 43 */     String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
/* 44 */     String fileName = System.currentTimeMillis() + fileType;
/* 45 */     String pathName = this.FILE_UPLOAD_PATH + "advertisement/" + fileName;
/* 46 */     File floder = new File(this.FILE_UPLOAD_PATH + "advertisement");
/* 47 */     if (!floder.exists()) {
/* 48 */       floder.mkdirs();
     }
/* 50 */     file.transferTo(new File(pathName));
/* 51 */     Advertisement advertisement = new Advertisement();
/* 52 */     advertisement.setUrl(this.advertisementUrl + fileName);
/* 53 */     advertisement.setRemarks(remarks);
/* 54 */     advertisement.setLinkUrl(linkUrl);
/* 55 */     advertisement.setCreateTime(new Date());
/* 56 */     boolean insert = this.advertisementService.insert(advertisement);
/* 57 */     return Boolean.valueOf(insert);
   }
   
   @RequestMapping({"/advertisement/delete"})
   public Object advertisementDel(@RequestParam Integer id) {
/* 62 */     boolean b = this.advertisementService.deleteById(Long.valueOf(id.longValue()));
/* 63 */     return Boolean.valueOf(b);
   }
 }
