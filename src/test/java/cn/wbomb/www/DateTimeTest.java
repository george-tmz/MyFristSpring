package cn.wbomb.www;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.Instant;

public class DateTimeTest {
    @Test
    public void test() throws ClassNotFoundException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/xdml";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123456";

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM `user`")) {
                    while (rs.next()) {

                        Timestamp createdAt = rs.getTimestamp(5); // 注意：索引从1开始
                        System.out.println(createdAt);
                        Instant ins = createdAt.toInstant();
                        System.out.println(ins);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
