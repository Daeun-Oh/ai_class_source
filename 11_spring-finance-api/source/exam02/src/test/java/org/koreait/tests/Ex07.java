package org.koreait.tests;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.board.entities.BoardData;
import org.koreait.board.entities.QBoardData;
import org.koreait.board.repositories.BoardDataRepository;
import org.koreait.member.constants.Authority;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles({"default", "test"})
public class Ex07 {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setName("사용자01");
        member.setAuthority(Authority.MEMBER);

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            BoardData item = new BoardData();
            item.setMember(member);
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setPoster("작성자" + i);
            items.add(item);
        }

        boardRepository.saveAllAndFlush(items);

        em.clear();  // 영속성을 비워야 캐시된 쪽에서 가져 오는 게 아니라 직접 SQL 실행
    }

    @Test
    void test1() {
        BoardData item = boardRepository.findById(1L).orElse(null);

        Member member = item.getMember();
        String email = member.getEmail();
        System.out.println(email);
//        System.out.println(member);
    }

    @Test
    void test2() {
        Member member = memberRepository.findById(1L).orElse(null);
        List<BoardData> items = member.getItems();
        items.forEach(System.out::println);
    }

    /**
     * 지연 로딩의 "N+1 문제":
     * JPA에서 연관된 엔티티를 조회할 때, 1번의 쿼리로 N개의 부모 엔티티를 가져온 후
     * 각 부모 엔티티마다 연관된 자식 엔티티를 추가로 1번씩 조회하여
     * 총 N+1개의 쿼리가 실행되는 문제
     * -> 성능 저하 (게시글이 1000건이면 1001번 쿼리가 날아감)
     */
    @Test
    void test3() {
        List<BoardData> items = boardRepository.findAll(); // 1번 쿼리 (BoardData 전체 조회)
        for (BoardData item : items) {
            Member member = item.getMember();              // N번 쿼리 (각 게시글의 작성자 Member 조회)
            String email = member.getEmail();
            String name = member.getName();
            System.out.printf("email=%s, name=%s%n", email, name);
        }
    }

    @Test
    void test4() {
        List<BoardData> items = boardRepository.getList();

        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail();
            String name = member.getName();
            System.out.printf("email=%s, name=%s%n", email, name);
        }
    }

    /**
     *
     */
    @Test
    void test6() {
        QBoardData boardData = QBoardData.boardData;
        List<BoardData> items = queryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin()
                .fetch();

        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail();
            String name = member.getName();
            System.out.printf("email=%s, name=%s%n", email, name);
        }
    }

    /**
     * cascade = CascadeType.REMOVE
     */
    @Test
    void test8() {
        Member member = memberRepository.findById(1L).orElse(null);
        memberRepository.delete(member);
        memberRepository.flush();
    }

    /**
     * Orphan Removal (고아 객체 제거)
     * orphanRemoval = true
     * 전제 조건: cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
     */
    @Test
    void test9() {
        Member member = memberRepository.findById(1L).orElse(null);
        List<BoardData> items = boardRepository.getList();

    }
}
