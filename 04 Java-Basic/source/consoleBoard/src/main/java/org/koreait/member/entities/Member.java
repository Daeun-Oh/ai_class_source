package org.koreait.member.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private long seq;            // 일련번호
    private String email;        // 이메일
    private String password;     // 비밀번호
    private String name;         // 이름
    private String mobile;       // 전화번호
    private boolean terms;       // 약관 동의 여부
    private boolean isAdmin;     // 관리자 여부
    private LocalDateTime regDt; // 가입일시
}
