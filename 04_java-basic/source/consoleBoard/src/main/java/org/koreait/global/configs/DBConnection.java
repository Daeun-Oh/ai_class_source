package org.koreait.global.configs;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.member.mappers.MemberMapper;

/**
 * DBConnetion: 데이터베이스 연결
 * 한 번만 만들어도 되기 때문에, 싱글톤 패턴으로 만들었다.
 */
public class DBConnection {

    private static DBConnection instance;

    private final SqlSessionFactory sqlSessionFactory;

    public DBConnection() {
        sqlSessionFactory = sqlSessionFactory();
    }

    public DataSource dataSource() {

        /* 환경 변수 가져오기 */
        String database = System.getenv("db");
        String username = System.getenv("username");
        String password = System.getenv("password");

        DataSource ds = new DataSource();

        /* 연결 설정 */
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://" + database);
        ds.setUsername(username);
        ds.setPassword(password);

        /* 커넥션 풀 설정 */
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMaxIdle(10);  // 이것도 똑같이 맞춰줘야 경고가 안 뜸
        ds.setTestWhileIdle(true);

        return ds;
    }

    public SqlSessionFactory sqlSessionFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource());
        Configuration configuration = new Configuration(environment);

        configuration.setLogImpl(Slf4jImpl.class);

        configuration.addMapper(MemberMapper.class);
        configuration.addMapper(BoardMapper.class);

        return new SqlSessionFactoryBuilder().build(configuration);
    }

    public SqlSession getSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }

    public SqlSession getSession() {
        return getSession(true);
    }

    // 싱글톤 패턴
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }
}
