package org.koreait.member.validators;

import org.koreait.global.validators.MobileValidator;
import org.koreait.global.validators.RequiredFieldValidator;
import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.RequestJoin;

/**
 * 회원정보 수정 시, 유효성 검사
 */
public class MemberUpdateValidator implements Validator<RequestJoin>, RequiredFieldValidator, MobileValidator {
    @Override
    public void check(RequestJoin form) {
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String mobile = form.getMobile();

        // 비밀번호 수정
        if (password != null && !password.isBlank()) {
            checkTrue(password.length() >= 8, "비밀번호는 8자리 이상 입력하세요.");
            checkString(confirmPassword, "비밀번호를 확인하세요.");
            checkTrue(password.equals(confirmPassword), "비밀번호 확인과 일치하지 않습니다.");
        }

        // 전화번호 수정
        if (mobile != null && !mobile.isBlank()) {
            checkTrue(checkMobile(mobile), "전화번호 형식이 아닙니다.");
        }
    }
}
