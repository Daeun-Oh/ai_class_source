package org.koreait.member.services;

import org.koreait.global.paging.SearchForm;
import org.koreait.member.entities.Member;
import org.koreait.member.exceptions.MemberNotFoundException;
import org.koreait.member.mappers.MemberMapper;

import java.util.List;

public class MemberInfoService {
    private final MemberMapper mapper;

    public MemberInfoService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 이메일로 회원 1명을 조회
     *
     * @param email
     * @return
     */
    public Member get(String email) {
        return mapper.get(email).orElseThrow(MemberNotFoundException::new);
    }

    /**
     * 검색 기능이 있는 회원 조회
     * - 회원이 많을 수 있으므로 페이지를 나눔 (paging)
     *
     *
     * @param search : 검색 폼 데이터
     * @return
     */
    public List<Member> getList(SearchForm search) {
        int page = Math.max(search.getPage(), 1);   // 요청한 페이지가 1보다 작으면 1로 보정
        int limit = search.getLimit();              // limit: 한 페이지에 보여줄 데이터 수
        limit = limit < 1 ? 10 : limit;             // limit가 1보다 작으면 10으로 설정
        int offset = (page - 1) * limit;            // DB에서 데이터를 가져올 때 건너뛸 데이터 수 설정 (페이징 처리 때문에)

        search.setPage(page);
        search.setLimit(limit);
        search.setOffset(offset);

        return mapper.getList(search);
    }
}
