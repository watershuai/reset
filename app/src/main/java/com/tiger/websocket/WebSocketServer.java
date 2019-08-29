package com.tiger.websocket;

import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@javax.websocket.server.ServerEndpoint("/webSocket/message")
@Component
public class WebSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        logger.info("sessionId:" + session.getId() + "  新客户端连接");
    }

    @javax.websocket.OnClose
    public void onClose() {
        logger.info("sessionId:" + this.session.getId() + "  已断开连接");
    }

    @javax.websocket.OnMessage
    public void onMessage(String message) {
        WebSocketHandler webSocketHandler = new IWebSocketHandler();
        webSocketHandler.receiveHandle(this.session, message);
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println(this + "；发生错误");
        error.printStackTrace();
    }
}

