package member.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long seq;               // 가입 번호
    private String email;           // 이메일
    private String name;            // 이름
    private String mobile;          // 전화번호
    private boolean terms;
    private LocalDateTime regDt;    // 가입 날짜
}
