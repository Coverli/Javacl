package com.Object.Enum;

/*
    01. Java枚举类型是一种类，是引用类型，具有了面向对象特性，可以添加方法和成员变量等。
    02. Java枚举类型父类是java.lang.Enum，不需要显式声明。
    03. Java枚举类型可以实现接口，与类实现接口类似。
    04. Java枚举类型不能被继承，不存在子类。
*/
public enum WeekDays {
    // 枚举常量列表
    // 添加的其他成员的枚举类需要注意，“枚举常量列表”语句必须是枚举类中的第一行代码。
    // 而且“枚举常量列表”语句后面要加分号（;）表示语句的结束，
    MONDAY("星期一", 0), TUESDAY("星期二", 1), WEDNESDAY("星期三", 2),
    THURSDAY("星期四", 3), FRIDAY("星期五", 4);

    // 实例变量
    private String name;
    private int index;
    // 静态变量
    private static int staticVar = 100;

    /*
        注意枚举类的中的构造方法只能是私有访问级别，构造方法可以省略private关键字，
        但它仍然是私有的构造方法。这也说明了枚举类不允许在外部创建对象

        提示：私有构造方法经常用于单例设计模式和工厂设计模式，使得不允许在类的外边直接调用构造方法创建对象。
            枚举类实现类似于工厂设计模式。

        一旦添加了有参数的构造方法，那么“枚举常量列表”也需要修改，
        每一个枚举常量都是一个实例，都会调用构造方法进行初始化成员变量，("星期一", 0)是调用构造方法。
        没调用前：MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
     */
    // 构造方法
    private WeekDays(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 覆盖父类中的toString()方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append('-');
        sb.append(index);
        return sb.toString();
    }

    // 实例方法
    public String getInfo() {
        // 调用父类中toString()方法
        return super.toString();
    }

    // 静态方法
    public static int getStaticVar() {
        return staticVar;
    }
}
