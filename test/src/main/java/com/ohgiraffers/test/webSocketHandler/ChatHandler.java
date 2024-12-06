package com.ohgiraffers.test.webSocketHandler;

import com.ohgiraffers.test.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ChatHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> list = new ArrayList<>();
    private final MessageService messageService;

    // MessageService 의존성 주입
    public ChatHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : " + payload);

        String[] parts = payload.split(":", 2);
        if (parts.length == 2) {
            String username = parts[0];
            String msg = parts[1];

            // DB에 메시지 저장
            messageService.saveMessage(username, msg);

            // 모든 클라이언트에게 메시지 전송
            for (WebSocketSession sess : list) {
                sess.sendMessage(message);
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info(session + " 클라이언트 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해제");
        list.remove(session);
    }
}
