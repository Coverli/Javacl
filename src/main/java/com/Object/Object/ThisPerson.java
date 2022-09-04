package com.Object.Object;

import java.util.Date;

/*
    this指向对象本身，一个类可以通过this来获得一个代表它自身的对象变量。this使用在如下三种情况中：
        调用实例变量
        调用实例方法
        调用其他构造方法
*/
public class ThisPerson {
    // 名字
    private String name;
    // 年龄
    private int age;
    // 出生日期
    private Date birthDate;
    // 三个参数构造方法
    public ThisPerson(String name, int age, Date d) {
        /*
            函数声明三个参数构造方法，其中参数name和age
            与实例变量name和age命名冲突，参数是作用域为整个方法的局部变量，
            为了防止局部变量与成员变量命名发生冲突，可以使用this调用成员变量
        * */
        this.name = name;
        this.age = age;
        birthDate = d;
        // this也可以调用本对象的方法，见this.toString()语句，在本例中this可以省略
        System.out.println(this.toString());
    }

    // 在多个构造方法重载时，一个构造方法可以调用其他的构造方法，这样可以减少代码量,如下面三个构造方法
    public ThisPerson(String name, int age) {
        // 调用三个参数构造方法
        this(name, age, null);
    }
    public ThisPerson(String name, Date d) {
        // 调用三个参数构造方法
        this(name, 30, d);
    }
    public ThisPerson(String name) {
        // 使用 this调用其他构造方法时，this语句一定是该构造方法的第一条语句。
        // 例如 this(name, null);之前调用 toString()方法则会发生错误。
        // System.out.println(this.toString()); // 发生错误

        // 调用Person(String name, Date d)构造方法
        this(name, null);
    }

    @Override
    public String toString() {
        return "Person [name=" + name
        + ", age=" + age
        + ", birthDate=" + birthDate + "]";
    }

}
