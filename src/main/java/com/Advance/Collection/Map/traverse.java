package com.Advance.Collection.Map;

import java.util.*;

// 遍历 Map集合
public class traverse {
    /*
        Map集合遍历与List和Set集合不同，Map有两个集合，
        因此遍历时可以只遍历值的集合，也可以只遍历键的集合，也可以同时遍历。
        这些遍历过程都可以使用for-each循环和迭代器进行遍历。
    */
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");
        map.put(111, "李四");

        // 1.使用for-each循环遍历
        System.out.println("--1.使用for-each循环遍历--");

        // 获得键集合，返回值是 Set类型
        Set keys = map.keySet();
        for (Object key : keys) {
            int ikey = (Integer) key; // 自动拆箱
            String value = (String) map.get(ikey); // 自动装箱
            System.out.printf("key=%d - value=%s \n", ikey, value);
        }

        // 2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");

        // 获得值集合，返回值是 Collection类型，遍历 Collection集合和 Set集合一样
        Collection values = map.values();

        // 遍历值集合
        Iterator it = values.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String s = (String) item;
            System.out.println("值集合元素: " + s);
        }
    }
}
