package com.Object.Lambda;

// 方法引用
public class methodReference {
    /*
        Java 8之后增加了双冒号“::”运算符，该运算符用于“方法引用”，注意不是调用方法。
        “方法引用”虽然没有直接使用Lambda表达式，但也与Lambda表达式有关，与函数式接口有关。
        方法引用分为：静态方法的方法引用和实例方法的方法引用。它们的语法形式如下：
            类型名::静态方法 // 静态方法的方法引用
            实例名::实例方法 // 实例方法的方法引用

        注意：被引用方法的参数列表和返回值类型，必须与函数式接口方法参数列表和方法返回值类型一致。
    */
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        // 打印计算结果加法计算结果
        display(LambdaDemo::add, n1, n2);

        LambdaDemo d = new LambdaDemo();
        // 打印计算结果减法计算结果
        display(d::sub, n1, n2);

        // 实际参数 LambdaDemo::add是静态方法的方法引用。
        // 实际参数 d::sub,是实例方法的方法引用，d是 LambdaDemo实例。
    }

    public static void display(Calculable calc, int n1, int n2) {
        System.out.println(calc.calculateInt(n1, n2));
    }

}

class LambdaDemo {
    // 静态方法，进行加法运算
    // 参数列表要与函数式接口方法calculateInt(int a, int b)兼容
    public static int add(int a, int b) {
        return a + b;
    }

    // 实例方法，进行减法运算
    // 参数列表要与函数式接口方法calculateInt(int a, int b)兼容
    public int sub(int a, int b) {
        return a - b;
    }
}