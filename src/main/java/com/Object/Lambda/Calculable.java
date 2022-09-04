package com.Object.Lambda;

/*
    Lambda表达式实现的接口不是普通的接口，称为是函数式接口，这种接口只能有一个方法。
    如果接口中声明多个抽象方法，那么Lambda表达式会发生编译错误：
    The target type of this expression must be a functional interface
    这说明该接口不是函数式接口，为了防止在函数式接口中声明多个抽象方法，

    Java 8提供了一个声明函数式接口注解 @FunctionalInterface，
    在接口之前使用@FunctionalInterface注解修饰，那么试图增加一个抽象方法时会发生编译错误。
    但可以添加默认方法和静态方法

    提示：Lambda表达式是一个匿名方法代码，Java中的方法必须声明在类或接口中，
    那么Lambda表达式所实现的匿名方法是在函数式接口中声明的。
*/

@FunctionalInterface
public interface Calculable {
    // 计算两个int数值
    int calculateInt(int a, int b);
    // int another1 (int x); // 新增一个抽象方法时会发生编译错误
    // 新增静态方式时不会报错
    static int another2 (int y) {return y;};
    // 新增默认方式时不会报错
    default int another3(int z) {return z;};
}
