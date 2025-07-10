package org.koreait.global;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;
import org.koreait.global.configs.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    @Test
    void test1() throws SQLException {
        DBConnection dbConn =  DBConnection.getInstance();
        DataSource ds = dbConn.dataSource();
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
