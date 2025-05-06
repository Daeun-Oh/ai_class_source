package board.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardData {
    private long seq;               // 게시글 등록 번호
    private String poster;          // 작성자
    private  String subject;        // 제목
    private String content;         // 내용
    private LocalDateTime regDt;    // 작성일시
    private LocalDateTime modDt;    // 수정일시
}
