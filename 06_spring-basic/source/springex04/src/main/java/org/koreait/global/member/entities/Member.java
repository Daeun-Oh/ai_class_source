package org.koreait.global.member.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("MEMBER")
public class Member {
    @Id
    private Long seq;
    private String email;
    private String password;
    private String name;
    private String mobile;

    @Column("regDt") // reg_dt로 인식되는 것 방지
    private LocalDateTime regDt;

    @Column("modDt") // mod_dt로 인식되는 것 방지
    private LocalDateTime modDt;
}
