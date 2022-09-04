package com.Object.Extend;

import java.util.Date;

public class Extends {

}

class Person {
    // 名字
    private String name;
    // 年龄
    private int age;
    // 出生日期
    private Date birthDate;
    // 三个参数构造方法
    public Person(String name, int age, Date d) {
        this.name = name;
        this.age = age;
        birthDate = d;
    }
    public Person(String name, int age) {
        // 调用三个参数构造方法
        this(name, age, new Date());
    }
}

// 当子类实例化时，不仅需要初始化子类成员变量，也需要初始化父类成员变量，
// 初始化父类成员变量需要调用父类构造方法，子类使用super关键字调用父类构造方法。
class Student extends Person {
    // 所在学校
    private String school;
    public Student(String name, int age, Date d, String school) {
        super(name, age, d);
        this.school = school;
    }
    public Student(String name, int age, String school) {
        // this.school = school;//编译错误
        // super语句必须位于子类构造方法的第一行,否则会发生编译错误
        super(name, age);
        this.school = school;
    }
    /*
    public Student(String name, String school) { // 编译错误
        // super(name, 30);
        this.school = school;
    }
    */
    /*
            以上构造方法由于没有super语句，编译器会试图调用父类默认构造方法（无参数构造方法），
            但是父类Person并没有默认构造方法，因此会发生编译错误。解决这个编译错误有三种办法：
                01. 在父类Person中添加默认构造方法，子类Student会隐式调用父类的默认构造方法。
                    class Person { public Person () {} }
                02. 在子类Studen构造方法添加super语句，显式调用父类构造方法，super语句必须是第一条语句。
                    public Student(String name, String school) {
                        super(name, 30);
                        this.school = school;
                    }
                03. 在子类Studen构造方法添加this语句，显式调用当前对象其他构造方法，this语句必须是第一条语句。
                    public Student(String name, String school) {
                        this(name, 20, school);
                    }
    */
}
