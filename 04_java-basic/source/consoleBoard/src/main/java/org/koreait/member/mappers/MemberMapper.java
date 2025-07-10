package org.koreait.member.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.koreait.global.paging.SearchForm;
import org.koreait.member.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberMapper {
    int register(Member member);
    int update(Member member);
    int delete(String email);

    Optional<Member> get(String email);
    List<Member> getList(SearchForm search);

    List<Member> getMembersIn(@Param("seqList") int[] seqList);

    /**
     * 입력 받은 email이 MEMBER 테이블에 몇 개 있는지 반환하는 메서드
     * - Join 검증 때 사용된다.
     * - 간단한 쿼리라 여기에 작성 (복잡한 쿼리는 xml에 작성하도록 한다)
     * @param email
     * @return
     */
    @Select("SELECT COUNT(*) FROM MEMBER WHERE email=#{email}")
    int exists(@Param("email") String email);
}
