package com.Object.Polymorphism;

public class Final {

}

class Variables {
    /*
        final修饰的变量即成为常量，只能赋值一次，但是 final所修饰局部变量和成员变量有所不同。
            01. final修饰的局部变量必须使用之前被赋值一次才能使用。
            02. final修饰的成员变量在声明时没有赋值的叫 “空白 final变量”。空白 final变量必须在构造方法或静态代码块中初始化。
    */
    void doSomething() {
        // 没有在声明的同时赋值
        final int e;
        // 只能赋值一次
        e = 100;
        // 使用前必须赋值
        System.out.print(e);
        // 声明的同时赋值
        final int f = 200;
    }

    //实例常量
    final int a = 5; // 直接赋值
    final int b; // 空白 final变量
    //静态常量
    final static int c = 12;// 直接赋值
    final static int d; // 空白 final变量

    // 静态代码块
    static {
        // 初始化静态变量
        // 空白 final变量需要在静态代码块中初始化
        d = 32;
    }

    // 构造方法
    Variables() {
        // 初始化实例变量
        b = 3;
        // 第二次赋值，会发生编译错误
        // b = 4;
    }
}

// final修饰的类不能被继承,会发生编译错误
/*
    final class Father {}
    class Son extends Father {}
*/

// final修饰的方法不能被子类覆盖,会发生编译错误
class SuperClass {
    final void doSomething() {
        System.out.println("in SuperClass.doSomething()");
    }
}
class SubClass extends SuperClass {
    /*
        @Override
        void doSomething() { //编译错误
            System.out.println("in SubClass.doSomething()");
        }
     */
}
