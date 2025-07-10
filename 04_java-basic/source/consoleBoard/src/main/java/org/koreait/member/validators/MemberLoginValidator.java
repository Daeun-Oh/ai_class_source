package org.koreait.member.validators;

import org.koreait.global.validators.RequiredFieldValidator;
import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.RequestLogin;
import org.koreait.member.entities.Member;
import org.koreait.member.exceptions.MemberNotFoundException;
import org.koreait.member.services.MemberInfoService;
import org.mindrot.jbcrypt.BCrypt;

public class MemberLoginValidator implements Validator<RequestLogin>, RequiredFieldValidator {

    private final MemberInfoService service;

    public MemberLoginValidator(MemberInfoService service) {
        this.service = service;
    }

    /**
     * 로그인 유효성 검사
     * 1. 필수 항목 검증 - 이메일, 비밀번호
     * 2. 이메일로 회원이 조회되는지
     * 3. 비밀번호가 일치하는지
     * - 근데 이메일 조회와 비밀번호 조회의 실패를 특정해서 알려주면,
     *   보안상의 문제가 발생할 수 있다.
     *   ex) 비밀번호에 문제가 있는 거면 비밀번호만 계속 돌려본다던지...
     *   그러니까, 메시지를 특정해서 만들지 않고 통일시키자!
     * @param form
     */
    @Override
    public void check(RequestLogin form) {
        String email = form.getEmail();
        String password = form.getPassword();

        // 1. 필수 항목 검증 - 이메일, 비밀번호
        checkString(email, "이메일을 입력하세요.");
        checkString(password, "비밀번호를 입력하세요.");

        String message = "이메일 또는 비밀번호가 일치하지 않습니다.";

        // 2. 이메일로 회원이 조회되는지
        Member member = null;
        try {
            member = service.get(email);
        } catch (MemberNotFoundException e) {}
        checkTrue(member != null, message);

        // 3. 비밀번호가 일치하는지
        checkTrue(BCrypt.checkpw(form.getPassword(), member.getPassword()), message);
    }
}
