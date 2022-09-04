package com.Advance.Generics;

import java.util.ArrayList;
import java.util.List;

// 泛型的思考
public class statement {
    public static void main (String[] args) {
        statement stm = new statement();
        stm.demoOne();
        stm.demoTwo();
    }

    void demoOne () {
        List list = new ArrayList();

        // 向集合中添加元素
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        // 遍历集合
        for (Object item : list) {
            Integer element = (Integer) item;
            System.out.println("读取集合元素: " + element);
        }
    }
    /*
        上述代码实现的功能很简单，就将一些数据保存到集合中，然后再取出。
        但对于Java 5之前程序员而言，使用集合经常会面临一个很尴尬的问题：
        放入一个种特定类型，但是取出时候全部是Object类型，于是在具体使用时候需要将元素转换为特定类型。
        上述代码取出的元素是Object类型，需要强制类型转换。
        强制类型转换是有风险的，如果不进行判断就臆断进行类型转换会发生ClassCastException异常。
        本例代码就会发生了这个异常，JVM会抛出异常，打印出如下的异常堆栈跟踪信息。
            Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer at com.a5从异常堆栈跟踪信息可知，在源代码代码第23行试图将java.lang.String对象java.lang.Integer对象。
        在Java 5之前没有好的解决办法，在类型转换之前要通过instanceof运算符判断一下，该对象是否是目标类型。
        而泛型的引入可以将这些运行时异常提前到编译期暴露出来，这增强了类型安全检查。
    */

    void demoTwo () {
        List<String> list = new ArrayList<String>();

        // 向集合中添加元素
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        //list.add(new Date); //发生编译错误 ②

        // 遍历集合
        // 使用for-each循环遍历
        for (String item : list) {
            //Integer element = (Integer) item;
            System.out.println("读取集合元素: " + item);
        }
    }
    /*
        上述代码在List和ArrayList后面添加了<String>，这就是List和ArrayList的泛型表示方式，

        尖括号中可以任何的引用类型，它限定了集合中是能存放该种类型的对象，

        所以代码 list.add(new Date);试图添加非String类型元素时，会发生编译错误。

        从集合取出的元素就是String类型，所以如果试图转换为Integer会发生编译错误。
        可见原本在运行时发生的异常，提早暴露到编译期，使程序员早发现问题，避免程序发布上线之后发生系统崩溃。
    */
}
