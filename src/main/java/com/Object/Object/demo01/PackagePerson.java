package com.Object.Object.demo01;

import java.util.Date;

public class PackagePerson {
    // 名字
    private String name;
    // 年龄
    private int age;
    // 出生日期
    private Date birthDate;
    // 公有级别限制
    public PackagePerson(String n, int a, Date d) {
        name = n;
        age = a;
        birthDate = d;
    }
    // 默认级别限制
    PackagePerson(String n, int a) {
        name = n;
        age = a;
    }
    // 保护级别限制
    protected PackagePerson(String n, Date d) {
        name = n;
        age = 30;
        birthDate = d;
    }
    // 私有级别限制
    // 该构造方法只能在当前类中使用，不允许在外边访问，私有构造方法可以应用于单例设计模式等设计
    // 单例模式是一种常用的软件设计模式，单例模式可以保证系统中一个类只有一个实例。
    private PackagePerson(String n) {
        name = n;
        age = 30;
    }
}
