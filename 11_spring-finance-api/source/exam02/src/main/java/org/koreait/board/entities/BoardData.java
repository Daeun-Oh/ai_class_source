package org.koreait.board.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;

@Data
@Entity
@Table(name = "boardData",
        indexes = @Index(name = "idx_board_data_created_at", columnList = "createdAt DESC"))
public class BoardData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false, length = 100)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 45)
    private String poster;
}
