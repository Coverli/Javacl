package com.Advance.Database.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public static Connection Connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

            // MySQL8.0以下的版本
			// Class.forName("com.mysql.jdbc.Driver");

            // JDBC-ODBC桥接，Java自带
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("驱动加载成功");
		} catch (Exception e) {
			System.out.println("驱动加载失败");
		}
		try {
            /**
                驱动程序加载成功就可以进行数据库连接了。
                建立数据库连接可以通过调用DriverManager类的getConnection()方法实现，
                该方法有几个重载版本，如下所示。
                    static Connection getConnection(String url)：尝试通过一个URL建立数据库连接，
                        调用此方法时，DriverManager会试图从已注册的驱动中选择恰当的驱动来建立连接。
                    static Connection getConnection(String url，Properties info)：尝试通过一个URL建立数据库连接，
                        一些连接参数（如user和password）可以按照键值对的形式放置到info中，
                        Properties是Hashtable的子类，它是一种Map结构。
                    static Connection getConnection(String url, String user, String password)：
                        尝试通过一个URL建立数据库连接，指定数据库用户名和密码。

                上面的几个getConnection()方法都会抛出受检查的SQLException异常，注意处理这个异常

                JDBC的URL类似于其他场合的URL，它的语法如下：
                    jdbc:<subprotocol>:<subname>
                这里有三个部分，它们用冒号隔离。
                    01. 协议：jdbc表示协议，它是唯一的，JDBC只有这一种协议。
                    02. 子协议：主要用于识别数据库驱动程序，也就是说，不同的数据库驱动程序的子协议不同。
                    03. 子名：它属于专门的驱动程序，不同的专有驱动程序可以采用不同的实现。

                对于不同的数据库，厂商提供的驱动程序和连接的URL都不同，总结后如图1.png所示
             */
			String url = "jdbc:mysql://127.0.0.1:3306/Test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Hongkong";
			// MySQL 8.0以下的版本
			// String url = "jdbc:mysql://127.0.0.1:3306/Test"
			String user = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
			/**
			 	关于URL中：
					useSSL=false表示不使用SSL进行网络通信
			 		allowPublicKeyRetrieval=true表示运行进行公钥检索
			 		verifyServerCertificate=false表示不进行安全认证
			 		serverTimezone=Hongkong表示将时区设置为香港
			 	另外Connection接对象是通过自动资源管理技术释放资源的。
				注意:Connection对象代表的数据连接不能被JVM的垃圾收集器回收，在使用完连接后必须关闭（调用close()方法），
			 	否则连接会保持一段比较长的时间，直到超时。Java 7之前都在finally模块中关闭数据库连接。
			 	Java 7之后可以Connection接口继承了AutoCloseable接口，可以通过自动资源管理技术释放资源。
			 */
			System.out.println("数据库连接成功");

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("连接失败");
		}
		return conn;
	}
}