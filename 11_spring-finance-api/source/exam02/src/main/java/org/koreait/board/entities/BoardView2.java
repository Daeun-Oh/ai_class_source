package org.koreait.board.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

/**
 * 다중 기본키 방법 (2)
 * - IdClass로 불러오기 (HashCode 비교 필수?)
 */
@Data
@Entity
@IdClass(BoardViewId2.class)
public class BoardView2 {
    @Id
    private Long seq;
    @Id
    private int uid;
}
