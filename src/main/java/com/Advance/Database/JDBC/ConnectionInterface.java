package com.Advance.Database.JDBC;

/**
 * Connection接口
 */
public class ConnectionInterface {
    /**
        Connection接口
        java.sql.Connection接口的实现对象代表与数据库的连接，也就是在Java程序和数据库之间建立连接。
        Connection接口中常用的方法：
            Statement createStatement()：创建一个语句对象，语句对象用来将SQL语句发送到数据库。
            PreparedStatement prepareStatement(String sql)：创建一个预编译的语句对象，
                用来将参数化的SQL语句发送到数据库，参数包含一个或者多个问号“?”占位符。
            CallableStatement prepareCall(String sql)：创建一个调用存储过程的语句对象，
                参数是调用的存储过程，参数包含一个或者多个问号“?”为占位符。
            close()：关闭到数据库的连接，在使用完连接后必须关闭，否则连接会保持一段比较长的时间，直到超时。
            isClosed()：判断连接是否已经关闭
     */
}
