package org.koreait.board.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  // @Data 있으면 굳이 안 넣어도 됨. 필요하다는 걸 알리기 위해 작성함.
public class BoardViewId2 {
    private Long seq;
    private int uid;
}
