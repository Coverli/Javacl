package com.Advance.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 遍历集合
public class traverse {
    /*
        集合最常用的操作之一是遍历，遍历就是将集合中的每一个元素取出来，进行操作或计算。List集合遍历有三种方法：
            01. 使用for循环遍历：List集合可以使用for循环进行遍历，for循环中有循环变量，通过循环变量可以访问List集合中的元素。
            02. 使用for-each循环遍历：for-each循环是针对遍历各种类型集合而推出的，笔者推荐使用这种遍历方法。
            03. 使用迭代器遍历：Java提供了多种迭代器，List集合可以使用Iterator和ListIterator迭代器。
    */
    public static void main(String[] args) {
        List list = new ArrayList();
        String b = "B";

        // 向集合中添加元素
        list.add("A");
        list.add(b);
        list.add("C");
        list.add(b);
        list.add("D");
        list.add("E");

        // 1.使用for循环遍历
        System.out.println("--1.使用for循环遍历--");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("读取集合元素(%d): %s \n", i, list.get(i));
        }

        // 2.使用for-each循环遍历
        System.out.println("--2.使用for-each循环遍历--");
        for (Object item : list) {
            // 集合中存放的都是对象，需要将对象转换为字符串
            String s = (String) item;
            System.out.println("读取集合元素: " + s);
        }

        // 3.使用迭代器遍历
        System.out.println("--3.使用迭代器遍历--");
        Iterator it = list.iterator();
        while (it.hasNext()) {  //hasNext()方法可以判断集合中是否还有元素可以迭代，有返回true，没有返回false
            Object item = it.next();    //的next()返回迭代的下一个元素，该方法返回的Object类型需要强制转换为String类型
            String s = (String) item;
            System.out.println("读取集合元素: " + s);
        }
    }
}
