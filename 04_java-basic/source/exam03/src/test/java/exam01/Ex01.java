package exam01;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    @Test
    void test1() throws SQLException {
        String url = "jdbc:mysql://localhost:3456/";
        Connection connection = DriverManager.getConnection(url, "codefactory", "3535");
        System.out.println(connection);
    }

    @Test
    void test2() throws SQLException {
        DataSource ds = new DataSource();
        /* 연결 설정 S */
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3456/";
        ds.setUrl(url);
        ds.setUsername("codefactory");
        ds.setPassword("3535");
        /* 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setInitialSize(2);   // 최초로 생성될 연결 객체 수, 기본값은 10개
        ds.setMaxActive(10);    // 최대 활성 연결 개수, 기본값은 100개
        ds.setTestWhileIdle(true);  // 유휴 객체의 연결 상태를 주기적으로 체크
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10);  // 10초마다 유휴 커넥션 검사 실행, 기본값은 5초
        ds.setMinEvictableIdleTimeMillis(1000 * 30);    // 유휴 객체 최대 생존 시간을 30초로 설정, 기본값은 60초
        /* 커넥션 풀 설정 E */

        Connection con = ds.getConnection();
        System.out.println(con);
    }
}
