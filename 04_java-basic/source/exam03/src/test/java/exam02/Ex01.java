package exam02;

import global.configs.DBConnection;
import member.entities.Member;
import member.mappers.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Ex01 {

    private DBConnection conn;

    @BeforeEach
    void init() {
        conn = DBConnection.getInstance();
    }

    @Test
    void test1() {
        DBConnection conn = DBConnection.getInstance();
        SqlSession session = conn.getSession();
        System.out.println(session);
    }

    @Test
    void test2() {
        SqlSession session = conn.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        /*int total = mapper.getTotal();
        System.out.println(total);*/
        /*Member member = mapper.getMember("user01@test.org");
        System.out.println(member);*/
        /*int affectedRows = mapper.register("user06@test.org", "123456", "사용자06", "01012395739");
        System.out.println(affectedRows);*/
        /*Optional<Member> opt = mapper.getMember("user01@test.org");
        System.out.println(opt.get());*/
    }
}
