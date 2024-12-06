package com.ohgiraffers.test.service;

import com.ohgiraffers.test.entity.Message;
import com.ohgiraffers.test.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(String username, String message) {
        Message newMessage = new Message();
        newMessage.setUsername(username);
        newMessage.setMessage(message);
        newMessage.setTimestamp(System.currentTimeMillis());  // 현재 시간 저장
        messageRepository.save(newMessage);
    }
}
