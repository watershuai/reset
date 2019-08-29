/*    */ package com.tiger.utils;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PngdefryUtil
/*    */ {
/* 17 */   private static final Logger logger = LoggerFactory.getLogger(PngdefryUtil.class);
/*    */   
/*    */   public static void exec(String filePath, String prefix) {
/* 20 */     InputStream in = null;
/*    */     try {
/* 22 */       Process pro = Runtime.getRuntime().exec("./pngdefry -s " + prefix + " " + filePath);
/* 23 */       pro.waitFor();
/* 24 */       in = pro.getInputStream();
/* 25 */       BufferedReader read = new BufferedReader(new InputStreamReader(in));
/* 26 */       String result = read.readLine();
/* 27 */       logger.info("执行结果：" + result);
/*    */     } catch (Exception e) {
/* 29 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\PngdefryUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */