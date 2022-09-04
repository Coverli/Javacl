package com.Object.Polymorphism;

public class ReferenceCheck {
    /*
        有时候需要在运行时判断一个对象是否属于某个引用类型，这时可以使用instanceof运算符，instanceof运算符语法格式如下：
        obj instanceof type
        其中obj是一个对象，type是引用类型，如果obj对象是type引用类型实例则返回true，否则false。
    */
    public static void main(String[] args) {
        Student student1 = new Student("Tom", 18, "清华大学");
        Student student2 = new Student("Ben", 28, "北京大学");
        Student student3 = new Student("Tony", 38, "香港大学");

        Worker worker1 = new Worker("Tom", 18, "钢厂");
        Worker worker2 = new Worker("Ben", 20, "电厂");
        Person[] people = { student1, student2, student3, worker1, worker2 };
        int studentCount = 0;
        int workerCount = 0;
        for (Person item : people) {
            if (item instanceof Worker) {
                workerCount++;
            } else if (item instanceof Student) {
                studentCount++;
            }
        }
        System.out.printf("工人人数：%d，学生人数：%d", workerCount, studentCount);
        System.out.println();
        System.out.println("Person类数组遍历");
        for (Person item : people) {
            System.out.println(item);
        }
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
        return "Person [name=" + name
                + ", age=" + age + "]";
    }
}

class Worker extends Person {
    String factory;
    public Worker(String name, int age, String factory) {
        super(name, age);
        this.factory = factory;
    }
    @Override
    public String toString() {
        return "Worker [factory=" + factory
                + ", name=" + name
                + ", age=" + age + "]";
    }
}

class Student extends Person {
    String school;
    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }
    @Override
    public String toString() {
        return "Student [school=" + school
                + ", name=" + name
                + ", age=" + age + "]";
    }
}
