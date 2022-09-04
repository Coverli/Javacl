package com.Object.Class.demo02;

public class Package {

}

/*
对于基本类型当中的boolean值，Getter方法一定要写成isXxx的形式，而setXxx规则不变。
 */
class Student {

    private String name; // 姓名
    private int age; // 年龄
    private boolean male; // 是不是爷们儿

    public void setMale(boolean b) {
        male = b;
    }

    public boolean isMale() {
        return male;
    }

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    public void setAge(int num) {
        age = num;
    }

    public int getAge() {
        return age;
    }
}

class DemoStudent {

    public static void main(String[] args) {
        Student stu = new Student();

        stu.setName("鹿晗");
        stu.setAge(20);
        stu.setMale(true);

        System.out.println("姓名：" + stu.getName());
        System.out.println("年龄：" + stu.getAge());
        System.out.println("是不是爷们儿：" + stu.isMale());
    }
}

/*
局部变量和成员变量

1. 定义的位置不一样【重点】
局部变量：在方法的内部
成员变量：在方法的外部，直接写在类当中

2. 作用范围不一样【重点】
局部变量：只有方法当中才可以使用，出了方法就不能再用
成员变量：整个类全都可以通用。

3. 默认值不一样【重点】
局部变量：没有默认值，如果要想使用，必须手动进行赋值
成员变量：如果没有赋值，会有默认值，规则和数组一样

4. 内存的位置不一样（了解）
局部变量：位于栈内存
成员变量：位于堆内存

5. 生命周期不一样（了解）
局部变量：随着方法进栈而诞生，随着方法出栈而消失
成员变量：随着对象创建而诞生，随着对象被垃圾回收而消失
 */
class VariableDifference {
    String name; // 成员变量

    public void methodA() {
        int num = 20; // 局部变量
        System.out.println(num);
        System.out.println(name);
    }

    public void methodB(int param) { // 方法的参数就是局部变量
        // 参数在方法调用的时候，必然会被赋值的。
        System.out.println(param);

        int age; // 局部变量
//        System.out.println(age); // 没赋值不能用

//        System.out.println(num); // 错误写法！
        System.out.println(name);
    }
}

/*
面向对象三大特征：封装、继承、多态。

封装性在Java当中的体现：
1. 方法就是一种封装
2. 关键字private也是一种封装

封装就是将一些细节信息隐藏起来，对于外界不可见。
 */
class Method {
    public static void main(String[] args) {
        int[] array = {5, 15, 25, 20, 100};

        int max = getMax(array);
        System.out.println("最大值：" + max);
    }

    // 给我一个数组，我还给你一个最大值
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}

/*
问题描述：定义Person的年龄时，无法阻止不合理的数值被设置进来。
解决方案：用private关键字将需要保护的成员变量进行修饰。

一旦使用了private进行修饰，那么本类当中仍然可以随意访问。
但是！超出了本类范围之外就不能再直接访问了。

间接访问private成员变量，就是定义一对儿Getter/Setter方法

必须叫setXxx或者是getXxx命名规则。
对于Getter来说，不能有参数，返回值类型和成员变量对应；
对于Setter来说，不能有返回值，参数类型和成员变量对应。
 */
class Person {
    String name; // 姓名
    private int age; // 年龄

    public void show() {
        System.out.println("我叫：" + name + "，年龄：" + age);
    }

    // 这个成员方法，专门用于向age设置数据
    public void setAge(int num) {
        if (num < 100 && num >= 9) { // 如果是合理情况
            age = num;
        } else {
            System.out.println("数据不合理！");
        }
    }

    // 这个成员方法，专门私语获取age的数据
    public int getAge() {
        return age;
    }
}

// 访问 private 内容
class DemoPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();

        person.name = "赵丽颖";
//        person.age = -20; // 直接访问private内容，错误写法！
        person.setAge(20);
        person.show();
    }
}