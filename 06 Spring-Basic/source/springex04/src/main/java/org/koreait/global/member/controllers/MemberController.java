package org.koreait.global.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.global.member.services.JoinService;
import org.koreait.global.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    //@Autowired // 의존성 주입 -> 말고 final + @RequiredArgsConstructor
    private final JoinValidator joinValidator;
    private final JoinService joinService;

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
    public String Join(@ModelAttribute RequestJoin form) {
        System.out.println(form);

        return "member/join";
    }

    @PostMapping("/join")
    public String JoinPs(@Valid RequestJoin form, Errors errors) {
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
    public String login() {

        return "member/login";  // 일단 간단하게 템플릿만 연동
    }

    @PostMapping("/login")
    public String loginPs() {

        return "member/login";  // 일단 간단하게 템플릿만 연동
    }

    // MemberController 공통 적용 Validator
//    @InitBinder
//    public void InitBinder(WebDataBinder binder) {
//        binder.setValidator(joinValidator);
//    }
}
