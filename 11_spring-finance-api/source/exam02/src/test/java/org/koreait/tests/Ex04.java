package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.member.constants.Authority;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex04 {

    @Autowired
    private MemberRepository repository;

    @BeforeEach
    void init() {
        List<Member> members = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setName("사용자" + i);
            member.setEmail("user" + i + "@test.org");
            member.setPassword("1234");
            member.setAuthority(Authority.MEMBER);
            members.add(member);
//            repository.save(member);  // em.persist(...)
        }
//        repository.saveAll(members);  // em.persist(...)
//        repository.flush();
        repository.saveAllAndFlush(members);
    }

    @Test
    void test1() {
        List<Member> members = repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        Member member = repository.findById(1L).orElse(null);
        System.out.println(member);
    }

    @Test
    void test3() {
//        Member member = repository.findByEmail("user1@test.org");
        Member member = repository.findByEmail("user1@test.org").orElseThrow(RuntimeException::new);
        System.out.println(member);
    }

    @Test
    void test4() {
        List<Member> members = repository.findByEmailContainingOrNameContaining("user", "사용자");
        members.forEach(System.out::println);
    }

    @Test
    void test5() {
        List<Member> members = repository.findByEmailContainingOrNameContainingOrderByCreatedAtDesc("user", "사용자");
        members.forEach(System.out::println);
    }

    @Test
    void test6() {
        List<Member> members = repository.getContents("user", "사용자");
        members.forEach(System.out::println);
    }
}
