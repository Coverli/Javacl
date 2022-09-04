package com.Advance.Database.JDBC;

/**
 * JDBC技术概述
 * */
public class statement {
    /**
        Java中数据库编程是通过JDBC（Java Database Connectivity）实现的。
        使用JDBC技术涉及到三种不同的角色：Java官方、开发人员和数据库厂商
        1、Java官方提供JDBC接口，如Connection、Statement和ResultSet等。
        2、数据库厂商为了支持Java语言使用自己的数据库，他们根据这些接口提供了具体的实现类，
            这些具体实现类称为JDBC Driver（JDBC驱动程序），例如Connection是数据库连接接口，
            如何能够高效地连接数据库或许只有数据库厂商自己清楚，因此他们提供的JDBC驱动程序当然是最高效的，
            当然针对某种数据库也可能有其他第三方JDBC驱动程序。
        3、对于开发人员而言，JDBC提供了一致的API，开发人员不用关心实现接口的细节。

        JDBC API为Java开发者使用数据库提供了统一的编程接口，它由一组Java类和接口组成。
        这种类和接口来自于java.sql和javax.sql两个包。
            java.sql：这个包中的类和接口主要针对基本的数据库编程服务，如创建连接、执行语句、语句预编译和批处理查询等。
                同时也有一些高级的处理，如批处理更新、事务隔离和可滚动结果集等。
            javax.sql：它主要为数据库方面的高级操作提供了接口和类，提供分布式事务、连接池和行集等。s
     */
}
