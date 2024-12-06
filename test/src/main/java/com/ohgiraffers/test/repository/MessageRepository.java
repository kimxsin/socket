package com.ohgiraffers.test.repository;

import com.ohgiraffers.test.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUsername(String username);  // 특정 사용자 메시지 찾기
}
