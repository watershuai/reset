/*    */ package com.tiger.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Enumeration;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZipUtil
/*    */ {
/*    */   public static byte[] readApk(File apkFile, String fName)
/*    */   {
/*    */     try
/*    */     {
/* 20 */       int byteread = 0;
/* 21 */       String filename = apkFile.getAbsolutePath().replaceAll(".apk", ".zip");
/* 22 */       File newfile = new File(filename);
/* 23 */       if (apkFile.exists())
/*    */       {
/* 25 */         InputStream inStream = new FileInputStream(apkFile);
/* 26 */         FileOutputStream fs = new FileOutputStream(newfile);
/* 27 */         byte[] buffer = new byte['֤'];
/* 28 */         while ((byteread = inStream.read(buffer)) != -1) {
/* 29 */           fs.write(buffer, 0, byteread);
/*    */         }
/* 31 */         if (inStream != null) {
/* 32 */           inStream.close();
/*    */         }
/* 34 */         if (fs != null) {
/* 35 */           fs.close();
/*    */         }
/*    */       }
/*    */       
/* 39 */       ZipFile zf = new ZipFile(filename);
/*    */       
/* 41 */       String name = zf.getName().substring(0, zf.getName().lastIndexOf("."));
/* 42 */       File unzipFile = new File(newfile.getParent() + "/" + name);
/* 43 */       if (unzipFile.exists()) {
/* 44 */         unzipFile.delete();
/*    */       }
/* 46 */       if (unzipFile.exists()) {
/* 47 */         unzipFile.delete();
/*    */       }
/*    */       
/* 50 */       Enumeration<? extends ZipEntry> zipEnum = zf.entries();
/*    */       
/* 52 */       ZipEntry entry = null;
/* 53 */       String entryName = null;
/*    */       
/* 55 */       while (zipEnum.hasMoreElements())
/*    */       {
/* 57 */         entry = (ZipEntry)zipEnum.nextElement();
/* 58 */         entryName = new String(entry.getName());
/* 59 */         if (entryName.equals(fName)) {
/* 60 */           InputStream input = zf.getInputStream(entry);
/* 61 */           return IOUtil.readInputStream(input);
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 66 */       e.printStackTrace();
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\ZipUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */