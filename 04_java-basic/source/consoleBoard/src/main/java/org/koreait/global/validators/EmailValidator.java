package org.koreait.global.validators;

public interface EmailValidator {
    default boolean checkEmail(String email) {
        /**
         * 정규표현식: ^[_a-z0-9-]+(\.[_a-z0-9-]+)*@(?:\w+\.)+\w+$
         * ^                   -> 문자열의 시작
         * [_a-z0-9-]+         -> _, a-z, 0-9, - 중 하나 이상 반복
         * (\.[_a-z0-9-]+)*    -> .으로 구분된 추가 단어
         *                       (. 다음에 _, a-z, 0-9, -가 포함된 부분이 0번 이상 나올 수 있다)
         * @                   -> 이메일 구분자 @
         * (?:\w+\.)+          -> \w+는 일반 도메인 문자열, .으로 끝남, ?:는 캡처하지 않는 그룹
         * \w+                 -> \w+는 최상의 도메인
         * $                   -> 문자열의 끝
         */
        return email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
    }
}
