package com.Object.Polymorphism;

public class ReferenceTransfer {
    /*
        引用类型可以进行转换，但并不是所有的引用类型都能互相转换，
        只有属于同一棵继承层次树中的引用类型才可以转换
    */
    public static void main(String[] args) {
        Person p1 = new Student("Tom", 18, "清华大学");
        Person p2 = new Worker("Tom", 18, "钢厂");
        Person p3 = new Person("Tom", 28);
        Student p4 = new Student("Ben", 40, "清华大学");
        Worker p5 = new Worker("Tony", 28, "钢厂");

        /*
            引用类型转换也是通过小括号运算符实现，类型转换有两个方向：
            将父类引用类型变量转换为子类类型，这种转换称为向下转型（downcast）；
            将子类引用类型变量转换为父类类型，这种转换称为向上转型（upcast）。
            向下转型需要强制转换，而向上转型是自动的。
        */
        // 向上转型
        Person p = (Person) p4;
        // 向下转型
        Student p11 = (Student) p1;
        Worker p12 = (Worker) p2;
        // Student p111 = (Student) p2; //运行时异常 p2类型为 Person
        if (p2 instanceof Student) {
            Student p111 = (Student) p2;
        }
        // Worker p121 = (Worker) p1; //运行时异常 p1类型为 Person
        if (p1 instanceof Worker) {
            Worker p121 = (Worker) p1;
        }
        // Student p131 = (Student) p3; //运行时异常 p3类型为 Person
        if (p3 instanceof Student) {
            Student p131 = (Student) p3;
        }
    }
}
