package com.Advance.Thread;

/**
 * 线程间通信
 * */
public class Communication {
    /**
        如果两个线程之间有依赖关系，线程之间必须进行通信，互相协调才能完成工作。
        例如有一个经典的堆栈问题，一个线程生成了一些数据，将数据压栈；
        另一个线程消费了这些数据，将数据出栈。这两个线程互相依赖，
        当堆栈为空时，消费线程无法取出数据时，应该通知生成线程添加数据；
        当堆栈已满时，生产线程无法添加数据时，应该通知消费线程取出数据。

        为了实现线程间通信，需要使用Object类中声明的5个方法：
            void wait()：使当前线程释放对象锁，然后当前线程处于对象等待队列中阻塞状态，如下图所示，等待其他线程唤醒。
            void wait(long timeout)：同wait()方法，等待timeout毫秒时间。
            void wait(long timeout, int nanos)：同wait()方法，等待timeout毫秒加nanos纳秒时间。
            void notify()：当前线程唤醒此对象等待队列中的一个线程，如图23-7所示该线程将进入就绪状态。
            void notifyAll()：当前线程唤醒此对象等待队列中的所有线程，如下图所示这些线程将进入就绪状态


                               对象等待队列中
                                【阻塞状态】
                              |            ^
                     notify() |            |
                或notifyAll() |            | wait()
                            <-|            |
             新建状态 ----> 就绪状态 <----> 运行状态 ----> 死亡状态
                           ^ ^             | |
                     ------| |             | -------
                     |   加锁 |             | 尝试   |
                     |   成功 |             | 加锁   |
                     |       -- 对象锁队列中 <--      |
      1、sleep()超时  |          【阻塞状态】          | 1、sleep()
      2、等待的线程结束 |                              | 2、join()
      3、I/O完成      |                              | 3、I/O请求
                     |                              |
                     ---------- 其他方式进入 <---------

     */

    public static void main(String args[]) {

        Stack stack = new Stack();

        // 下面的消费者和生产者所操作的是同一个堆栈对象stack
        // 生产者线程
        Thread producer = new Thread(() -> {
            char c;
            for (int i = 0; i < 10; i++) {
                // 随机产生10个字符
                c = (char) (Math.random() * 26 + 'A');
                // 把字符压栈
                stack.push(c);
                // 打印字符
                System.out.println("生产: " + c);
                try {
                    // 每产生一个字符线程就睡眠
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            char c;
            for (int i = 0; i < 10; i++) {
                // 从堆栈中读取字符
                c = stack.pop();
                // 打印字符
                System.out.println("消费: " + c);
                try {
                    // 每读取一个字符线程就睡眠
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
            }
        });

        // 启动生产者线程
        producer.start();
        // 启动消费者线程
        consumer.start();
    }
}

//堆栈类
class Stack {

    // 堆栈指针初始值为0
    private int pointer = 0;

    // 堆栈有5个字符的空间
    private char[] data = new char[5];

    // 压栈方法，加上互斥锁
    public synchronized void push(char c) {
        // 堆栈已满，不能压栈
        while (pointer == data.length) {
            try {
                // 等待，直到有数据出栈
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // 通知其他线程把数据出栈
        this.notify();

        // 数据压栈
        data[pointer] = c;

        // 指针向上移动
        pointer++;
    }

    // 出栈方法，加上互斥锁
    public synchronized char pop() {
        // 堆栈无数据，不能出栈
        while (pointer == 0) {
            try {
                // 等待其他线程把数据压栈
                this.wait();
            } catch (InterruptedException e) {
            }
        }

        // 通知其他线程把数据压栈
        this.notify();

        // 指针向下移动
        pointer--;

        // 数据出栈
        return data[pointer];
    }
}