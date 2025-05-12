package org.koreait.member.entities;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;
import org.koreait.global.configs.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    //private DataSource ds;


    void init() {   // 데이터 연결 초기화(설정) 코드
        DataSource ds = new DataSource();
        /* 연결 설정 S */
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3456/CONSOLE_BOARD";
        ds.setUrl(url);
        ds.setUsername("CONSOLE_BOARD");
        ds.setPassword("1234");
        /* 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setInitialSize(2);   // 최초로 생성될 연결 객체 수, 기본값은 10개
        ds.setMaxActive(10);    // 최대 활성 연결 개수, 기본값은 100개
        ds.setMaxIdle(10);  // maxActive와 같게 설정
        ds.setTestWhileIdle(true);  // 유휴 객체의 연결 상태를 주기적으로 체크
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10);  // 10초마다 유휴 커넥션 검사 실행, 기본값은 5초
        ds.setMinEvictableIdleTimeMillis(1000 * 30);    // 유휴 객체 최대 생존 시간을 30초로 설정, 기본값은 60초
        /* 커넥션 풀 설정 E */

        //this.ds = ds;
    }

    @Test
    void test() {
        String sql = "SELECT * FROM MEMBER WHERE seq = ?";
        try (Connection con = DBConnection.getInstance().getSession().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, 9);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Member member = new Member();
                    member.setSeq(rs.getInt("seq"));
                    member.setEmail(rs.getString("email"));
                    member.setPassword(rs.getString("password"));
                    member.setName(rs.getString("name"));
                    member.setMobile(rs.getString("mobile"));
                    member.setTerms(rs.getBoolean("terms"));
                    member.setAdmin(rs.getBoolean("isAdmin"));
                    String dateStr = rs.getString("regDt");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    member.setRegDt(LocalDateTime.parse(dateStr, formatter));
                    System.out.println(member);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
