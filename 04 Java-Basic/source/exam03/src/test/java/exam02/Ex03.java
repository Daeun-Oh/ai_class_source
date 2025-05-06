package exam02;

import global.configs.DBConnection;
import member.entities.Member;
import member.mappers.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Ex03 {
    private MemberMapper mapper;

    @BeforeEach
    void init() {
        DBConnection conn = DBConnection.getInstance();
        SqlSession session = conn.getSession();
        mapper = session.getMapper(MemberMapper.class);
    }

    @Test
    void test1() {
        int total = mapper.getTotal();
        System.out.println(total);

        Optional<Member> opt = mapper.get("user01@test.org");
        System.out.println(opt.get());

        List<Member> items = mapper.getList();
        items.forEach(System.out::println);
    }
}
