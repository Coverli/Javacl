package com.Advance.Collection.Map;

import java.util.HashMap;
import java.util.Map;

// Map常用方法
public class commonMethod {
    /*
        Map集合中包含两个集合（键和值），所以操作起来比较麻烦，Map接口提供很多方法用来管理和操作集合。主要的方法如下。
        01. 操作元素
            get(Object key)：返回指定键所对应的值；如果Map集合中不包含该键值对，则返回null。
            put(Object key, Object value)：指定键值对添加到集合中。
            remove(Object key)：移除键值对。
            clear()：移除Map集合中所有键值对。
        02. 判断元素
            isEmpty()：判断Map集合中是否有键值对，没有返回true，有返回false。
            containsKey(Object key)：判断键集合中是否包含指定元素，包含返回true，不包含返回false。
            containsValue(Object value)：判断值集合中是否包含指定元素，包含返回true，不包含返回false。
        03. 查看集合
            keySet()：返回Map中的所有键集合，返回值是Set类型。
            values()：返回Map中的所有值集合，返回值是Collection类型。
            size()：返回Map集合中键值对数。
    */
    public static void main(String[] args) {
        // 声明Map类型集合变量map，使用HashMap类实例化map，Map是接口不能实例化
        Map map = new HashMap();
        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");

        //"李四"值重复，不会替换
        map.put(111, "李四");

        //109键已经存在，替换原来值"王五"
        map.put(109, "刘备");

        // 打印集合元素个数
        System.out.println("集合size = " + map.size());

        // 打印集合
        System.out.println(map);

        // 通过键取对应的值，如果不存在键值对，则返回null，
        System.out.println("109 - " + map.get(109));
        System.out.println("108 - " + map.get(108));    // 返回 null

        // 删除键值对
        map.remove(109);

        // 判断键集合中是否包含109
        System.out.println("键集合中是否包含109：" + map.containsKey(109));

        // 判断值集合中是否包含 "李四"
        System.out.println("值集合中是否包含：" + map.containsValue("李四"));

        // 判断集合是否为空
        System.out.println("集合是空的：" + map.isEmpty());

        // 清空集合
        map.clear();
        System.out.println(map);
    }
}
