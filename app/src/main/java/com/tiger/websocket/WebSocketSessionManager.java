/*    */ package com.tiger.websocket;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import javax.websocket.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WebSocketSessionManager
/*    */ {
/* 15 */   private static final ConcurrentHashMap<String, Session> sessions = new ConcurrentHashMap();
/*    */   
/*    */   public static void addSession(String token, Session session) {
/* 18 */     sessions.put(token, session);
/*    */   }
/*    */   
/*    */   public static Session getSession(String token) {
/* 22 */     return (Session)sessions.get(token);
/*    */   }
/*    */   
/*    */   public static Session removeSession(String token) {
/* 26 */     return (Session)sessions.remove(token);
/*    */   }
/*    */   
/*    */   public static List<Session> getSessions() {
/* 30 */     List<Session> sessionList = new ArrayList();
/* 31 */     Set<String> strings = sessions.keySet();
/* 32 */     Iterator<String> iterator = strings.iterator();
/* 33 */     while (iterator.hasNext()) {
/* 34 */       sessionList.add(sessions.get(iterator.next()));
/*    */     }
/* 36 */     return sessionList;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\websocket\WebSocketSessionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */