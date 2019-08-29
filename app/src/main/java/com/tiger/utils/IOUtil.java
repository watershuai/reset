/*    */ package com.tiger.utils;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IOUtil
/*    */ {
/*    */   public static byte[] readInputStream(InputStream inputStream)
/*    */     throws Exception
/*    */   {
/* 14 */     byte[] buffer = new byte['Ѐ'];
/* 15 */     int len = -1;
/* 16 */     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 17 */     while ((len = inputStream.read(buffer)) != -1) {
/* 18 */       outputStream.write(buffer, 0, len);
/*    */     }
/* 20 */     outputStream.close();
/* 21 */     inputStream.close();
/* 22 */     return outputStream.toByteArray();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\IOUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */