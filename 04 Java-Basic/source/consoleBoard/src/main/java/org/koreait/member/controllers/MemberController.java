package org.koreait.member.controllers;

import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.member.MemberSession;

import java.util.List;

import static org.koreait.member.MemberSession.isLogin;

public class MemberController extends Controller {

    @Override
    public void show() {
        setMenus(isLogin() ? List.of("1", "2", "3") : List.of("1", "2"));

        StringBuffer sb = new StringBuffer(2500);
        if (isLogin()) {  // 로그인 상태일 때 메뉴
            sb.append("1. 회원정보\n")
                    .append("2.회원정보 수정\n")
                    .append("3. 로그아웃");
        } else {    // 로그인 상태가 아닐 때
            sb.append("1. 회원가입\n")
                    .append("2. 로그인");
        }
        System.out.println(sb);
    }

    @Override
    public void process(String command) {
        int menu = Integer.parseInt(command);
        switch (menu) {
            case 1:
                // 로그인 상태 O -> 회원정보 조회
                if (isLogin()) Router.change(MemberInfoController.class);
                // 로그인 상태 X -> 회원가입
                else Router.change(MemberJoinController.class);
                break;
            case 2:
                // 로그인 상태 O -> 회원정보 수정
                if (isLogin()) Router.change(MemberUpdateController.class);
                // 로그인 상태 X -> 로그인
                else Router.change(MemberLoginController.class);
                break;
            case 3:
                // 로그인 상태 O -> 로그아웃 처리 후 로그인 화면으로 이동
                // (로그인 상태가 아닐 때의 3번 선택지는 없다)
                MemberSession.logout();
                Router.change(MemberLoginController.class);
                break;
        }
    }
}
