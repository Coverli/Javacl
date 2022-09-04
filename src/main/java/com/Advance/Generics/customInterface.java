package com.Advance.Generics;

import java.util.ArrayList;
import java.util.List;

// 自定义泛型接口是使用
// 要注意实现泛型接口的具体类也应该支持泛型，所以customInterface<T>中参数名要和IQueue<T>一致
public class customInterface<T> implements IQueue<T> {
    // 自定义泛型接口与自定义泛型类类似，定义的方式完全一样
    // 实现接口IQueue<T>具体方式有很多，可以是List、Set或Hash等多种不同方式

    // 声明保存队列元素集合items
    private List<T> items;

    // 构造方法初始化是集合items
    public customInterface() {
        this.items = new ArrayList<T>();
    }

    /**
     * 入队方法
     * @param item
     * 参数需要入队的元素
     */
    @Override
    public void queue(T item) {
        this.items.add(item);
    }

    /**
     * 出队方法
     * @return 返回出队元素
     */
    @Override
    public T dequeue() {
        if (items.isEmpty()) {
            return null;
        } else {
            return this.items.remove(0);
        }
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
