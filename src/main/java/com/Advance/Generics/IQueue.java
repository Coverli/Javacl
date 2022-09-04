package com.Advance.Generics;

/**
 * 自定义的泛型队列集合
 */
// 定义了IQueue<T>泛型接口，T是参数类型占位符。
public interface IQueue<T> {
    /**
     * 入队方法
     * @param item 参数需要入队的元素
     */
    public void queue(T item);

    /**
     * 出队方法
     * @return 返回出队元素
     */
    public T dequeue();
}
