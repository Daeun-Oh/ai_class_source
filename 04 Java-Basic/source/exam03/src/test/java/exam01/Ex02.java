package exam01;

import member.entities.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ex02 {

    private DataSource ds;

    @BeforeEach     // 각 테스트 코드마다 처음에 실행되는 코드
    void init() {   // 데이터 연결 초기화(설정) 코드
        DataSource ds = new DataSource();
        /* 연결 설정 S */
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3456/codefactory";
        ds.setUrl(url);
        ds.setUsername("codefactory");
        ds.setPassword("3535");
        /* 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setInitialSize(2);   // 최초로 생성될 연결 객체 수, 기본값은 10개
        ds.setMaxActive(10);    // 최대 활성 연결 개수, 기본값은 100개
        ds.setMaxIdle(10);  // maxActive와 같게 설정
        ds.setTestWhileIdle(true);  // 유휴 객체의 연결 상태를 주기적으로 체크
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10);  // 10초마다 유휴 커넥션 검사 실행, 기본값은 5초
        ds.setMinEvictableIdleTimeMillis(1000 * 30);    // 유휴 객체 최대 생존 시간을 30초로 설정, 기본값은 60초
        /* 커넥션 풀 설정 E */

        this.ds = ds;
    }

    @Test
    void test() {
        String sql = "SELECT * FROM member WHERE seq = ?";
        try (Connection con = ds.getConnection();       // 자원 해제
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<Member> members = new ArrayList<>();
            while(rs.next()) {  // 커서 이동
                long seq = rs.getLong("seq");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                boolean terms = rs.getBoolean("terms");
                LocalDateTime regDt = rs.getTimestamp("regDt").toLocalDateTime();
                members.add(new Member(seq, email, name, mobile, terms, regDt));    // VO(Value Object) 또는 데이터 클래스
                //System.out.printf("seq=%d, email=%s, name=%s, mobile=%s, terms=%s%n", seq, email, name, mobile, terms);
            }
            members.forEach(System.out::println);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test1() {
        try (Connection con = ds.getConnection();       // 자원 해제
             Statement stmt = con.createStatement()) {
            String sql = "INSERT INTO member (email, password, name, mobile, terms)"
                        + "VALUES ('user01@test.org', '12345678', '사용자01', '01012345678', 1)";
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(affectedRows);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        String sql = "SELECT * FROM member";
        try (Connection con = ds.getConnection();       // 자원 해제
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<Member> members = new ArrayList<>();
            while(rs.next()) {  // 커서 이동
                long seq = rs.getLong("seq");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                boolean terms = rs.getBoolean("terms");
                LocalDateTime regDt = rs.getTimestamp("regDt").toLocalDateTime();
                members.add(new Member(seq, email, name, mobile, terms, regDt));    // VO(Value Object) 또는 데이터 클래스
                //System.out.printf("seq=%d, email=%s, name=%s, mobile=%s, terms=%s%n", seq, email, name, mobile, terms);
            }
            members.forEach(System.out::println);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test3() {
        String sql = "INSERT INTO member (email, password, name, mobile, terms)"
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ds.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"seq"})) {
            pstmt.setString(1, "user04@test.org");
            pstmt.setString(2, "12345678");
            pstmt.setString(3, "사용자04");
            pstmt.setString(4, "01011112222");
            pstmt.setBoolean(5, true);

            int affectedRow = pstmt.executeUpdate();
            System.out.println(affectedRow);

            ResultSet rs = pstmt.getGeneratedKeys();    // 자동 증감 번호(seq) 값을 조회하기 위한 ResultSet 객체
            rs.next();
            long seq = rs.getLong(1);
            System.out.printf("회원번호(seq): %d%n", seq);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test4() {
        String sql = "SELECT * FROM member WHERE email LIKE ?";
        try (Connection con = ds.getConnection();       // 자원 해제
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "user%");
            ResultSet rs = pstmt.executeQuery();


            List<Member> members = new ArrayList<>();
            while(rs.next()) {  // 커서 이동
                long seq = rs.getLong("seq");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                boolean terms = rs.getBoolean("terms");
                LocalDateTime regDt = rs.getTimestamp("regDt").toLocalDateTime();
                members.add(new Member(seq, email, name, mobile, terms, regDt));    // VO(Value Object) 또는 데이터 클래스
                //System.out.printf("seq=%d, email=%s, name=%s, mobile=%s, terms=%s%n", seq, email, name, mobile, terms);
            }
            members.forEach(System.out::println);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test05() throws SQLException {
        String sql = "INSERT INTO member (email, password, name, mobile, terms)"
                + "VALUES (?, ?, ?, ?, ?)";
        Connection con = ds.getConnection();
        try {
            /* 트랜잭션 S */
            con.setAutoCommit(false);   // commit()을 해야만 DB에 영구 반영

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "user06@test.org");
            pstmt.setString(2, "12345678");
            pstmt.setString(3, "사용자05");
            pstmt.setString(4, "01011115555");
            pstmt.setBoolean(5, true);
            pstmt.executeUpdate();

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "user07@test.org");
            pstmt.setString(2, "12345678");
            pstmt.setString(3, "사용자05");
            pstmt.setString(4, "01011115555");
            pstmt.setBoolean(5, true);
            pstmt.executeUpdate();

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "user05@test.org");
            pstmt.setString(2, "12345678");
            pstmt.setString(3, "사용자05");
            pstmt.setString(4, "01011115555");
            pstmt.setBoolean(5, true);
            pstmt.executeUpdate();

            con.commit();
            /* 트랜잭션 E */
            // --> "user05@test.org" 삽입에서 오류가 나면, 같은 트랜잭션 내에 있는 모든 데이터도 올라가지 않는다.
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
            System.out.println("SQL 실행 시 에러 발생으로 롤백");
        }
    }
}
