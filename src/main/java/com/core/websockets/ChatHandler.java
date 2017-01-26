package com.core.websockets;

import com.core.domain.Message;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslan on 26.01.2017.
 */
public class ChatHandler  extends TextWebSocketHandler {

    private List<Message> lastmessages;
    private List<WebSocketSession> users;

    {
        users = new ArrayList<>();
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("CLIENT CLOSE THE CONNECTION");
        users.remove(session);
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        users.add(session);
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        for (WebSocketSession user: users) {
            user.sendMessage(jsonTextMessage);
        }
    }

}