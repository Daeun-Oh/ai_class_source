package exam01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.global.configs.AppCtx;
import org.koreait.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class Ex02 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("회원 정보 추가")
    void test1() {
        String sql = "INSERT INTO MEMBER (email, password, name, mobile) " +
                        "VALUES(?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, "user98@test.org", "1234", "사용자03", "01012341234");
        System.out.println(affectedRows);
    }

    @Test
    @DisplayName("회원 목록 조회")
    void test2() {
        String sql = "SELECT * FROM MEMBER WHERE email LIKE ?";
        // this::mapper == (rs, i) -> mapper(rs, i)
        List<Member> items = jdbcTemplate.query(sql, this::mapper, "%user%");

        items.forEach(System.out::println);
    }

    @Test
    @DisplayName("회원 1명 조회")
    void test3() {
        String sql = "SELECT * FROM MEMBER WHERE email = ?";
        // this::mapper == (rs, i) -> mapper(rs, i)
        Member item = jdbcTemplate.queryForObject(sql, this::mapper, "user91@test.org");

        System.out.println(item);
    }

    @Test
    @DisplayName("회원 1명 이름 조회")
    void test4() {
        String sql = "SELECT name FROM MEMBER WHERE email = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, "user01@test.org");
        System.out.println(name);
    }

    @Test
    @DisplayName("총 회원 수")
    void test5() {
        long total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", long.class);
        System.out.println(total);
    }

    @Test
    @DisplayName("회원이 추가되면 회원번호(증감번호)를 가져오는 방법")
    void test6() {
        String sql = "INSERT INTO MEMBER (email, password, name, mobile) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affectedRows = jdbcTemplate.update(c -> {
            PreparedStatement pstmt = c.prepareStatement(sql, new String[] {"seq"});
            pstmt.setString(1, "user99@test.org");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "User99");
            pstmt.setString(4, "01034345656");

            return pstmt;
        }, keyHolder);

        Number key = keyHolder.getKey();
        long seq = key.longValue();
        System.out.printf("회원번호(seq): %d%n", seq);
    }

    /**
     * 어차피 매핑하는 코드는 같으므로, 따로 함수로 빼는 것이 좋다. -> 리팩토링
     * 미루지 말고 바로바로!
     *
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    private Member mapper(ResultSet rs, int i) throws SQLException {
        Member member = new Member();
        member.setSeq(rs.getLong("seq"));;
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("password"));
        member.setName(rs.getString("name"));
        member.setMobile(rs.getString("mobile"));
        member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());

        return member;
    }
}
