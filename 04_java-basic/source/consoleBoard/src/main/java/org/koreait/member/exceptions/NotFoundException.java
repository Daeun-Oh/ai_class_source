package org.koreait.member.exceptions;

// 데이터를 못 찾았다
public class NotFoundException extends CommonException {

    public NotFoundException() {
        this("데이터를 찾을 수 없습니다.");
    }

    public NotFoundException(String message) {
        super(message, 404);
    }
}
