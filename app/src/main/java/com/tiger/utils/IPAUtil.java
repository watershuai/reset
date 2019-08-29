/*     */ package com.tiger.utils;
/*     */ 
/*     */ import com.dd.plist.NSArray;
/*     */ import com.dd.plist.NSDictionary;
/*     */ import com.dd.plist.NSString;
/*     */ import com.dd.plist.PropertyListParser;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ public class IPAUtil
/*     */ {
/*  21 */   private static final Logger logger = org.slf4j.LoggerFactory.getLogger(IPAUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static File getZipInfo(File file, String unzipDirectory)
/*     */     throws Exception
/*     */   {
/*  31 */     InputStream input = null;
/*  32 */     OutputStream output = null;
/*  33 */     File result = null;
/*  34 */     File unzipFile = null;
/*  35 */     ZipFile zipFile = null;
/*     */     try
/*     */     {
/*  38 */       zipFile = new ZipFile(file);
/*     */       
/*  40 */       String name = file.getName().substring(0, file.getName().lastIndexOf("."));
/*  41 */       unzipFile = new File(unzipDirectory + "/" + name);
/*  42 */       if (unzipFile.exists()) {
/*  43 */         unzipFile.delete();
/*     */       }
/*  45 */       unzipFile.mkdir();
/*     */       
/*  47 */       Enumeration<? extends ZipEntry> zipEnum = zipFile.entries();
/*     */       
/*  49 */       ZipEntry entry = null;
/*  50 */       String entryName = null;
/*  51 */       String[] names = null;
/*     */       
/*     */ 
/*  54 */       while (zipEnum.hasMoreElements())
/*     */       {
/*  56 */         entry = (ZipEntry)zipEnum.nextElement();
/*  57 */         entryName = new String(entry.getName());
/*     */         
/*  59 */         names = entryName.split("\\/");
/*  60 */         int length = names.length;
/*  61 */         for (int v = 0; v < length; v++) {
/*  62 */           if (entryName.endsWith(".app/Info.plist")) {
/*  63 */             input = zipFile.getInputStream(entry);
/*  64 */             result = new File(unzipFile.getAbsolutePath() + "/Info.plist");
/*  65 */             output = new FileOutputStream(result);
/*  66 */             byte[] buffer = new byte[' '];
/*  67 */             int readLen = 0;
/*  68 */             while ((readLen = input.read(buffer, 0, 8192)) != -1) {
/*  69 */               output.write(buffer, 0, readLen);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  77 */       ex.printStackTrace();
/*     */     }
/*     */     finally {
/*  80 */       if (input != null) {
/*  81 */         input.close();
/*     */       }
/*  83 */       if (output != null) {
/*  84 */         output.flush();
/*  85 */         output.close();
/*     */       }
/*     */       
/*  88 */       if (zipFile != null) {
/*  89 */         zipFile.close();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  94 */     if (file.exists()) {
/*  95 */       file.delete();
/*     */     }
/*  97 */     return result;
/*     */   }
/*     */   
/*     */   private static File getIpaInfo(File oldfile)
/*     */     throws java.io.IOException
/*     */   {
/*     */     try
/*     */     {
/* 105 */       int byteread = 0;
/* 106 */       String filename = oldfile.getAbsolutePath().replaceAll(".ipa", ".zip");
/* 107 */       File newfile = new File(filename);
/* 108 */       if (oldfile.exists())
/*     */       {
/* 110 */         InputStream inStream = new FileInputStream(oldfile);
/* 111 */         FileOutputStream fs = new FileOutputStream(newfile);
/* 112 */         byte[] buffer = new byte['֤'];
/* 113 */         while ((byteread = inStream.read(buffer)) != -1) {
/* 114 */           fs.write(buffer, 0, byteread);
/*     */         }
/* 116 */         if (inStream != null) {
/* 117 */           inStream.close();
/*     */         }
/* 119 */         if (fs != null) {
/* 120 */           fs.close();
/*     */         }
/*     */         
/* 123 */         return getZipInfo(newfile, newfile.getParent());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 127 */       e.printStackTrace();
/*     */     }
/* 129 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static Map<String, String> getPkgInfo(File ipa)
/*     */     throws Exception
/*     */   {
/* 137 */     File plistFile = getIpaInfo(ipa);
/* 138 */     InputStream input = new FileInputStream(plistFile);
/* 139 */     byte[] bytes = new byte[input.available()];
/* 140 */     input.read(bytes);
/* 141 */     Map<String, String> pkgInfo = getPkgInfo(bytes);
/*     */     
/* 143 */     plistFile.delete();
/* 144 */     plistFile.getParentFile().delete();
/* 145 */     return pkgInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public static Map<String, String> getPkgInfo(byte[] bytes)
/*     */     throws Exception
/*     */   {
/* 152 */     Map<String, String> info = new HashMap();
/*     */     
/* 154 */     NSDictionary rootDict = (NSDictionary)PropertyListParser.parse(bytes);
/*     */     
/* 156 */     NSString bundleId = (NSString)rootDict.objectForKey("CFBundleIdentifier");
/* 157 */     info.put("bundleId", bundleId.toString());
/*     */     
/* 159 */     NSString appName = (NSString)rootDict.objectForKey("CFBundleName");
/* 160 */     if (appName != null) {
/* 161 */       info.put("appName", appName.toString());
/*     */     }
/*     */     
/* 164 */     NSString appVersion = (NSString)rootDict.objectForKey("CFBundleShortVersionString");
/* 165 */     info.put("appVersion", appVersion.toString());
/*     */     
/* 167 */     NSString appShowName = (NSString)rootDict.objectForKey("CFBundleDisplayName");
/* 168 */     if (appShowName != null) {
/* 169 */       info.put("appName", appShowName.toString());
/*     */     }
/*     */     
/* 172 */     NSString minimumOSVersion = (NSString)rootDict.objectForKey("MinimumOSVersion");
/* 173 */     info.put("minOSVersion", minimumOSVersion.toString());
/*     */     
/* 175 */     NSDictionary iconDict = (NSDictionary)rootDict.get("CFBundleIcons");
/* 176 */     String icon = "";
/*     */     
/* 178 */     while ((null != iconDict) && (!iconDict.isEmpty())) {
/* 179 */       if (iconDict.containsKey("CFBundlePrimaryIcon")) {
/* 180 */         NSDictionary CFBundlePrimaryIcon = (NSDictionary)iconDict.get("CFBundlePrimaryIcon");
/* 181 */         if (CFBundlePrimaryIcon.containsKey("CFBundleIconFiles")) {
/* 182 */           NSArray CFBundleIconFiles = (NSArray)CFBundlePrimaryIcon.get("CFBundleIconFiles");
/* 183 */           int length = CFBundleIconFiles.getArray().length;
/* 184 */           icon = CFBundleIconFiles.getArray()[(length - 1)].toString();
/* 185 */           if (icon.contains(".png")) {
/* 186 */             icon = icon.replace(".png", "");
/*     */           }
/* 188 */           logger.info("获取icon名称:" + icon);
/* 189 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 193 */     info.put("iconName", icon);
/* 194 */     return info;
/*     */   }
/*     */   
/*     */   public static String createPlist(String title, String fileUrl, String bundleId, String versionCode) throws Exception
/*     */   {
/* 199 */     title = title.replace("&", "&amp;");
/* 200 */     title = title.replace("<", "&lt;");
/* 201 */     title = title.replace(">", "&gt;");
/* 202 */     title = title.replace("'", "&apos;");
/* 203 */     title = title.replace("\"", "&quot;");
/* 204 */     String plist = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n<plist version=\"1.0\">\n<dict>\n<key>items</key>\n<array>\n<dict>\n<key>assets</key>\n<array>\n<dict>\n<key>kind</key>\n<string>software-package</string>\n<key>url</key>\n<string>" + fileUrl + "</string>\n</dict>\n</array>\n<key>metadata</key>\n<dict>\n<key>bundle-identifier</key>\n<string>" + bundleId + "</string>\n<key>bundle-version</key>\n<string>" + versionCode + "</string>\n<key>kind</key>\n<string>software</string>\n<key>subtitle</key>\n<string>下载</string>\n<key>title</key>\n<string>" + title + "(安装完成后，请到设置->通用->设备管理->信任企业级应用)</string>\n</dict>\n</dict>\n</array>\n</dict>\n</plist>";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 240 */     return plist;
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\IPAUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */