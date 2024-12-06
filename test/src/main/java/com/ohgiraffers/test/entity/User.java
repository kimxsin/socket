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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adopt_no")  // 기존 테이블에서 컬럼 이름에 맞추기
    private Long id;

    @Column(name = "adopt_name")  // 기존 테이블에서 컬럼 이름에 맞추기
    private String username;

    @Column(name = "adopt_phone")  // 비밀번호 컬럼도 마찬가지
    private String password;
}
