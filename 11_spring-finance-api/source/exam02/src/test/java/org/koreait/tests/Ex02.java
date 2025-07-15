package org.koreait.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.member.entities.Member;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex02 {
    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        // Data 10개
        Member member = new Member();
//        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear();  // 영속성 비우기
    }

    @Test
    void test1() {
        // find(): 기본값으로 엔티티 SELECT
        // 영속성에 member가 없으면 SELECT 수행. 있으면 SELECT 쿼리를 수행하지 않고 바로 가져올 수 있다.
        Member member = em.find(Member.class, 1L);
        System.out.println(member);

        // 바로 위의 코드에서 member를 영속성 상태로 올렸기 때문에, 여기선 SELECT 쿼리를 수행하지 않는다.
        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);

        // 두 객체는 같은 객체
        System.out.println(member == member2);
    }
}
