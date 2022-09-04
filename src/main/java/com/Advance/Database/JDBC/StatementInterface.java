package com.Advance.Database.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Statement接口
 * */
public class StatementInterface {
    /**
        Statement接口
        java.sql.Statement称为语句对象，它提供用于向数据库发出SQL语句，并且访问结果。
        Connection接口提供了生成Statement的方法，一般情况下可以通过connection.createStatement()方法
        就可以得到Statement对象。

        有三种Statement接口：java.sql.Statement、java.sql.PreparedStatement和java.sql.CallableStatement，
        其中PreparedStatement继承Statement接口，
        CallableStatement继承PreparedStatement接口。
        Statement实现对象用于执行基本的SQL语句，
        PreparedStatement实现对象用于执行预编译的SQL语句，
        CallableStatement实现对象用于用来调用数据库中的存储过程。

        注意：预编译SQL语句是在程序编译的时一起进行编译，这样的语句在数据库中执行时候，
            不需要编译过程，直接执行SQL语句，所以速度很快。
            在预编译SQL语句会有一些程序执行时才能确定的参数，这些参数采用“?”占位符，直到运行时再用实际参数替换。

        Statement提供了许多方法，最常用的方法如下：
            executeQuery()：运行查询语句，返回ResultSet对象。
            executeUpdate()：运行更新操作，返回更新的行数。
            close()：关闭语句对象。
            isClosed()：判断语句对象是否已经关闭。

        Statement对象用于执行不带参数的简单SQL语句
        PreparedStatement对象用于执行带参数的预编译SQL语句
        CallableStatement对象用于执行对数据库已存储过程的调用
     */

    public static void main (String[] args) {
        //加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            return;
        }

        Properties info = new Properties();
        try {
            InputStream input = ConnWitgPropFile.class.getClassLoader().getResourceAsStream("config.properties");
            info.load(input);
        } catch (IOException e) {
            return;
        }

        StatementInterface si = new StatementInterface();
        si.notParameterSimpleSQL(info);
        si.parameterPreCompiledSQL(info);
        si.callProc(info);
        si.close(info);
    }

    /**
     * Statement对象用于执行不带参数的简单SQL语句
     * */
    void notParameterSimpleSQL ( Properties info ) {
        String url = "jdbc:mysql://localhost:3306/Test";
        try (Connection conn = DriverManager.getConnection(url, info)) {
            Statement stmt = conn.createStatement();
            java.sql.ResultSet rst = stmt.executeQuery("SELECT userid, name FROM User");
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * PreparedStatement对象用于执行带参数的预编译SQL语句
     * */
    void parameterPreCompiledSQL ( Properties info ) {
        String url = "jdbc:mysql://localhost:3306/Test";
        try (Connection conn = DriverManager.getConnection(url, info)) {
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO User values(?, ?)");
            // 绑定第一个参数
            pstmt.setInt(1, 10);
            // 绑定第二个参数
            pstmt.setString(2, "guan");;
            // 执行SQL语句
            pstmt.executeUpdate();
            /**
                上述SQL语句"insert into user values(?，?)"在Java源程序编译时一起编译，
                两个问号占位符所代表的参数，在运行时绑定。

                注意：绑定参数时需要注意两个问题：绑定参数顺序和绑定参数的类型，
                    绑定参数索引是从1开始的，而不是从0开始的。根据绑定参数的类型不同选择对应的set方法。
             */
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * CallableStatement对象用于执行对数据库已存储过程的调用
     * */
    void callProc ( Properties info ) {
        String url = "jdbc:mysql://localhost:3306/Test";
        try (Connection conn = DriverManager.getConnection(url, info)) {
            // 调用存储过程SQL语句
            String strSQL = "{call proc_userinfo(?，?)}";
            java.sql.CallableStatement sqlStmt = conn.prepareCall(strSQL);
            sqlStmt.setString(1,"tony");
            sqlStmt.setString(2,"tom");
            //执行存储过程
            int i = sqlStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭数据库连接
     * */
    void close ( Properties info ) {
        String url = "jdbc:mysql://localhost:3306/Test";
        try (Connection conn = DriverManager.getConnection(url, info)) {
            System.out.println("数据库连接成功：" + conn);
            if ( !conn.isClosed() ) {
                conn.close();
                System.out.println("数据库连接已关闭");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
