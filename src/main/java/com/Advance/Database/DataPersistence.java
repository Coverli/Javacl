package com.Advance.Database;

/**
 * 数据持久技术概述
 * */
public class DataPersistence {
    /**
        把数据保存到数据库中只是一种数据持久化方式。凡是将数据保存到存储介质中，
        需要的时候能够找到它们，并能够对数据进行修改，这些就属于数据持久化。
        Java中数据持久化技术有很多：
        文本文件
            通过Java I/O流技术将数据保存到文本文件中，然后进行读写操作，这些文件一般是结构化的文档，
            如XML、JSON和CSV等文件。结构化文档就是文件内部采取某种方式将数据组织起来。
        对象序列化
            序列化用于将某个对象以及它的状态写到文件中，它保证了被写入的对象之间的关系，
            当需要这个对象时，可以完整地从文件重新构造出来，并保持原来的状态。
            在Java中实现java.io.Serilizable接口的对象才能被序列化和反序列化。
            Java还提供了两个流：ObjectInputStream和ObjectOutputStream。
            但序列化不支持事务处理、查询或者向不同的用户共享数据。
            序列化只适用于最简单的应用，或者在某些无法有效地支持数据库的嵌入式系统中。
        数据库
            将数据保存数据库中是不错的选择，数据库的后面是一个数据库管理系统，
            它支持事务处理、并发访问、高级查询和SQL语言。Java对象保存到数据库中主要的技术有：JDBC、EJB和ORM框架等。

            Java数据库连接（Java Database Connectivity，简称JDBC）。
            企业级JavaBean（Enterprise JavaBean，简称EJB）是一个用来构筑企业级应用的服务器端组件。
            对象关系映射（Object-Relational mapping，简称ORM），它能将对象保存到数据库表中，对象与数据库表结构之间是有某种对应关系的
     */
}
