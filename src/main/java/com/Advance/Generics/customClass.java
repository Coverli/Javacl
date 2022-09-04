package com.Advance.Generics;

import java.util.ArrayList;
import java.util.List;

// 自定义泛型类
public class customClass {
    /*
        根据自己的需要也可以自定义泛型类、泛型接口和带有泛型参数的方法。
        下面通过一个示例介绍一下泛型类。数据结构中有一种“队列”（queue）数据结构（如下图所示），
        它的特点是遵守“先入先出”（FIFO）规则。

            -----------------------------------
        <---出队  | 张三 | 李四 | 王五 | 老六 |   <---入队
            -----------------------------------
            前                                 后

        虽然Java SE已经提供了支持泛型的队列java.util.Queue<E>类型，但是为了学习泛型的目的，
        这里还是要自己实现的支持泛型的队列集合。
    */
    public static void main(String[] args) {
        // 实例化Queue对象，通过尖括号指定限定的类型是String
        Queue<String> genericQueue = new Queue<String>();
        genericQueue.queue("A");
        genericQueue.queue("C");
        genericQueue.queue("B");
        genericQueue.queue("D");
        //genericQueue.queue(1);//编译错误

        System.out.println(genericQueue);

        genericQueue.dequeue();         // 出队第一个元素"A"
        System.out.println(genericQueue);
    }
}

// 自定义的泛型队列集合
/*
    提示：泛型中参数类型占位符，可以是任何大写或小写的英文字母，
    一般情况下习惯于使用字母T、E、K和U等大写英文字母，但也可以使用其他的字母。

    自定义泛型类时可以能会用到多个类型参数，可以使用多个不同的字母作为占位符，类似于Map<K,V>。
    这些需要注意程序代码中哪些地方是用K表示，哪些地方用V表示。
*/
class Queue<T> {        // 定义了Queue<T>泛型类型的队列，T是参数类型占位符。
    // 声明保存队列元素集合items，用来保存队列中的元素。
    private List<T> items;

    // 构造方法初始化是集合items
    public Queue() {
        this.items = new ArrayList<T>();
    }

    /**
     * 入队方法
     * @param item 参数需要入队的元素
     * 参数类型使用占位符 T表示，注意要与 Queue<T>中的占位符保持一致。
     */
    public void queue(T item) {
        this.items.add(item);
    }

    /**
     * 出队方法
     * @return 返回出队元素
     * 返回值类型用占位符 T表示，注意要与 Queue<T>中的占位符保持一致。
     */
    public T dequeue() {
        // 先判断集合是否有元素
        if (items.isEmpty()) {
            return null;
        } else {
            // 删除队列的第一个元素，并把删除的元素返回，以达到出队的目的
            return this.items.remove(0);
        }
    }

    @Override
    public String toString() {
        return items.toString();
    }
}