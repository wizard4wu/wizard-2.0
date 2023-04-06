package com.dev.wizard.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * 德鲁伊数据库连接池
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception{

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("wizard");
        dataSource.setUrl("jdbc:mysql://localhost:3306/wizard");
        dataSource.setInitialSize(8);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);


        Properties properties = new Properties();
        properties.setProperty("username", "root");
        properties.setProperty("password", "wizard");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/wizard");
        DataSource dataSource2 = DruidDataSourceFactory.createDataSource(properties);
        Connection connection2 = dataSource2.getConnection();
        System.out.println(connection2);
    }
}
