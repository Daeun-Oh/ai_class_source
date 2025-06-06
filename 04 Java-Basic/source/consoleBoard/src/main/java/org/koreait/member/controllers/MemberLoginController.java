package org.koreait.member.controllers;

import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.member.exceptions.CommonException;
import org.koreait.member.services.MemberLoginService;

import java.util.Scanner;

public class MemberLoginController extends Controller {

    private final MemberLoginService service;

    public MemberLoginController(MemberLoginService service) {
        this.service = service;

        setPrompt(() -> {
            RequestLogin form = new RequestLogin();
            while (true) {
                try {
                    Scanner sc = new Scanner(System.in);

                    String email = inputEach("1. 이메일", sc);
                    form.setEmail(email);

                    String password = inputEach("2. 비밀번호", sc);
                    form.setPassword(password);

                    // 로그인 처리
                    service.process(form);
                    break;
                } catch (CommonException e) {
                    printError(e);
                }
            }

            // 로그인 완료 후 -> 회원관리 메인으로 이동
            Router.change(MemberController.class);
        });
    }

    @Override
    public void show() {
        System.out.println("가입한 이메일과 비밀번호를 입력하세요(메인 메뉴 - m, 종료 - q) >> ");
    }

    @Override
    public void common() {
        System.out.println("******************** 로그인 ********************");
    }
}
