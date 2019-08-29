/*    */ package com.tiger.websocket;
/*    */ 
/*    */ import javax.websocket.Session;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ public abstract interface WebSocketHandler
/*    */ {
/* 10 */   public static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
/*    */   
/*    */   public abstract void receiveHandle(Session paramSession, String paramString);
/*    */   
/*    */   public abstract void sendMessage(String paramString1, String paramString2);
/*    */   
/*    */   public abstract void sendMessage(Session paramSession, String paramString);
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\websocket\WebSocketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */