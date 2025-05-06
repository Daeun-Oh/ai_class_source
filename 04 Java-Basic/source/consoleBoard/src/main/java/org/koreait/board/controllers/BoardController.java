package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.services.BoardInfoService;
import org.koreait.global.paging.SearchForm;
import org.koreait.global.router.Controller;

import java.util.List;

import static org.koreait.member.MemberSession.isLogin;

public class BoardController extends Controller {
    private BoardInfoService service;

    @Override
    public void show() {
        setMenus(isLogin() ? List.of("1", "2", "3", "4", "p", "n") : null);

        StringBuffer sb = new StringBuffer(2500);
        if (isLogin()) {  // 로그인 상태일 때 메뉴

            SearchForm searchForm = new SearchForm();
            searchForm.setSkey("제목");
            List<Board> items = service.getList(searchForm);
            items.forEach(System.out::println);

            sb.append("1. 작성\n")
                    .append("2. 수정\n")
                    .append("3. 삭제\n")
                    .append("4. 조회");
        } else {    // 로그인 상태가 아닐 때
            sb.append("1. 회원가입\n")
                    .append("2. 로그인");
        }
        System.out.println(sb);
    }
}
