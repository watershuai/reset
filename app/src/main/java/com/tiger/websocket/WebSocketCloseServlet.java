/*    */ package com.tiger.websocket;
/*    */ 
/*    */ import com.yz.common.core.utils.StringUtils;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.amqp.core.AnonymousQueue;
/*    */ import org.springframework.amqp.rabbit.core.RabbitTemplate;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;

/*    */ @WebServlet({"/webSocket/close"})
/*    */ @Component
/*    */ public class WebSocketCloseServlet
/*    */   extends HttpServlet
/*    */ {
/* 30 */   private static final Logger logger = LoggerFactory.getLogger(WebSocketCloseServlet.class);
/*    */   
/*    */   @Autowired
/*    */   private RabbitTemplate rabbitTemplate;
/*    */   
/*    */   @Resource
/*    */   private AnonymousQueue webSocketCloseQueue;
/*    */   
/*    */   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
/*    */   {
/* 40 */     doPost(req, resp);
/*    */   }

/*    */   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
/*    */   {
/* 45 */     String token = req.getParameter("token");
/* 46 */     if (StringUtils.isEmpty(token)) {
/* 47 */       return;
/*    */     }
/* 49 */     this.rabbitTemplate.convertAndSend("websocket.close.fanout", this.webSocketCloseQueue.getName(), token);
/* 50 */     logger.info("发送 web socket 断开通知 token:" + token);
/*    */   }
/*    */ }

