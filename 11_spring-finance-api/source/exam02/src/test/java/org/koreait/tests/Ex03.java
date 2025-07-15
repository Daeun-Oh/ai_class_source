package org.koreait.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.koreait.member.entities.Member;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@SpringBootTest
public class Ex03 {
    @PersistenceContext
    private EntityManager em;

    @Test
    void test1() throws Exception {
        Member member = new Member();
        member.setEmail("koyounghee@test.org");
        member.setPassword("1234");
        member.setName("고영희");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear();

        member = em.find(Member.class, 1L);
        System.out.printf("추가: createdAt: %s, modifiedAt: %s%n", member.getCreatedAt(), member.getModifiedAt());

        Thread.sleep(5000);

        member.setName("(수정)고영희희");
        em.flush();
        em.clear();

        member = em.find(Member.class, 1L);
        System.out.printf("수정: createdAt: %s, modifiedAt: %s%n", member.getCreatedAt(), member.getModifiedAt());
    }
}
