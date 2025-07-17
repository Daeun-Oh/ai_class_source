package org.koreait.board.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;
import org.koreait.member.entities.Member;

@Data
@Entity
@Table(name = "boardData",
        indexes = @Index(name = "idx_board_data_created_at", columnList = "createdAt DESC"))
public class BoardData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)  // 다대일: 한 명의 회원이 여러 개의 게시글과 연관되어 있음. / LAZY: 처음부터 join하지 않고 필요할 때 한 번 join
    @JoinColumn(name="mSeq")
    private Member member;

    @Column(nullable = false, length = 100)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 45)
    private String poster;
}
