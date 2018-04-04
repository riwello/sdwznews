package com.liweile.news.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CmdHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> webSocketSessionList = new ArrayList<>();

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        webSocketSessionList.remove(session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        webSocketSessionList.add(session);

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);


    }


    public static void sendMassage(String massage) {
        try {
            for (WebSocketSession webSocketSession : webSocketSessionList) {

                webSocketSession.sendMessage(new TextMessage(massage));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
