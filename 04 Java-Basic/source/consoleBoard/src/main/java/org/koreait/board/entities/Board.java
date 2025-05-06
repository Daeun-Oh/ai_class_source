package org.koreait.board.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private long id;                    // 번호
    private String title;               // 제목
    private String content;             // 내용
    private long writerId;             // 작성자 id
    private LocalDateTime createdAt;   // 작성일시
    private LocalDateTime modifiedAt;  // 수정일시
}
