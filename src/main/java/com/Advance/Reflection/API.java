package com.Advance.Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Java反射机制API
 * */
public class API {
    /**
        Java反射机制API主要是 java.lang.Class类和java.lang.reflect包
     */
    public static void main (String[] args) {
        classclass cc = new classclass();
        cc.c1();
        reflectPackage rp = new reflectPackage();
        rp.r1();
    }
}

/** java.lang.Class类 */
class classclass {
    /**
        java.lang.Class类是实现反射的关键所在，Class类的一个实例表示Java的一种数据类型，
        包括类、接口、枚举、注解（Annotation）、数组、基本数据类型和void，void是“无类型”，
        主要用于方法返回值类型声明，表示不需要返回值。Class没有公有的构造方法，Class实例是由JVM在类加载时自动创建的

        每一种类型包括类和接口等，都有一个class静态变量可以获得Class实例。
        另外，每一个对象都有getClass()方法可以获得Class实例，该方法是由Object类提供的实例方法。
     */

    void c1() {

        // 获得Class实例
        // 1.通过类型class静态变量
        Class clz1 = String.class;
        String str = "Hello";
        // 2.通过对象的getClass()方法
        Class clz2 = str.getClass();

        //获得int类型Class实例
        Class clz3 = int.class;

        //获得Integer类型Class实例
        Class clz4 = Integer.class;

        System.out.println("clz2类名称：" + clz2.getName());
        System.out.println("clz2是否为接口：" + clz2.isInterface());
        System.out.println("clz2是否为数组对象：" + clz2.isArray());
        System.out.println("clz2父类名称：" + clz2.getSuperclass().getName());
        System.out.println("clz2是否为基本类型：" + clz2.isPrimitive());
        System.out.println("clz3是否为基本类型：" + clz3.isPrimitive());
        System.out.println("clz4是否为基本类型：" + clz4.isPrimitive());
    }
}

/** java.lang.reflect包 */
class reflectPackage {
    /**
        java.lang.reflect包提供了反射中用到类，主要的类说明如下：
            Constructor类：提供类的构造方法信息。
            Field类：提供类或接口中成员变量信息。
            Method类：提供类或接口成员方法信息。
            Array类：提供了动态创建和访问Java数组的方法。
            Modifier类：提供类和成员访问修饰符信息。
     */

    void r1 () {
        try {
            // 动态加载xx类的运行时对象
            // 是通过Class的静态方法forName(String)创建某个类的运行时对象，
            // 其中的参数是类全名字符串，如果在类路径中找不到这个类则抛出ClassNotFoundException异常
            Class c = Class.forName("java.lang.String");

            // 获取成员方法集合，通过Class的实例方法getDeclaredMethods()返回某个类的成员方法对象数组
            Method[] methods = c.getDeclaredMethods();

            // 遍历成员方法集合，其中的元素是Method类型。
            for (Method method : methods) {

                // 打印权限修饰符，如public、protected、private
                // method.getModifiers()方法返回访问权限修饰符常量代码，是int类型，
                // 例如1代表public，这些数字代表的含义可以通过Modifier.toString(int)方法转换为字符串
                System.out.print(Modifier.toString(method.getModifiers()));

                // 打印返回值类型名称
                // 通过Method的getReturnType()方法获得方法返回值类型，然后再调用getName()方法返回该类型的名称
                System.out.print(" " + method.getReturnType().getName() + " ");
                // 打印方法名称
                System.out.println(method.getName() + "();");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定类");
        }
    }
}