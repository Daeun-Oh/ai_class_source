package org.koreait.global.member.controllers;

import lombok.Data;

/**
 * 주소를 받을 수 있는 커맨드 객체
 */
@Data
public class RequestAddress {
    private String zoneCode;
    private String address;
    private String addressSub;
}
