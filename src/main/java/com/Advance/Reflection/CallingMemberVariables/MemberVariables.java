package com.Advance.Reflection.CallingMemberVariables;

import java.lang.reflect.Field;

/**
 * 调用成员变量
 * */
public class MemberVariables {
    /**
        通过反射机制还可以调用成员变量，调用方法需要使用Field对象，它对应着一个方法，
        获得Field对象需要使用Class类的如下方法：
            Field[] getFields()：返回所有公有成员变量Field对象数组。
            Field[] getDeclaredFields()：返回所有成员变量Field对象数组。
            Field getField(String name)：通过指定公共成员变量名返回Field对象。
            Field getDeclaredField(String name)：通过指定成员变量名返回Field对象

        提示:Java的反射机制非常强大，可在类外部调用类的私有成员变量和成员方法。
        这种功能看似强大，事实上却破坏了面向对象封装性。
     */

    public static void main (String[] args) {
        try {
            Class clz = Class.forName("com.a51work6.Person");
            // 调用默认构造方法
            Person person = (Person) clz.newInstance();

            // 返回成员变量名为name的Field对象
            // 这里调用的是getDeclaredField方法，而不是getField方法，因为这两个成员变量都是私有的
            Field name = clz.getDeclaredField("name");
            /**
                设置成员变量accessible标志为true
                accessible是可访问性标志，
                值为true则指示反射的对象在使用时应该取消Java语言访问检查。
                值为false则指示反射的对象应该实施Java语言访问检查。
                不仅是成员变量，方法和构造方法也可以通过setAccessible(true)设置，实现对私有方法和构造方法的访问
             */
            name.setAccessible(true);
            // 调用Field的void set(Object obj, Object value)方法为成员变量赋值
            // 其中obj要访问的目标对象，value是要赋给成员变量的数据
            name.set(person, "Tony");

            // 返回成员变量名为age的Field对象
            Field age = clz.getDeclaredField("age");
            //设置成员变量accessible标志为true
            age.setAccessible(true);
            //为成员变量age赋值
            age.set(person, 18);

            // 调用Field的Object get(Object obj)方法获取成员变量保存的数据
            // 其中obj要访问的目标对象，方法返回值是成员变量的保存的数据
            System.out.printf("[name:%s, age:%d]", name.get(person), age.get(person));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
