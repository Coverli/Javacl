package com.Advance.Collection.Set;

import java.util.HashSet;
import java.util.Set;

// Set常用方法
public class commonMethod {
    /*
        Set接口也继承自Collection接口，Set接口中大部分都是继承自Collection接口，这些方法如下。
        01. 操作元素
            add(Object element)：在Set集合的尾部添加指定的元素。该方法是从Collection集合继承过来的。
            remove(Object element)：如果Set集合中存在指定元素，则从Set集合中移除该元素。
                该方法是从Collection集合继承过来的。
            clear()：从Set集合中移除所有元素。该方法是从Collection集合继承过来的。
        02. 判断元素
            isEmpty()：判断Set集合中是否有元素，没有返回true，有返回false。该方法是从Collection集合继承过来的。
            contains(Object element)：判断Set集合中是否包含指定元素，包含返回true，不包含返回false。
                该方法是从Collection集合继承过来的。
        03. 其他
            iterator()：返回迭代器（Iterator）对象，迭代器对象用于遍历集合。该方法是从Collection集合继承过来的。
            size()：返回Set集合中的元素数，返回值是int类型。该方法是从Collection集合继承过来的。
    */
    public static void main(String[] args) {
        // 声明Set类型集合变量set，使用HashSet类实例化set，Set是接口不能实例化
        Set set = new HashSet();
        String b = "B";

        // 向集合中添加元素
        set.add("A");
        set.add(b);
        set.add("C");
        set.add(b);  // 添加集合元素时试图添加重复的元素，但Set集合是不能添加重复元素，在后面set.size()方法打印Set个数结果为5
        set.add("D");
        set.add("E");

        // 打印集合元素个数
        System.out.println("集合size = " + set.size());

        // 打印集合
        System.out.println(set);

        // 删除集合中第一个"B"元素
        set.remove(b);

        // 判断集合中是否包含"B"元素
        System.out.println("是否包含\"B\"：" + set.contains(b));

        // 判断集合是否为空
        System.out.println("set集合是空的：" + set.isEmpty());

        // 清空集合
        set.clear();
        System.out.println(set);
    }
}
