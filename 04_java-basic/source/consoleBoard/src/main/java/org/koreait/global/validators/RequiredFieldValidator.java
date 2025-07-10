package org.koreait.global.validators;

import org.koreait.member.exceptions.BadRequestException;

public interface RequiredFieldValidator {
    /**
     * Join 검증 시 필수항목(문자열)이 null인지 확인하기 위한 메서드
     * - RuntimeException 대신, 보기 쉽게 message로 변경
     * @param str : 문자열
     * @param message : 문자열이 null일 때 반환할 메시지
     */
    default void checkString(String str, String message) {
        if (str == null || str.isBlank()) {
            throw new BadRequestException(message);
        }
    }

    /**
     * 위와 같은 이유, boolean값(약관 동의 여부)을 확인하기 위한 메서드
     * @param result : 조건식
     * @param message : 조건이 false일 때 반환할 메시지
     */
    default void checkTrue(boolean result, String message) {
        if (!result) {
            throw new BadRequestException(message);
        }
    }
}
