package com.Advance.Database.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnWithProp {
    /**
        数据连接的url字符串可以有很多参数对，包括数据库用户名和密码也都可以参数对形式放到url字符串中，
        有的url字符串会很长维护起来不方便，可以把这些参数对放置到Properties对象中
     */

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            // 退出
            return;
        }

        String url = "jdbc:mysql://localhost:3306/Test";
        //创建Properties对象
        Properties info = new Properties();
        // 设置参数，setProperty()方法键和值都是字符串类型
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        info.setProperty("verifyServerCertificate", "false");
        info.setProperty("useSSL", "false");

        // DriverManager的getConnection(String url，Properties info)方法建立数据连接
        try (Connection conn = DriverManager.getConnection(url, info)) {
            System.out.println("数据库连接成功：" + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}
