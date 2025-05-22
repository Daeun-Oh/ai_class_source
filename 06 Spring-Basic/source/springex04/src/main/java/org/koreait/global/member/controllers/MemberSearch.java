package org.koreait.global.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch {
    @DateTimeFormat(pattern = "yyyy/MM/dd") // 형식 지정
    private LocalDate sDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd") // 형식 지정
    private LocalDate eDate;
}
