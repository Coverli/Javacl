package com.Advance.Collection.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 遍历 Set集合
public class traverse {
    /*
        Set集合中的元素由于没有序号，所以不能使用for循环进行遍历，
        但可以使用for-each循环和迭代器进行遍历。事实上这两种遍历方法也是继承自Collection集合，
        也就是说所有的Collection集合类型都有这两种遍历方式
    */
    public static void main(String[] args) {
        Set set = new HashSet();
        String b = "B";

        // 向集合中添加元素
        set.add("A");
        set.add(b);
        set.add("C");
        set.add(b);
        set.add("D");
        set.add("E");

        // 1.使用for-each循环遍历
        System.out.println("--1.使用for-each循环遍历--");
        for (Object item : set) {
            String s = (String) item;
            System.out.println("读取集合元素: " + s);
        }

        // 2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String s = (String) item;
            System.out.println("读取集合元素: " + s);
        }
    }
}
