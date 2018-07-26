package jdbc;

import bean.User;

import java.sql.Connection;
import java.sql.Driver;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {
        User user = new User();
        user.setAge(13);
        user.setName("wang");
        Class.forName("com.mysql.jdbc.Driver");

    }
}
