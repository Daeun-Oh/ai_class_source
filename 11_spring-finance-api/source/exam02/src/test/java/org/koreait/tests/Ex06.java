package org.koreait.tests;

import com.querydsl.core.BooleanBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.member.constants.Authority;
import org.koreait.member.entities.Member;
import org.koreait.member.entities.QMember;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

/**
 * MemberRepository.java
 * -> extends QuerydslPredicateExecutor<Member>
 * -> 조건문 확장됨.
 * 이를 활용하는 코드들이다.
 */
@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex06 {

    @Autowired
    private MemberRepository repository;

    /**
     * 테스트 실행 전 10명의 테스트 사용자 데이터를 DB에 저장
     */
    @BeforeEach
    void init() {
        List<Member> members = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setName("사용자" + i);
            member.setPassword("11111111");
            member.setAuthority(Authority.MEMBER);
            member.setEmail("user" + i + "@test.org");
            members.add(member);
        }
        repository.saveAllAndFlush(members);
    }


    @Test
    void test1() {
        QMember member = QMember.member;

        List<Member> members = (List<Member>)repository.findAll(member.email.contains("user"));

        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        QMember member = QMember.member;
        BooleanBuilder andBuilder = new BooleanBuilder();
        andBuilder.and(member.email.contains("user"))
                .and(member.name.contains("사용자"));

        List<Member> members = (List<Member>)repository.findAll(andBuilder, member.createdAt.desc());

        members.forEach(System.out::println);
    }

    @Test
    void test3() {
//        QMember member = QMember.member;
//        BooleanBuilder andBuilder = new BooleanBuilder();
//        Pageable pageable = PageRequest.of(0, 3, Sort.by(desc("createdAt")));
//        Page<Member> data = repository.findAll(pageable);
//        long total = data.getTotalElements();
//        List<Member> items = data.getContent();
//
//        System.out.printf("total");  // 쿼리 2번 실행!
    }
}
