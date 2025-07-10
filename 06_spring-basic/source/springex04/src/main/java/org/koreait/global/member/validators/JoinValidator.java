package org.koreait.global.member.validators;

import lombok.RequiredArgsConstructor;
import org.koreait.global.member.controllers.RequestJoin;
import org.koreait.global.member.repositories.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        // Bean Validation API를 이용한 커맨드 객체 검증에 실패한 경우
        if (errors.hasErrors()) {
            return;
        }

        /**
         * 1. 필수 항목 검증 (이메일, 비밀번호, 비밀번호 확인, 회원명, 약관 동의) -> 애노테이션으로 해결
         * 2. 비밀번호 자릿수 검증 (8자리 이상) -> 애노테이션으로 해결
         * 3. 중복 가입 여부 체크
         * 4. 비밀번호 확인
         */

        RequestJoin form = (RequestJoin) target;

        // 3. 중복 가입 여부 체크 S
        if (repository.existsByEmail(form.getEmail())) {
            errors.rejectValue("email", "Duplicated");
        }
        // 3. 중복 가입 여부 체크 E

        // 4. 비밀번호 확인 S
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        if (!confirmPassword.equals(password)) {
            errors.rejectValue("confirmPassword", "Mismatch");
        }
        // 4. 비밀번호 확인 E

        boolean globalError = true;
        if (globalError) {
            errors.reject("commonError1", "공통 에러1 발생");
        }

        if (globalError) {
            errors.reject("commonError2", "공통 에러2 발생");
        }
    }
}
