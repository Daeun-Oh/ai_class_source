package exam02;

import global.configs.DBConnection;
import member.entities.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex02 {
    private DBConnection conn;

    @BeforeEach
    void init() {
        conn = DBConnection.getInstance();
    }

    @Test
    void test1() {
        /**
         * SqlSession
         * - List<T> selectList(...)
         * - T selectOne(...)
         */
        SqlSession session = conn.getSession();
        int total = session.selectOne("member.mappers.MemberMapper.getTotal");
        System.out.println(total);
    }

    @Test
    void test2() {
        // 치환되는 조건이 많은 경우는 데이터 클래스로 객체를 생성해서 값을 설정
        Member params = new Member();
        params.setEmail("user01@test.org");

        SqlSession session = conn.getSession();
        Member member = session.selectOne("member.mappers.MemberMapper.get", params);
        System.out.println(member);

        List<Member> items = session.selectList("member.mappers.MemberMapper.getList");
        items.forEach(System.out::println);
    }
}
