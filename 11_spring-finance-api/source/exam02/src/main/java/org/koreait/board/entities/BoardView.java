package org.koreait.board.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

/**
 * 다중 기본키 방법 (1)
 * - Embeddable 사용
 */
@Data
@Entity
public class BoardView {
    @EmbeddedId
    private BoardViewId viewId;
}
