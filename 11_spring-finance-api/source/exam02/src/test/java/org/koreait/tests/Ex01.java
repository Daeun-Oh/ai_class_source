package org.koreait.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.koreait.member.entities.Member;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class Ex01 {

    @PersistenceContext  // EntityManager 주입 (@Autowired 유사)
    private EntityManager em;

    @Test
    void test1() {
        Member member = new Member();
//        member.setSeq(1L);
        member.setEmail("kyh@test.org");
        member.setName("고영희");
        member.setPassword("1234");
        member.setCreatedAt(LocalDateTime.now());

        // INSERT
        em.persist(member);  // 영속 상태로 등록 (Entity 변화 감지 -> DB에 저장)

        // UPDATE
        member.setName("(수정)고영희");

        em.detach(member);   // 영속성 분리, 변화 감지 X -> 아래 update 구문 실행 안 됨

        // UPDATE
        member.setPassword("5678");

        // SELECT
        // - 분리된 엔티티의 차이점을 비교하기 위해 SELECT 쿼리가 한 번 실행됨
        em.merge(member);   // 분리된 영속성 상태 -> 다시 영속 상태로 변경

        em.flush();
    }
}
