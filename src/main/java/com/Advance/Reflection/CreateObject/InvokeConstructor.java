package com.Advance.Reflection.CreateObject;

import java.lang.reflect.Constructor;

/**
 * 调用构造方法
 * */
public class InvokeConstructor {
    /**
        Java反射机制提供了另外一种创建对象方法，Class类提供了一个实例方法newInstance()，通过该方法可以创建对象
            Class clz = Class.forName("java.lang.String");
            String str = (String) clz.newInstance();
        这两条语句相当于String str = new String()语句。另外，
        需要注意newInstance()方法有可以会抛出InstantiationException和IllegalAccessException异常，
        InstantiationException不能实例化异常，IllegalAccessException是不能访问构造方法异常。

        调用方法newInstance()创建对象，这个过程中需要调用构造方法，上面的代码只是调用了String的默认构造方法。
        如果想要调用非默认构造方法，需要使用Constructor对象，它对应着一个构造方法，
        获得Constructor对象需要使用Class类的如下方法：
            Constructor[] getConstructors()：返回所有公有构造方法Constructor对象数组。
            Constructor[] getDeclaredConstructors()：返回所有构造方法Constructor对象数组。
            Constructor getConstructor(Class... parameterTypes)：根据参数列表返回一个共有Constructor对象。
                参数parameterTypes是Class数组，指定构造方法的参数列表。
            Constructor getDeclaredConstructor(Class... parameterTypes)：根据参数列表返回一个Constructor对象。
                参数parameterTypes同上。
     */

    public static void main(String[] args) {
        try {
            Class clz = Class.forName("java.lang.String");
            // 调用默认构造方法，通过调用Class的newInstance()方法创建String对象，
            // 这个过程中使用String的默认构造方法public String()
            String str1 = (String) clz.newInstance();

            // 设置构造方法参数类型，参数有可能有多个需要Class数组类型
            Class[] params = new Class[1];
            // 第一个参数是String
            params[0] = String.class;

            // 获取与参数对应的构造方法
            Constructor constructor = clz.getConstructor(params);
            // 为构造方法传递参数，参数值放到Object数组中，
            Object[] argObjs = new Object[1];
            // 第一个参数传递"Hello"
            argObjs[0] = "Hello";

            // 调用非默认构造方法，构造方法第一个参数是String类型
            String str2 = (String) constructor.newInstance(argObjs);
            System.out.println(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
