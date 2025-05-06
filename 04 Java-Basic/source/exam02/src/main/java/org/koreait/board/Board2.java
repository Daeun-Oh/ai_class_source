package org.koreait.board;

import lombok.Builder;
import lombok.ToString;

@Builder @ToString
public class Board2 {
    private long seq;       // 게시글 번호
    private String poster;  // 작성자
    private String subject; // 글 제목
    private String content; // 글 내용
}
