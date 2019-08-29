/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.tiger.dao.ShortLinkMapper;
/*    */ import com.tiger.pojo.ShortLink;
/*    */ import com.tiger.service.ValidateService;
/*    */ import com.tiger.utils.RandomUtil;
/*    */ import com.yz.common.core.utils.VerifyCodeUtil;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import javax.annotation.Resource;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.servlet.ServletOutputStream;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
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
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class MainController
/*    */ {
/*    */   @Resource
/*    */   private ShortLinkMapper shortLinkMapper;
/*    */   @Resource
/*    */   private ValidateService validateService;
/*    */   @Resource
/*    */   private RedisTemplate redisTemplate;
/*    */   
/*    */   @RequestMapping({"/create/shortLink"})
/*    */   public Object createShortLink(@RequestParam(required=false, defaultValue="100") int size)
/*    */   {
/* 44 */     List list = new ArrayList();
/* 45 */     for (int i = 0; i < size; i++) {
/* 46 */       ShortLink shortLink = new ShortLink();
/* 47 */       String sl = RandomUtil.randomNumAndChar(4);
/* 48 */       shortLink.setLinkValue(sl);
/* 49 */       shortLink.setCreateTime(new Date());
/* 50 */       boolean insert = this.shortLinkMapper.insertSelective(shortLink) > 0;
/* 51 */       if (insert) {
/* 52 */         list.add(sl);
/*    */       }
/*    */     }
/* 55 */     return list;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/register/verficationCode"})
/*    */   public void registerVerfificationCode(HttpServletResponse response) {
/* 60 */     response.setContentType("image/png");
/* 61 */     String verifyCode = this.validateService.generatePictureVerifyCode(4, "register_verify_code", 10L, TimeUnit.MINUTES);
/* 62 */     BufferedImage image = VerifyCodeUtil.getImage(300, 50, verifyCode);
/*    */     try {
/* 64 */       ServletOutputStream outputStream = response.getOutputStream();
/* 65 */       ImageIO.write(image, "png", outputStream);
/*    */     } catch (IOException e) {
/* 67 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updatepassword/verficationCode"})
/*    */   public void updatePasswordVerfificationCode(HttpServletResponse response) {
/* 73 */     response.setContentType("image/png");
/* 74 */     String verifyCode = this.validateService.generatePictureVerifyCode(4, "update_password_verify_code", 10L, TimeUnit.MINUTES);
/* 75 */     BufferedImage image = VerifyCodeUtil.getImage(300, 50, verifyCode);
/*    */     try {
/* 77 */       ServletOutputStream outputStream = response.getOutputStream();
/* 78 */       ImageIO.write(image, "png", outputStream);
/*    */     } catch (IOException e) {
/* 80 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\MainController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */