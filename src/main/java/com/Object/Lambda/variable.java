package com.Object.Lambda;

// Lambda表达式可以访问所在外层作用域内定义的变量，包括：成员变量和局部变量
// 此时的 Lambda表达式与普通方法一样，可以读取成员变量，也可以修改成员变量。
public class variable {
    /*
        在 Lambda表达式中成员变量可以调用和修改，但局部变量不能修改
        不管局部变量是否显式地使用final修饰，它都不能在Lambda表达式中修改变量，会发生编译错误。
    */

    // 实例成员变量
    private int value = 10;
    // 静态成员变量
    private static int staticValue = 5;

    // 静态方法，进行加法运算
    public static Calculable add() {
        // 局部变量
        int localValue = 20;

        Calculable result = (int a, int b) -> {
            // 访问局部变量
            // localValue++; // 编译错误
            int d = localValue;

            // 访问静态成员变量，不能访问实例成员变量
            staticValue++;
            int c = a + b + staticValue + d; // this.value;
            return c;
        };
        return result;
    }

    // 实例方法，进行减法运算
    public Calculable sub() {
        // 局部变量
        final int localValue = 20;

        Calculable result = (int a, int b) -> {
            // 访问静态成员变量和实例成员变量
            staticValue++;
            // 如果不与局部变量发生冲突情况下可以省略this
            this.value++;
            int c = a - b - staticValue - this.value + localValue;

            // 访问局部变量
            // localValue = c; // 编译错误
            return c;
        };
        return result;
    }
}
