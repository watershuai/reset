/*    */ package com.tiger.websocket;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.yz.common.core.utils.StringUtils;
/*    */ import java.io.IOException;
/*    */ import javax.websocket.RemoteEndpoint.Basic;
/*    */ import javax.websocket.Session;
/*    */ import org.slf4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IWebSocketHandler
/*    */   implements WebSocketHandler
/*    */ {
/*    */   public void receiveHandle(Session session, String message)
/*    */   {
/* 17 */     Protocol protocol = (Protocol)JSON.parseObject(message, Protocol.class);
/* 18 */     if (protocol.getOpt() == 1) {
/* 19 */       if (StringUtils.isEmpty(protocol.getToken())) {
/* 20 */         return;
/*    */       }
/* 22 */       WebSocketSessionManager.addSession(protocol.getToken(), session);
/* 23 */     } else if (protocol.getOpt() != 2) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void sendMessage(String token, String message)
/*    */   {
/* 31 */     Session session = WebSocketSessionManager.getSession(token);
/* 32 */     if (session == null) {
/* 33 */       return;
/*    */     }
/*    */     try {
/* 36 */       session.getBasicRemote().sendText(message);
/*    */     } catch (IOException e) {
/* 38 */       logger.info("消息发送失败");
/*    */     }
/*    */   }
/*    */   
/*    */   public void sendMessage(Session session, String message)
/*    */   {
/*    */     try {
/* 45 */       session.getBasicRemote().sendText(message);
/*    */     } catch (IOException e) {
/* 47 */       logger.info("消息发送失败");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\websocket\IWebSocketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */