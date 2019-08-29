/*    */ package com.tiger.controller;
/*    */ 
/*    */ import com.dd.plist.NSDictionary;
/*    */ import com.dd.plist.NSString;
/*    */ import com.dd.plist.PropertyListParser;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class UDIDController
/*    */ {
/*    */   @Value("${server.hostName}")
/*    */   private String serverHostName;
/*    */   
/*    */   @RequestMapping({"/getUDID.mobileconfig"})
/*    */   public void getUDID(String shortLink, HttpServletResponse response)
/*    */     throws IOException
/*    */   {
/* 31 */     response.setContentType("application/x-apple-aspen-config");
/* 32 */     Pattern compile = Pattern.compile("//(www.)?(\\w+(\\.)?)+");
/* 33 */     Matcher matcher = compile.matcher(this.serverHostName);
/* 34 */     matcher.find();
/* 35 */     String domain = matcher.group().substring(2);
/* 36 */     String xmlPlist = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n<plist version=\"1.0\">\n    <dict>\n        <key>PayloadContent</key>\n        <dict>\n            <key>URL</key>\n            <string>" + this.serverHostName + "/getUDID?shortLink=" + shortLink + "</string>\n            <key>DeviceAttributes</key>\n            <array>\n                <string>UDID</string>\n                <string>IMEI</string>\n                <string>ICCID</string>\n                <string>VERSION</string>\n                <string>PRODUCT</string>\n            </array>\n        </dict>\n        <key>PayloadOrganization</key>\n        <string>" + domain + "</string>  <!--组织名称-->\n        <key>PayloadDisplayName</key>\n        <string>查询设备UDID</string>  <!--安装时显示的标题-->\n        <key>PayloadVersion</key>\n        <integer>1</integer>\n        <key>PayloadUUID</key>\n        <string>3C4DC7D2-E475-3375-489C-0BB8D737A653</string>  <!--自己随机填写的唯一字符串，http://www.guidgen.com/ 可以生成-->\n        <key>PayloadIdentifier</key>\n        <string>dev.skyfox.profile-service</string>\n        <key>PayloadDescription</key>\n        <string>本文件仅用来获取设备ID</string>   <!--描述-->\n        <key>PayloadType</key>\n        <string>Profile Service</string>\n    </dict>\n</plist>";
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 69 */     response.getWriter().write(xmlPlist);
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getUDID"})
/*    */   public void getUDID(String shortLink, HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 74 */     response.setContentType("text/html;charset=UTF-8");
/* 75 */     request.setCharacterEncoding("UTF-8");
/* 76 */     InputStream is = request.getInputStream();
/* 77 */     BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
/* 78 */     StringBuilder sb = new StringBuilder();
/* 79 */     String buffer = null;
/* 80 */     while ((buffer = br.readLine()) != null) {
/* 81 */       sb.append(buffer);
/*    */     }
/* 83 */     String content = sb.toString().substring(sb.toString().indexOf("<?xml"), sb.toString().indexOf("</plist>") + 8);
/* 84 */     NSDictionary rootDict = (NSDictionary)PropertyListParser.parse(content.getBytes());
/* 85 */     NSString UDID = (NSString)rootDict.objectForKey("UDID");
/* 86 */     response.setStatus(301);
/* 87 */     response.setHeader("Location", this.serverHostName + "/" + shortLink + "?UDID=" + UDID);
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\controller\UDIDController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */