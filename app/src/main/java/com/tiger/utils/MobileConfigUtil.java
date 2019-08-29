/*     */ package com.tiger.utils;
/*     */ 
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MobileConfigUtil
/*     */ {
/*     */   private String displayName;
/*     */   private String webUrl;
/*     */   private String icon;
/*  18 */   private boolean allowDelete = true;
/*     */   
/*     */   public String create() {
/*  21 */     String uuid = UUID.randomUUID().toString().toUpperCase();
/*  22 */     return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n<plist version=\"1.0\">\n<dict>\n\t<key>PayloadContent</key>\n\t<array>\n\t\t<dict>\n\t\t\t<key>FullScreen</key>\n\t\t\t<true/>\n\t\t\t<key>Icon</key>\n\t\t\t<data>" + this.icon + "</data>\n\t\t\t<key>IsRemovable</key>\n\t\t\t<true/>\n\t\t\t<key>Label</key>\n\t\t\t<string>" + this.displayName + "</string>\n\t\t\t<key>PayloadDescription</key>\n\t\t\t<string>配置 Web Clip 设置</string>\n\t\t\t<key>PayloadDisplayName</key>\n\t\t\t<string>Web Clip</string>\n\t\t\t<key>PayloadIdentifier</key>\n\t\t\t<string>com.apple.webClip.managed.DE55DE7D-B62B-41B6-92F3-6DB1FF999AE2</string>\n\t\t\t<key>PayloadType</key>\n\t\t\t<string>com.apple.webClip.managed</string>\n\t\t\t<key>PayloadUUID</key>\n\t\t\t<string>DE55DE7D-B62B-41B6-92F3-6DB1FF999AE2</string>\n\t\t\t<key>PayloadVersion</key>\n\t\t\t<integer>1</integer>\n\t\t\t<key>Precomposed</key>\n\t\t\t<true/>\n\t\t\t<key>URL</key>\n\t\t\t<string>" + this.webUrl + "</string>\n\t\t</dict>\n\t</array>\n<key>PayloadDescription</key>\n\t<string>请点击右上角的“安装”按钮\n该安装会在您的手机桌面上添加一个网站的入口\n如果手机设置了锁屏密码，需要输入密码后才能完成安装，请放心安装</string>\t<key>PayloadDisplayName</key>\n\t<string>" + this.displayName + "</string>\n\t<key>PayloadIdentifier</key>\n\t<string>" + uuid + "</string>\n\t<key>PayloadRemovalDisallowed</key>\n\t<" + this.allowDelete + "/>\n\t<key>PayloadType</key>\n\t<string>Configuration</string>\n\t<key>PayloadUUID</key>\n\t<string>0E308B9D-1F60-48D2-99CB-BFD49E587D13</string>\n\t<key>PayloadVersion</key>\n\t<integer>1</integer>\n</dict>\n</plist>\n";
/*     */   }
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
/*     */   public String getDisplayName()
/*     */   {
/*  76 */     return this.displayName;
/*     */   }
/*     */   
/*     */   public void setDisplayName(String displayName) {
/*  80 */     this.displayName = displayName;
/*     */   }
/*     */   
/*     */   public String getWebUrl() {
/*  84 */     return this.webUrl;
/*     */   }
/*     */   
/*     */   public void setWebUrl(String webUrl) {
/*  88 */     this.webUrl = webUrl;
/*     */   }
/*     */   
/*     */   public String getIcon() {
/*  92 */     return this.icon;
/*     */   }
/*     */   
/*     */   public void setIcon(String icon) {
/*  96 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public boolean isAllowDelete() {
/* 100 */     return this.allowDelete;
/*     */   }
/*     */   
/*     */   public void setAllowDelete(boolean allowDelete) {
/* 104 */     this.allowDelete = allowDelete;
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\MobileConfigUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */