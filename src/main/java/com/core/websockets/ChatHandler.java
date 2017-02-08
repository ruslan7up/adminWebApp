package com.core.websockets;

import com.core.domain.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ruslan on 26.01.2017.
 */
public class ChatHandler extends TextWebSocketHandler {

    @Autowired
    private ObjectMapper mapper;

    private final ArrayList<Message> lastmessages;
    private List<WebSocketSession> users;

    {
        users = new ArrayList<>();
        lastmessages = new ArrayList<>(6);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        users.remove(session);
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        users.add(session);
        session.sendMessage(new TextMessage(mapper.writeValueAsString(lastmessages)));
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        Message message = null;
        try {
            message = mapper.readValue(jsonTextMessage.getPayload(), Message.class);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        synchronized (lastmessages) {
            lastmessages.add(message);
            if(lastmessages.size()>6) {
                lastmessages.remove(0);
            }
        }
        for (WebSocketSession user: users) {
            user.sendMessage(new TextMessage("["+mapper.writeValueAsString(message)+"]"));
        }
    }

}