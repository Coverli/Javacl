package com.Object.Object;

public class NullObject {
    public static void main (String[] args) {
        // 一个引用变量没有通过new分配内存空间，这个对象就是空对象null
        String name = null;
        // 输出 null 字符串
        System.out.println(name);
        // 调用length()方法时，name是空对象
        // 引用变量默认值是null。当试图调用一个空对象的实例变量或实例方法时,会抛出空指针异常 NullPointerException
        int len1 = name.length();

        /*
            产生空对象有两种可能性：
            第一是程序员自己忘记了实例化，
            第二是空对象是别人传递过来的。
            程序员必须防止第一种情况的发生，应该仔细检查自己的代码，为自己创建的所有对象进行实例化并初始化。
            第二种情况需要通过判断对象非null进行避免。
        */
        //判断对象是否为null
        if (name != null) {
            int len2 = name.length();
        }
    }

}
