package com.Object.CommonClass;

/*
    java.lang.Object类，是Java所有类的根类，Java所有类都直接或间接继承自Object类，
    Object类属于java.lang包中的类型，不需要显示使用import语句引入，它是由解释器自动引入。

    Object类有很多方法，常用的几个方法：
        String toString()：返回该对象的字符串表示。
        boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。
*/
public class object {
    public static void main(String[] args) {
        Person person = new Person("Tony", 18);
        // 打印过程自动调用 person的 toString()方法
        // 使用System.out.println等输出语句可以自动调用对象的toString()方法将对象转换为字符串输出。
        System.out.println(person);

        Person person1 = new Person("Tony", 20);
        Person person2 = new Person("Tom", 20);
        System.out.println(person1 == person2); // false
        System.out.println(person1.equals(person2)); // true

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        /*
            为了日志输出等处理方便，所有的对象都可以以文本方式表示，需要在该对象所在类中覆盖toString()方法。
            如果没有覆盖toString()方法，默认的字符串是“类名@对象的十六进制哈希码 ”。
        */
        return "Person [name=" + name + ", age=" + age + "]";
    }

    // ==运算符是比较两个引用变量是否指向同一个实例，equals()方法是比较两个对象的内容是否相等，
    @Override
    public boolean equals(Object otherObject) {
        //判断比较的参数也是Person类型
        if (otherObject instanceof Person) {
            Person otherPerson = (Person) otherObject;
            // 年龄作为比较规则
            if (this.age == otherPerson.age) {
                return true;
            }
        }
        return false;
    }
}