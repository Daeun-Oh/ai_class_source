package exam01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.global.configs.AppCtx;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class Ex03 {

    @Autowired
    private MemberRepository repository;

    @Test
    @DisplayName("새로운 엔티티를 추가")
    void test1() {
        Member member = new Member();
        member.setEmail("user97@test.org");
        member.setPassword("12345678");
        member.setName("사용자97");
        member.setMobile("01022223333");
        member.setRegDt(LocalDateTime.now());

        repository.save(member);

        System.out.println(member);
    }

    @Test
    @DisplayName("회원을 1명 조회하고 수정")
    void test2() {
        Member member = repository.findById(6L).orElse(null);
        System.out.println(member);

        member.setName("(수정)사용자97");

        repository.save(member);
    }

    @Test
    @DisplayName("회원 목록 조회")
    void test3() {
        List<Member> items = repository.findAll();
        items.forEach(System.out::println);
    }

    @Test
    void test4() {
        // 값을 못 찾을 경우를 대비해서 Optional
        Member member = repository.findByEmail("user01@test.org").orElse(null);
        System.out.println(member);
    }

    @Test
    void test5() {
        LocalDateTime sDate = LocalDate.now().atStartOfDay(); // 오늘 날짜의 0시 0분 0초
        LocalDateTime eDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));

        List<Member> items = repository.findByRegDtBetweenOrderByRegDtDesc(sDate, eDate);
        items.forEach(System.out::println);
    }

    @Test
    void test6() {
        LocalDateTime sDate = LocalDate.now().atStartOfDay(); // 오늘 날짜의 0시 0분 0초
        LocalDateTime eDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));

        List<Member> items = repository.findByRegDtBetweenAndNameContainingOrderByRegDtDesc(sDate, eDate, "사용자");
        items.forEach(System.out::println);
    }

    @Test
    void test7() {
        LocalDateTime sDate = LocalDate.now().atStartOfDay(); // 오늘 날짜의 0시 0분 0초
        LocalDateTime eDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));

        List<Member> items = repository.getMembers(sDate, eDate, "%사용자%");
        items.forEach(System.out::println);
    }
}
