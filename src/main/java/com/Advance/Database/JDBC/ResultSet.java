package com.Advance.Database.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ResultSet接口
 * */
public class ResultSet {
    /**
        在Statement执行SQL语句时，如果是SELET语句会返回结果集，
        结果集通过接口java.sql.ResultSet描述的，它提供了逐行访问结果集的方法，
        通过该方法能够访问结果集中不同字段的内容。
        ResultSet提供了检索不同类型字段的方法，最常用的方法介绍如下：
            close()：关闭结果集对象。
            isClosed()：判断结果集对象是否已经关闭。
            next()：将结果集的光标从当前位置向后移一行。
            getString()：获得在数据库里是CHAR 或 VARCHAR等字符串类型的数据，返回值类型是String。
            getFloat()：获得在数据库里是浮点类型的数据，返回值类型是float。
            getDouble()：获得在数据库里是浮点类型的数据，返回值类型是double。
            getDate()：获得在数据库里是日期类型的数据，返回值类型是java.sql.Date。
            getBoolean()：获得在数据库里是布尔数据的类型，返回值类型是boolean。
            getBlob()：获得在数据库里是Blob(二进制大型对象)类型的数据，返回值类型是Blob类型。
            getClob()：获得在数据库里是Clob(字符串大型对象)类型的数据，返回值类型是Clob。
        这些方法要求有列名或者列索引，如getString()方法的两种情况:
            public String getString(int columnlndex) throws SQLException
            public String getString(String columnName) throws SQLException

        方法getXXX提供了获取当前行中某列值的途径，在每一行内，可按任何次序获取列值。
        使用列索引有时会比较麻烦，这个顺序是select语句中的顺序：
            select * from user
            select userid, name from user
            select name,userid from user

        注意：columnlndex列索引是从1开始的，而不是从0开始的。这个顺序与select语句有关，
            如果select使用*返回所有字段，如select * from user语句，那么列索引是数据表中字段的顺序；
            如果select指定具体字段，如select userid, name from user或select name,userid from user，
            那么列索引是select指定字段的顺序。
     */

    public static void main (String[] args) {
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

        /**
            注意：Connection对象、Statement对象和ResultSet对象都不能被JVM的垃圾收集器回收，
                在使用完后都必须关闭（调用它们的close()方法）。Java7之前都在finally模块中关闭释放资源。
                Java7之后它们都继承了AutoCloseable接口，可以通过自动资源管理技术释放资源。
         */
        String url = "jdbc:mysql://localhost:3306/Test";
        try ( // 自动资源管理技术释放资源
              Connection conn = DriverManager.getConnection(url, info);
              Statement stmt = conn.createStatement();
              java.sql.ResultSet rst = stmt.executeQuery("select name,userid from user")) {

            /**
                在遍历结果集时使用了rst.next()方法，next()是将结果集光标从当前位置向后移一行，
                结果集光标最初位于第一行之前；第一次调用 next 方法使第一行成为当前行；第二次调用使第二行成为当前行，
                依此类推。如果新的当前行有效，则返回 true；如果不存在下一行，则返回false。
             */
            while (rst.next()) {
                System.out.printf("name:%s id:%d\n", rst.getString("name"), rst.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
