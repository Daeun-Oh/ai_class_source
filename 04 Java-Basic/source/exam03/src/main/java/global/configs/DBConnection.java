package global.configs;

import board.mappers.BoardMapper;
import member.mappers.MemberMapper;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;

public class DBConnection {
    private final SqlSessionFactory sqlSessionFactory;
    private static DBConnection instance;   // DB는 한 번만 만들어지면 되므로, 싱글톤 패턴

    private DBConnection() {
        this.sqlSessionFactory = sqlSessionFactory();
    }

    public DataSource dataSource() {
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

        return ds;
    }

    public SqlSessionFactory sqlSessionFactory() {
        /**
         * https://mybatis.org/mybatis-3/ko/getting-started.html
         * - 'XML을 사용하지 않고 SqlSessionFactory 빌드하기'에서 코드 복사
         */
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource());
        Configuration configuration = new Configuration(environment);

        configuration.setLogImpl(Slf4jImpl.class);      // Logger 연동

        configuration.addMapper(MemberMapper.class);    // Mapper 등록
        configuration.addMapper(BoardMapper.class);    // 게시판 Mapper 등록
        
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    public SqlSession getSession(boolean autoCommit) {
        // autoCommit: 기본값이 false
        return sqlSessionFactory.openSession(autoCommit); // openSession(): session.commit()을 해야만 DB에 영구 반영
    }

    public SqlSession getSession() {
        return getSession(true);    // 자동으로 commit() 실행
    }

    public static DBConnection getInstance() {  // 싱글톤 패턴
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}
