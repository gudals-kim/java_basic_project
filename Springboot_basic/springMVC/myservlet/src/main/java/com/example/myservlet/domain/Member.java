package com.example.myservlet.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
//    회원 정보
//    이름: username
//    나이: age
//    기능 요구사항
//    회원 저장
//    회원 목록 조회

    private Long id;
    private String username;
    private int age;

    public Member() {
    }
    //ID가 없는 이유는 저장소(레파지토리)에 저장할때 부여할것이다.
    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
