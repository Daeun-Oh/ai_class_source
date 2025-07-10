package org.koreait.global.member.validators;

import lombok.RequiredArgsConstructor;
import org.koreait.global.member.controllers.RequestLogin;
import org.koreait.global.member.entities.Member;
import org.koreait.global.member.repositories.MemberRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 이메일로 회원이 조회되는지
         * 2. 조회된 회원의 비밀번호가 일치하는지 체크
         */
        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword();

        // 1.
        Member member = repository.findByEmail(email).orElse(null);
        if (member == null) {
            errors.reject("Invalid.login");
        }

        // 2.
        // pw가 일치하지 않을 때
        if (member != null && !BCrypt.checkpw(password, member.getPassword())) {
            errors.reject("Invalid.login");
        }
    }
}
