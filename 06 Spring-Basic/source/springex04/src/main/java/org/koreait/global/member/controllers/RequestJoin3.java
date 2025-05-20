package org.koreait.global.member.controllers;

import lombok.Data;

import java.util.List;

/**
 * 커맨드 객체 클래스
 */
@Data
public class RequestJoin3 {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String mobile;
    private boolean agree;

    // 커맨드 안에 커맨드 객체 (중첩된 커맨드 객체)
    private RequestAddress addr;

    private List<String> hobby;
}
