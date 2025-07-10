package org.koreait.global.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
    private boolean saveEmail;  // 이메일 기억하기

    private String redirectUrl; // 로그인 성공 시 이동할 주소 (이전 페이지로)
}
