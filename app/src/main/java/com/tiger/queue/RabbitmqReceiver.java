 package com.tiger.queue;
 
 import com.alibaba.fastjson.JSON;
 import com.tiger.websocket.WebSocketSessionManager;
 import java.io.IOException;
 import java.util.HashMap;
 import javax.websocket.RemoteEndpoint.Basic;
 import javax.websocket.Session;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.amqp.rabbit.annotation.RabbitListener;
 import org.springframework.stereotype.Component;

 @Component
 public class RabbitmqReceiver
 {
/* 22 */   private static final Logger logger = LoggerFactory.getLogger(RabbitmqReceiver.class);
   
   @RabbitListener(queues={"#{webSocketPaySuccessMessageQueue.name}"})
   public void webSocketPaySuccessMessageQueue(String content) {
/* 26 */     HashMap data = (HashMap)JSON.parseObject(content, HashMap.class);
/* 27 */     String token = (String)data.get("token");
/* 28 */     Object order = data.get("order");
/* 29 */     Session session = WebSocketSessionManager.getSession(token);
/* 30 */     if (session == null) {
/* 31 */       return;
     }
     try {
/* 34 */       session.getBasicRemote().sendText(JSON.toJSONString(order));
     } catch (IOException e) {
/* 36 */       e.printStackTrace();
     }
   }
   
   @RabbitListener(queues={"#{webSocketCloseQueue.name}"})
   public void webSocketCloseMessage(String content) {
/* 42 */     logger.info("websocket 客户端关闭 token ====> " + content);
/* 43 */     Session session = WebSocketSessionManager.getSession(content);
/* 44 */     if (session == null) {
/* 45 */       return;
     }
/* 47 */     WebSocketSessionManager.removeSession(content);
   }
 }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\queue\RabbitmqReceiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */