package org.koreait.member.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("MEMBER")
public class Member {
    @Id
    private Long seq;   // 지네릭을 사용해야 해서 Wrapper 클래스 사용
    private String email;
    private String password;
    private String name;
    private String mobile;
    @Column("regDt")
    private LocalDateTime regDt; // reg_dt라고 인식됨 -> @Column으로 알려주면 됨
    @Column("modDt")
    private LocalDateTime modDt;
}
