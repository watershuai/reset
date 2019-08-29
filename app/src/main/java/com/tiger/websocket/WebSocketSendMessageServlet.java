/*    */ package com.tiger.websocket;
/*    */ 
/*    */ import com.yz.common.core.utils.StringUtils;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.amqp.core.AnonymousQueue;
/*    */ import org.springframework.amqp.rabbit.core.RabbitTemplate;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
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
/*    */ @WebServlet({"/webSocket/message/send"})
/*    */ @Component
/*    */ public class WebSocketSendMessageServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   @Autowired
/*    */   private RabbitTemplate rabbitTemplate;
/*    */   @Resource
/*    */   private AnonymousQueue webSocketPaySuccessMessageQueue;
/*    */   
/*    */   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
/*    */   {
/* 35 */     doPost(req, resp);
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
/*    */   {
/* 40 */     String message = req.getParameter("message");
/* 41 */     if (StringUtils.isEmpty(message)) {
/* 42 */       return;
/*    */     }
/* 44 */     this.rabbitTemplate.convertAndSend("websocket.pay.success.fanout", this.webSocketPaySuccessMessageQueue.getName(), message);
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\websocket\WebSocketSendMessageServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */