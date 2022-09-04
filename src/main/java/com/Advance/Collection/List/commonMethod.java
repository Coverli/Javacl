package com.Advance.Collection.List;

import java.util.ArrayList;
import java.util.List;

// List常用方法
public class commonMethod {
    /**
        List接口继承自Collection接口，List接口中的很多方法都继承自Collection接口的。List接口中常用方法如下。
        01. 操作元素
            get(int index)：返回List集合中指定位置的元素。
            set(int index, Object element)：用指定元素替换List集合中指定位置的元素。
            add(Object element)：在List集合的尾部添加指定的元素。该方法是从Collection集合继承过来的。
            add(int index, Object element)：在List集合的指定位置插入指定元素。
            remove(int index)：移除List集合中指定位置的元素。
            remove(Object element)：如果List集合中存在指定元素，则从List集合中移除第一次出现的指定元素。
                该方法是从Collection集合继承过来的。
            clear()：从List集合中移除所有元素。该方法是从Collection集合继承过来的。
        02. 判断元素
            isEmpty()：判断List集合中是否有元素，没有返回true，有返回false。该方法是从
            Collection集合继承过来的。
            contains(Object element)：判断List集合中是否包含指定元素，包含返回true，不包含返回false。
                该方法是从Collection集合继承过来的。
        03. 查询元素
            indexOf(Object o)：从前往后查找List集合元素，返回第一次出现指定元素的索引，如果此列表不包含该元素，则返回-1。
            lastIndexOf(Object o)：从后往前查找List集合元素，返回第一次出现指定元素的索引，如果此列表不包含该元素，则返回-1。
        04. 其他
            iterator()：返回迭代器（Iterator）对象，迭代器对象用于遍历集合。该方法是从Collection集合继承过来的。
            size()：返回List集合中的元素数，返回值是int类型。该方法是从Collection集合继承过来的。
            subList(int fromIndex, int toIndex)：返回List集合中指定的 fromIndex（包括 ）和
            toIndex（不包括）之间的元素集合，返回值为List集合。
    */
    public static void main(String[] args) {
        // 声明List类型集合变量list，使用ArrayList类实例化list，List是接口不能实例化
        List list = new ArrayList();
        String b = "B";

        //向集合中添加元素
        list.add("A");
        list.add(b);
        list.add("C");
        list.add(b);
        list.add("D");
        list.add("E");

        //打印集合元素个数
        System.out.println("集合size = " + list.size());

        //打印集合
        System.out.println(list);

        //从前往后查找集合中的"B"元素
        System.out.println("indexOf(\"B\") = " + list.indexOf(b));

        //从后往前查找集合中的"B"元素
        System.out.println("lastIndexOf(\"B\") = " + list.lastIndexOf(b));

        //删除集合中第一个"B"元素
        list.remove(b);
        System.out.println("remove(3)前： " + list);

        //判断集合中是否包含"B"元素
        System.out.println("是否包含\"B\"：" + list.contains(b));

        //删除集合第4个元素
        list.remove(3);
        System.out.println("remove(3)后： " + list);

        //判断集合是否为空
        System.out.println("list集合是空的：" + list.isEmpty());
        System.out.println("替换前：" + list);

        //替换集合第2个元素
        list.set(1, "F");
        System.out.println("替换后：" + list);

        //清空集合
        // 但注意的是变量list所引用的对象还是存在的，不是null，只是集合中没有了元素
        list.clear();
        System.out.println(list);

        // 重新添加元素
        // 提示:在Java中任何集合中存放的都是对象，即引用数据类型，基本数据类型不能放到集合中
        // 所以在下面的代码中，发生了自动装箱和自动拆箱
        list.add(1);//发生自动装箱
        list.add(3);
        int item = (Integer)list.get(0);//发生自动拆箱
    }
}
