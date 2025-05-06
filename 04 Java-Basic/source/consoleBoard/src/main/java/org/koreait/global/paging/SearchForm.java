package org.koreait.global.paging;

import lombok.Data;

@Data
public class SearchForm {
    private int page;    // 몇 페이지
    private int offset;  //
    private int limit;   // 몇 개의 데이터
    private String sopt; // 검색 옵션
    private String skey; // 검색 키워드
}
