package com.Advance.Database.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnWitgPropFile {
    /**
        但是把参数对放置到Properties对象中还是有不尽人意的地方，就是这些参数都是“硬编码”
        在程序代码中的，程序编译之后不能修改。但是数据库用户名、密码、服务器主机名、端口等等这一切，
        在开发阶段和部署阶段可能完全不同，这些参数信息应该可以配置的，可以放到一个属性文件中，
        借助于输入流，可以在运行时读取属性文件内容到Properties对象中。
     */

    public static void main(String[] args) {
        //加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            // 退出
            return;
        }

        Properties info = new Properties();
        try {
            // 获得config.properties属性文件输入流对象
            // config.properties文件放在.\src\main\resources\路径下
            InputStream input = ConnWitgPropFile.class.getClassLoader().getResourceAsStream("config.properties");

            // 从流中加载信息到Properties对象中
            info.load(input);
        } catch (IOException e) {
            // 退出
            return;
        }

        String url = "jdbc:mysql://localhost:3306/Test";
        try (Connection conn = DriverManager.getConnection(url, info)) {
            System.out.println("数据库连接成功：" + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
