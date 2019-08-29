/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import org.springframework.amqp.core.AnonymousQueue;
/*    */ import org.springframework.amqp.core.Binding;
/*    */ import org.springframework.amqp.core.BindingBuilder;
/*    */ import org.springframework.amqp.core.BindingBuilder.DestinationConfigurer;
/*    */ import org.springframework.amqp.core.FanoutExchange;
/*    */ import org.springframework.amqp.core.Queue;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class RabbitMQConfig
/*    */ {
/*    */   public static final String AUTO_SIGN_TASK_QUEUE = "auto_sign_task_queue";
/*    */   public static final String WEBSOCKET_PAY_SUCCESS_MESSAGE_EXCHANGE = "websocket.pay.success.fanout";
/*    */   public static final String WEBSOCKET_CLOASE_EXCHANGE = "websocket.close.fanout";
/*    */   
/*    */   @Bean
/*    */   public Queue autoSignTaskQueue()
/*    */   {
/* 23 */     return new Queue("auto_sign_task_queue");
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public Queue webSocketPaySuccessMessageQueue() {
/* 28 */     return new AnonymousQueue();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public Queue webSocketCloseQueue() {
/* 33 */     return new AnonymousQueue();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public FanoutExchange webSocketSendMessageExchange() {
/* 38 */     return new FanoutExchange("websocket.pay.success.fanout");
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public FanoutExchange webSocketCloseExchange() {
/* 43 */     return new FanoutExchange("websocket.close.fanout");
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public Binding bindingWebSocketSendMessageExchange() {
/* 48 */     return BindingBuilder.bind(webSocketPaySuccessMessageQueue()).to(webSocketSendMessageExchange());
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public Binding bindingWebSocketCloseExchange() {
/* 53 */     return BindingBuilder.bind(webSocketCloseQueue()).to(webSocketCloseExchange());
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\RabbitMQConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */