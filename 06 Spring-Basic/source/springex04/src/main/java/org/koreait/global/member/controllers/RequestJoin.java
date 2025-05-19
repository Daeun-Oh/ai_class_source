package org.koreait.global.member.controllers;

import lombok.Data;

/**
 * 커멘드 객체 클래스
 */
@Data
public class RequestJoin {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String mobile;
    private boolean agree;
}
