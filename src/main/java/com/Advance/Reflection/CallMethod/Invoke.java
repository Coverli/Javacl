package com.Advance.Reflection.CallMethod;

import java.lang.reflect.Method;

/**
 * 调用方法
 * */
public class Invoke {
    /**
        通过反射机制还可以调用方法，这与调用构造方法类似。调用方法需要使用Method对象，
        它对应着一个方法，获得Method对象需要使用Class类的如下方法：
            Method[] getMethods()：返回所有公有方法Method对象数组。
            Method[] getDeclaredMethods()：返回所有方法Method对象数组。
            Method getMethod(String name, Class... parameterTypes)：通过方法名和参数类型返回公有方法
            Method对象。参数parameterTypes是Class数组，指定方法的参数列表。
            Method getDeclaredMethod(String name, Class... parameterTypes)：通过方法名和参数类型返回方法Method对象。
                参数parameterTypes同上

        现在编写一个程序通过反射机制调用Person类setNameAndAge和setName方法，
     */

    public static void main(String[] args) {
        try {
            Class clz = Class.forName("com.Advance.Reflection.CallMethod.Person");
            // 调用默认构造方法
            Person person = (Person) clz.newInstance();
            System.out.println(person);

            // 指定参数类型
            Class[] params = new Class[2];
            // 第一个参数是String
            params[0] = String.class;
            // 第二个参数是int
            params[1] = int.class;

            // 获取setNameAndAge方法对象，params参数是指定参数类型
            Method method = clz.getMethod("setNameAndAge", params);
            // 设置传递参数
            Object[] argObjs = new Object[2];
            // 第一个参数传递"Tony"
            argObjs[0] = "Tony";
            // 第二个参数传递18
            argObjs[1] = 18;
            //调用setNameAndAge方法，person是要调用的对象，argObjs是设置要传递的参数值
            method.invoke(person, argObjs);
            System.out.println(person);

            // 获取getName方法对象，该方法没有参数
            method = clz.getMethod("getName");
            // 调用getName方法，invoke方法会返回一个Object对象，它是调用目标方法的返回数据，
            Object result = method.invoke(person);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
