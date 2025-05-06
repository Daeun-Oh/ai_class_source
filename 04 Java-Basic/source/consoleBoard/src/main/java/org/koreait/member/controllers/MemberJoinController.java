package org.koreait.member.controllers;

import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.member.exceptions.CommonException;
import org.koreait.member.services.MemberJoinService;

import java.util.Scanner;

public class MemberJoinController extends Controller {

    private final MemberJoinService service;

    public MemberJoinController(MemberJoinService service) {
        this.service = service;

        setPrompt(() -> {
            RequestJoin form = new RequestJoin();
            while (true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    String email = inputEach("1. 이메일", sc);
                    form.setEmail(email);

                    String password = inputEach("2. 비밀번호", sc);
                    form.setPassword(password);

                    String confirmpassword = inputEach("3. 비밀번호 확인", sc);
                    form.setConfirmPassword(confirmpassword);

                    String name = inputEach("4. 이름", sc);
                    form.setName(name);

                    String mobile = inputEach("5. 전화번호", sc);
                    form.setMobile(mobile);

                    String agree = inputEach("6. 회원가입에 동의하십니까? (1, 0)", sc);
                    form.setTerms(agree.equals("1"));

                    service.process(form);
                    break;

                } catch (CommonException e) {
                    printError(e);
                }
            }

            // while문 빠져나옴 -> 회원가입 성공 -> 로그인 화면으로 이동
            Router.change(MemberLoginController.class);
        });
    }

    @Override
    public void show() {
        System.out.println("회원 정보를 입력하세요(메인 메뉴 - m, 종료 - q) >> ");
    }

    @Override
    public void common() {
        System.out.println("******************** 회원가입 ********************");
    }
}
