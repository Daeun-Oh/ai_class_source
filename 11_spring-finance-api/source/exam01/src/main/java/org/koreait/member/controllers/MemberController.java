package org.koreait.member.controllers;

import org.koreait.member.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping
    @ResponseBody
    public Member info() {
        return Member.builder()
                .seq(1L)
                .email("koyoung@test.org")
                .password("1234")
                .name("고영희")
                .build();
    }
}
