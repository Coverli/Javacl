package com.Advance.Generics;

import java.util.*;

// 使用泛型
public class howUse {
    /*
        泛型对于Java影响最大就是集合了，Java 5之后所有的集合类型都可以有泛型类型，
        可以限定存放到集合中的类型。打开com.Advance.Collection.statement.java文件或打开API文档，
        会发现集合类型后面会有<E>，如：Collection<E>、List<E>、ArrayList<E>、Set<E>和Map<K,V>，
        这说明这些类型是支持泛型的。尖括号中的E、K和V等是类型参数名称，它们是实际类型的占位符。
    */

    public static void main (String[] args) {
        howUse hu = new howUse();
        hu.demoSet();
        hu.demoMap();
    }

    void demoSet () {
        // Set和HashSet类型后面都指定了泛型，<String>说明实际类型是String
        Set<String> set = new HashSet<String>();

        // 向集合中添加元素
        set.add("A");
        set.add("D");
        set.add("E");

        // 1.使用for-each循环遍历
        System.out.println("--1.使用for-each循环遍历--");
        // 因为有了泛型可以保证从集合中取出元素一定是String类型，声明元素类型是String。
        for (String item : set) {
            System.out.println("读取集合元素: " + item);
        }

        // 2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        // 采用Iterator迭代器遍历集合，也需要为迭代器指定泛型，限定它的实际类型是String
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            // 指定泛型的迭代器，在取出元素时不需要强制类型转换
            String item = it.next();
            System.out.println("读取集合元素: " + item);
        }
    }

    void demoMap () {
        // Map<Integer, String>是指定Map泛型集合类型，其中键集合限定Integer类型，值集合限定String类型，
        // HashMap<Integer, String>也需要同样的泛型
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");

        // 1.使用for-each循环遍历
        System.out.println("--1.使用for-each循环遍历--");
        // 获得键集合，指定它的类型是Set<Integer>
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            // 指定泛型的迭代器，在取出元素时不需要强制类型转换
            String value = map.get(key);
            System.out.printf("key=%d - value=%s \n", key, value);
        }

        // 2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        // 获得值集合，指定它的类型是Collection<String>
        Collection<String> values = map.values();
        // 遍历值集合
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("值集合元素: " + item);
        }
    }
}
