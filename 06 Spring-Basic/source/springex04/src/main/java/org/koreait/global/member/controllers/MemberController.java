package org.koreait.global.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.global.member.entities.Member;
import org.koreait.global.member.services.JoinService;
import org.koreait.global.member.services.LoginService;
import org.koreait.global.member.validators.JoinValidator;
import org.koreait.global.member.validators.JoinValidator2;
import org.koreait.global.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    //@Autowired // 의존성 주입 -> 말고 final + @RequiredArgsConstructor
    private final JoinValidator2 joinValidator;
    private final JoinService joinService;

    private final LoginValidator loginValidator;
    private final LoginService loginService;

    /**
     * MemberController에서 공통으로 공유할 수 있는 속성
     *
     * @return
     */
//    @ModelAttribute("commonTitle")
//    public String commonTitle() {
//        return "회원 공통 제목...";
//    }
//
//    @ModelAttribute("hobbies")
//    public List<String> hobbies() {
//        return List.of("취미1", "취미2", "취미3");
//    }

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {
        System.out.println(form);

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) {
        joinValidator.validate(form, errors);

        if (errors.hasErrors()) {   // 검증 실패했을 경우
            return "member/join";   // 다시 회원가입 페이지
        }

        // 회원가입 검증 성공, 가입 처리
        joinService.process(form);


        // 회원가입 완료 후 로그인 페이지 이동
        return "redirect:/member/login";
        //return "forward:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form,
                        @CookieValue(name="savedEmail", required = false) String email) {
        if (email != null) {
            form.setEmail(email);
            form.setSaveEmail(true);
        }
        return "member/login";  // 일단 간단하게 템플릿만 연동
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "member/login";
        }

        // 검증 성공 시 로그인 처리
        loginService.process(form);

        // 로그인 성공 시 이동
        String redirectUrl = form.getRedirectUrl();

        return "redirect:" + (StringUtils.hasText(redirectUrl) ? redirectUrl : "/"); // 주소 이동 (이전 페이지로)
    }

    @RequestMapping("/logout")  // 요청메서드 상관없이 이 주소가 요청되면
    public String logout(HttpSession session) {
        session.invalidate();   // 세션 비우기

        return "redirect:/member/login";
    }

    @ResponseBody
    @GetMapping("/info")
    public void memberInfo(@SessionAttribute() Member member) {
        System.out.println(member);
    }

    // MemberController 공통 적용 Validator
//    @InitBinder
//    public void InitBinder(WebDataBinder binder) {
//        binder.setValidator(joinValidator);
//    }
}
