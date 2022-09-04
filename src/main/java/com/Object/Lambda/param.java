package com.Object.Lambda;

// 作为参数使用Lambda表达式
public class param {
    // Lambda表达式一种常见的用途是作为参数传递给方法。这需要声明参数的类型声明为函数式接口类型。
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        // 打印计算结果加法计算结果
        display((a, b) -> {
            return a + b;
        }, n1, n2);

        // 打印计算结果减法计算结果
        display((a, b) -> a - b, n1, n2);
    }

    /*
        定义display打印计算结果方法，其中参数calc类型是Calculable，
        这个参数即可以接收实现Calculable接口的对象，也可以接收Lambda表达式，因为Calculable是函数式接口。
    */
    public static void display(Calculable calc, int n1, int n2) {
        System.out.println(calc.calculateInt(n1, n2));
    }
}
