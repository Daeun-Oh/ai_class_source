package org.koreait.member.validators;

import org.koreait.global.validators.EmailValidator;
import org.koreait.global.validators.MobileValidator;
import org.koreait.global.validators.RequiredFieldValidator;
import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.mappers.MemberMapper;

public class MemberJoinValidator implements Validator<RequestJoin>, RequiredFieldValidator, EmailValidator, MobileValidator {

    public final MemberMapper mapper;

    public MemberJoinValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 회원가입 데이터 유효성 검사
     * 1. 필수 항목 - 이메일, 비밀번호, 비밀번호 확인, 휴대전화 번호, 약관동의
     * 2. 이메일 중복 여부, 회원을 인증하는 것이 이메일이므로 중복되면 안 됨
     * 3. 이메일 형식 체크 (xxx@xx.xx)
     * 4. 비밀번호는 8자리 이상, 비밀번호 확인과 일치 여부
     * 5. 휴대전화 번호 형식 체크 (010-xxxx-xxxx)
     * @param form : 데이터
     */
    @Override
    public void check(RequestJoin form) {
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String name = form.getName();
        String mobile = form.getMobile();
        boolean terms = form.isTerms();

        // 1. 필수 항목이 유효한지 체크 (null이면 예외 메시지)
        checkString(email, "이메일을 입력하세요.");
        checkString(password, "비밀번호를 입력하세요.");
        checkString(confirmPassword, "비밀번호를 확인하세요.");
        checkString(name, "회원명을 입력하세요.");
        checkString(mobile, "전화번호를 확인하세요.");
        checkTrue(terms, "약관에 동의해 주세요.");

        // 2. 이메일 중복 여부 체크
        checkTrue(mapper.exists(email) == 0, "이미 가입된 이메일입니다");

        // 3. 이메일 형식 체크 -> EmailValidator로 따로 만듦
        checkTrue(checkEmail(email), "이메일 형식이 아닙니다.");

        // 4. 비밀번호는 8자리 이상, 비밀번호 확인과 일치 여부
        checkTrue(password.length() >= 8, "비밀번호는 8자리 이상 입력하세요.");
        checkTrue(password.equals(confirmPassword), "비밀번호 확인과 일치하지 않습니다.");

        // 6. 전화번호 형식 체크 -> MobileValidator로 따로 만듦
        checkTrue(checkMobile(mobile), "전화번호 형식이 아닙니다.");
    }
}
