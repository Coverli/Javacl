package com.Advance.Database.CRUD;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 案例：数据CRUD操作
 * */
public class DataManipulation {
    /**
        对数据库表中数据可以进行4类操作：数据插入（Create）、数据查询（Read）、数据更新（Update）
        和数据删除（Delete），也是俗称的“增、删、改、查”
        通过JDBC进行数据库编程的一般过程如图1.png所示
     */

    // 连接数据库url
    static String url;
    // 创建Properties对象
    static Properties info = new Properties();

    // 1.驱动程序加载，读取属性文件内容到Properties对象和加载驱动程序，
    // 这两个操作只需执行一次，所以它们最好放到静态代码块中
    static {
        // 获得属性文件输入流
        InputStream input = DataManipulation.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            // 加载属性文件内容到Properties对象
            info.load(input);
            // 从属性文件中取出url
            url = info.getProperty("url");
            // 从属性文件中取出driver
            String driverClassName = info.getProperty("driver");
            Class.forName(driverClassName);
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
        } catch (IOException e) {
            System.out.println("加载属性文件失败...");
        }
    }

    public static void main (String[] args) {
        read();
        readMaxUserId();
        insert();
        update();
        delete();
    }

    // 有条件数据查询操作
    public static void read() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 2.创建数据库连接
            conn = DriverManager.getConnection(url, info);
            // 3. 创建语句对象
            pstmt = conn.prepareStatement("select name,userid from "
            + "user where userid > ? order by userid");
            // 4. 绑定参数
            pstmt.setInt(1, 0);
            // 5. 执行查询（R）
            rs = pstmt.executeQuery();
            // 6. 遍历结果集
            while (rs.next()) {
                System.out.printf("id: %d name: %s\n", rs.getInt(2), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源，也可以使用自动资源管理技术，但会引起try语句发生嵌套
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    //  无条件数据查询操作
    //  查询最大的用户Id
    public static int readMaxUserId() {
        int maxId = 0;

        /**
            使用了自动资源管理技术，由于没有参数需要绑定，
            所以ResultSet对象可以与Connection对象和PreparedStatement对象放在一个try代码块中进行管理。
            而前面的有条件查询read()方法则不行
         */
        try (Connection conn = DriverManager.getConnection(url, info);
             PreparedStatement pstmt = conn.prepareStatement("select max(userid) from user");
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxId;
    }

    // 数据插入操作
    public static void insert() {
        try (Connection conn = DriverManager.getConnection(url, info);
             PreparedStatement pstmt
                     = conn.prepareStatement("insert into user (userid, name) values (?,?)")) {

            // 查询最大值
            int maxId = readMaxUserId();
            // 绑定参数
            pstmt.setInt(1, ++maxId);
            pstmt.setString(2, "Tony" + maxId);
            // 执行修改
            // executeUpdate()方法执行SQL语句，该方法与查询方法executeQuery()不同。
            // executeUpdate()方法返回的是整数，成功影响的记录数，即成功插入记录数
            int affectedRows = pstmt.executeUpdate();
            System.out.printf("成功插入%d条数据。\n", affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 数据更新操作
    public static void update() {
        try (Connection conn = DriverManager.getConnection(url, info);
             PreparedStatement pstmt
                     = conn.prepareStatement("update user set name = ? where userid > ?")) {

            pstmt.setString(1, "Tom");
            pstmt.setInt(2, 30);
            int affectedRows = pstmt.executeUpdate();
            System.out.printf("成功更新%d条数据。\n", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 数据删除操作
    public static void delete() {
        try (Connection conn = DriverManager.getConnection(url, info);
             PreparedStatement pstmt
                     = conn.prepareStatement("delete from user where userid = ?")) {

            int maxId = readMaxUserId();
            pstmt.setInt(1, maxId);
            int affectedRows = pstmt.executeUpdate();
            System.out.printf("成功删除%d条数据。\n", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
