package com.ohgiraffers.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adopt_no")  // 기존 테이블에서 컬럼 이름에 맞추기
    private long id;    // 원래는 long

    @Column(name = "adopt_name")  // 메시지를 보낸 사용자의 이름
    private String username;

    @Column(name = "adopt_email")  // 실제 메시지 내용
    private String message;

    @Column(name = "adopt_start_date")  // 메시지 전송 시간
    private Long timestamp;
}
