package org.koreait.member.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Member {
//    @JsonAlias("number")  -> 이건 요청 받을 때
    private Long seq;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    @JsonFormat(pattern = "yy.MM.dd HH:mm:SS")
    private LocalDateTime createdAt;
}
