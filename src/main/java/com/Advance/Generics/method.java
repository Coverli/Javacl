package com.Advance.Generics;

// 泛型方法
// 在方法中也可以使用泛型，即方法的参数类型或返回值类型，可以用类型参数表示。
public class method {
}

class HelloWorld {
    public static void main(String[] args) {
        System.out.println(isEquals(new Integer(1), new Integer(5)));
        System.out.println(isEquals(1, 5));// 发生了自动装箱
        System.out.println(isEquals(new Double(1.0), new Double(1.0)));
        System.out.println(isEquals(1.0, 1.0));// 发生了自动装箱
        System.out.println(isEquals("A", "A"));
    }

    // isEquals()方法可以接收两个参数，它们是任何引用类型，返回值是<T>指定占位符为T，方法中的参数类型用T表示
    public static <T> boolean isEquals(T a, T b) {
        return a.equals(b);
    }
}

class HelloWorldLimit {
    public static void main(String[] args) {
        System.out.println(isEquals(new Integer(1), new Integer(5)));
        System.out.println(isEquals(1, 5));// 发生了自动装箱
        System.out.println(isEquals(new Double(1.0), new Double(1.0)));
        System.out.println(isEquals(1.0, 1.0));// 发生了自动装箱
        // System.out.println(isEquals("A", "A")); //编译错误
    }

    // 限定类型参数为Number
    // 定义泛型使用<T extends Number>语句，该语句是限定类型参数只能是Number类型。
    // 当试图传递String类型的参数，则会发生编译错误。
    public static <T extends Number> boolean isEquals(T a, T b) {
        return a.equals(b);
    }
}
