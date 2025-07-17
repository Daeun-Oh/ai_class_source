package org.koreait.tests;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
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

@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex05 {

    @Autowired
    private JPAQueryFactory queryFactory;

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

    /**
     * Ex 1.
     * "user"가 포함된 email과 "사용자"가 포함된 name을 가진 회원 목록 조회
     */
    @Test
    void test1() {
        QMember member = QMember.member;

        JPAQuery<Member> query = queryFactory.selectFrom(member)
                .where(member.email.contains("user"))
                .where(member.name.contains("사용자"))
                .orderBy(member.createdAt.desc());

        List<Member> members = query.fetch();
        members.forEach(System.out::println);
    }

    /**
     * Ex 2.
     * 전체 회원 수(count) 구하기
     */
    @Test
    void test2() {
        QMember member = QMember.member;
        JPAQuery<Long> query = queryFactory.select(member.count()).from(member);
        long total = query.fetchOne();
        System.out.println(total);
    }

    /**
     * Ex 3.
     * 회원들의 이메일만 추출
     */
    @Test
    void test3() {
        QMember member = QMember.member;
        JPAQuery<String> query = queryFactory.select(member.email).from(member);
        List<String> emails = query.fetch();
        System.out.println(emails);
    }

    /**
     * Ex 4.
     * 이메일과 이름을 함께 조회하고 Tuple로 받아 출력
     */
    @Test
    void test4() {
        QMember member = QMember.member;
        JPAQuery<Tuple> query = queryFactory.select(member.email, member.name).from(member);
        for (Tuple item : query.fetch()) {
            String email = item.get(member.email);
            String name = item.get(1, String.class);
            System.out.printf("email=%s, name=%s%n", email, name);
        }
    }

    /**
     * Ex 5.
     * Ex 1 + 페이징 기능
     * "user"가 포함된 email과 "사용자"가 포함된 name을 가진 회원 목록을
     * 한 페이지 당 3개씩 잘라 0번째 페이지를 조회
     *
     * offset: 시작 위치
     * limit: 한 페이지당 보여줄 목록 수
     */
    @Test
    void test5() {
        QMember member = QMember.member;

        JPAQuery<Member> query = queryFactory.selectFrom(member)
                .where(member.email.contains("user"))
                .where(member.name.contains("사용자"))
                .orderBy(member.createdAt.desc())
                .offset(0L)
                .limit(3L);

        List<Member> members = query.fetch();
        members.forEach(System.out::println);
    }
}