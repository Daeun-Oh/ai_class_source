package org.koreait.member;

import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class Member {
    private final String email;

    @ToString.Exclude   // password는 toString 항목에서 배제
    private String password;

    @NonNull
    private final String name;
}
