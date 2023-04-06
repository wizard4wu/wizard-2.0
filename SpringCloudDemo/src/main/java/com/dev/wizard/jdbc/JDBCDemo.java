package com.dev.wizard.jdbc;

import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.support.spring.stat.annotation.Stat;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDemo {
    public static void main(String[] args) throws Exception{
       firstGetConnection();
       secondGetConnection();
    }

    @SneakyThrows
    public static void firstGetConnection(){
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/wizard";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "wizard");
        Connection connection = driver.connect(url, properties);
        System.out.println(connection);
    }
    @SneakyThrows
    public static void secondGetConnection(){
       String url = "jdbc:mysql://localhost:3306/wizard";
       Class.forName("com.mysql.cj.jdbc.Driver");

       String email = "1 or 1=1";
       String sql = "select * from my_user where email = " + email;
       Connection connection = DriverManager.getConnection(url, "root", "wizard");

       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery(sql);
       resultSet.next();
       String eamil = resultSet.getString("email");
       System.out.println(resultSet);
    }
}
