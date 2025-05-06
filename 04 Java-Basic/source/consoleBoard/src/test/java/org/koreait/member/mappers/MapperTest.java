package org.koreait.member.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.global.configs.DBConnection;
import org.koreait.member.entities.Member;

public class MapperTest {
    private MemberMapper mapper;

    @BeforeEach
    void init() {
        mapper = DBConnection.getInstance().getSession().getMapper(MemberMapper.class);
    }

    /**
     * 추가 테스트
     */
    @Test
    void test1() {
        Member member = new Member();
        member.setEmail("user02@test.org");
        member.setPassword("1111");
        member.setName("사용자2");
        member.setTerms(true);
        member.setMobile("01034561234");

        int affectedRows = mapper.register(member);
        System.out.println(affectedRows);
    }

    /**
     * 조회 테스트
     */
    @Test
    void test2() {
        Member member = mapper.get("user01@test.org").orElse(null);
        System.out.println(member);

        //List<Member> members = mapper.getList();
        //members.forEach(System.out::println);
    }

    /**
     * 수정 테스트
     */
    @Test
    void test3() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("(수정)사용자01");
        mapper.update(member);

        //List<Member> members = mapper.getList();
        //members.forEach(System.out::println);
    }
}
