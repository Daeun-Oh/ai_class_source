package org.koreait.board;

import org.junit.jupiter.api.Test;

public class Ex01 {
    @Test
    void test1() {  // Board 클래스
        Board item = Board.builder()
                .seq(1L)
                .poster("작성자1")
                .subject("제목1")
                .content("내용1")
                .build();
        System.out.println(item);
    }

    @Test
    void test2() {  // Board2 클래스
        Board2 item = Board2.builder()
                .seq(1L)
                .poster("작성자1")
                .subject("제목1")
                .content("내용1")
                .build();
        System.out.println(item);
    }
}
