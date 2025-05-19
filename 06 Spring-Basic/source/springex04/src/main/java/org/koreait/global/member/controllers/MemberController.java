package org.koreait.global.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String Join(@ModelAttribute RequestJoin form) {
        System.out.println(form);

        return "member/join";
    }

    @GetMapping("/join")
    public String JoinPs(RequestJoin form) {

        return "member/join";
    }
}
