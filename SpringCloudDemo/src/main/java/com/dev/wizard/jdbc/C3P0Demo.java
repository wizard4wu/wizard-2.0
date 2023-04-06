package com.dev.wizard.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

public class C3P0Demo {
    public static void main(String[] args) throws Exception{
        //获取C3P0连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("wizard");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/wizard");
        dataSource.setDriverClass("com.mysql.jdbc.cj.Driver");
        dataSource.setInitialPoolSize(2);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        dataSource.close();
    }
}
