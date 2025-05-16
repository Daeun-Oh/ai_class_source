package exam01;

import org.junit.jupiter.api.Test;
import org.koreait.global.configs.AppCtx;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringJUnitConfig(AppCtx.class)
public class Ex04 {

    @Autowired
    private MemberRepository repository;

    @Test
    void test1() {
        LocalDateTime sdate = LocalDateTime.now().minusWeeks(1L); // 일주일 전
        LocalDateTime edate = LocalDateTime.now();

        // 첫 번째 페이지, 2개
        //Pageable pageable = PageRequest.of(0, 4);
        Pageable pageable = PageRequest.of(0, 4, Sort.by(desc("regdt"), asc("email")));
        Page<Member> data = repository.findByRegDtBetween(sdate, edate, pageable);

        List<Member> items = data.getContent(); // 조회된 결과 목록
        long total = data.getTotalElements();   // 조회된 결과 전체 개수 - 쿼리가 1번 더 실행(COUNT(*))
        int totalPage = data.getTotalPages();   // 전체 페이지 개수

        items.forEach(System.out::println);
        System.out.printf("전체 레코드 개수: %d, 전체 페이지 개수: %d%n", total, totalPage);
    }
}
