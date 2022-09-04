package com.Advance.Annotation;

/**
 * 基础注解
 * */
public class Basic {
    /**
        无论是哪一种注解，本质上都一种数据类型，是一种接口类型。到Java 8为止Java SE提供11种内置注解。
        其中有5是基本注解，它们来自于java.lang包。
        有6个是元注解 （Meta Annotation），它们来自于java.lang.annotation包，元注解就是负责注解其他的注解，
        自定义注解会用到元注解。

        基本注解包括：@Override、@Deprecated、@SuppressWarnings、@SafeVarargs和@FunctionalInterface
     */

    private String a;

    /**
        @Override只能用于方法，子类覆盖父类方法（或者实现接口的方法）时可以@Override注解。
        编译器会检查被@Override注解的方法，确保该方法父类中存在的方法，否则会有编译错误

        注意：当然如果该方法前面不加@Override注解，即便是方法写错误了，也不会有编译错误，
            但是Object父类的toString()方法并没有被覆盖。这会引起程序出现Bug
     */
    @Override
    public String toString() {
        return a;
    }

    /**
        @SuppressWarnings注解用来抑制编译器警告，如果你确认程序中的警告没有问题，可以不用理会。
        但是就是不想看到这些警告，可以使用@SuppressWarnings注解消除这些警告

        @SuppressWarnings注解中的deprecation表示要抑制API已经过时
     */
    @SuppressWarnings("deprecation")
    public static void main (String[] args) {
        out o = new out();
        o.setAB("a", 1);

        // 传递可变参数，参数是泛型集合
        display(10, 20, 30);
        // 传递可变参数，参数是非泛型集合
        // 没有使用@SafeVarargs注解会有编译警告
        display("10", 20, 30);
    }

    /**
        声明了一种可变参数方法display，display方法参数个数可以变化，它可以接受不确定数量的相同类型的参数。
        可以通过在参数类型名后面加入...的方式来表示这是可变参数。可变参数方法中的参数类型相同，
        为此声明参数是需要指定泛型。但是调用可变参数方法时，应该提供相同类型的参数，
        display(10, 20, 30);调用时没有警告，
        而display("10", 20, 30);调用时则会发生警告，这个警告是unchecked“未检查不安全代码”，
        就是由于将非泛型变量赋值给泛型变量所发生的。

        在可变参数display前添加@SafeVarargs注解，可以解决编译警告问题
        当然可用也可以使用@SuppressWarnings("unchecked")注解，
        但@SafeVarargs注解更适合。
     */
    @SafeVarargs
    public static <T> void display(T... array) {
        for (T arg : array) {
            System.out.println(arg.getClass().getName() + ":" + arg);
        }
    }
}


/**
    @Deprecated用来指示API已经过时了，@Deprecated可以用来注解类、接口、成员方法和成员变量
 */
@Deprecated
class out {

    @Deprecated
    private String a;

    private int b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Deprecated
    public void setAB(String a, int b) {
        this.a = a;
        this.b = b;
    }
}

/**
    Java 8提供了一个声明函数式接口注解 @FunctionalInterface，
    在接口之前使用@FunctionalInterface注解修饰，那么试图增加一个抽象方法时会发生编译错误。
    但可以添加默认方法和静态方法
 */
/**
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
 */