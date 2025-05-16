package org.koreait.global.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String joinPage() { // 템플릿 경로 반환

        return "member/join";   // 템플릿 경로
    }
    @PostMapping("/member/join")
    public String joinPs(RequestJoin2 form) {
        System.out.println(form);
        return "member/join_ps";
    }
/*
    @PostMapping("/member/join")
    public String joinPs(
            @RequestParam(name = "email", defaultValue = "기본 이메일...") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "confirmPassword") String confirmPassword,
            @RequestParam(name="agree", required=false) boolean agree) {   // boolean -> Boolean : 기본형은 null이 없다.
        System.out.println("POST 요청 유입...");
        System.out.printf("email=%s, agree=%s%n", email, agree);

        return "member/join_ps";
    }
*/

    /*
    @GetMapping("/member/register")
    public String joinPage(@RequestParam("agree") boolean agree, @RequestParam("email") String email, Model model) {
        System.out.printf("email: %s%n", email);
        model.addAttribute("message", "안녕하세요!");
        return "member/join";   // /WEB-INF/templates/member/join.jsp
    }
    */

    /*
    @GetMapping("/member/register")
    public ModelAndView joinPage() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "안녕하세요!");
        mv.setViewName("member/join");
        return mv;
    }
    */
}
