package com.Advance.Thread.ChildThread;

/**
 * 使用匿名内部类和Lambda表达式实现线程体
 * */
public class InnerLambda {
    public static void main (String[] args) {
        // 创建线程t1，参数是实现Runnable接口的匿名内部类，使用的是Thread(Runnable target)构造方法
        Thread t1 = new Thread(new Runnable() {
            // 编写执行线程代码
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 打印次数和线程的名字
                    System.out.printf("第 %d次执行 - %s\n", i, Thread.currentThread().getName());
                    try {
                        // 随机生成休眠时间
                        long sleepTime = (long) (1000 * Math.random());
                        // 线程休眠
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                    }
                }
            // 线程执行结束
            System.out.println("执行完成! " + Thread.currentThread().getName());
        }
    });
    // 开始线程t1
    t1.start();

    // 创建线程t2，参数是实现Runnable接口的Lambda表达式，使用的是Thread(Runnable target, String name)构造方法
    Thread t2 = new Thread(() -> {
        for (int i = 0; i < 10; i++) {
        // 打印次数和线程的名字
            System.out.printf("第 %d次执行 - %s\n", i, Thread.currentThread().getName());
            try {
                // 随机生成休眠时间
                long sleepTime = (long) (1000 * Math.random());
                // 线程休眠
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        // 线程执行结束
        System.out.println("执行完成! " + Thread.currentThread().getName());
        }, "MyThread");
    // 开始线程t2
    t2.start();
    }

    /**
        提示：匿名内部类和Lambda表达式不需要定义一个线程类文件，使用起来很方便。
            特别是Lambda表达式使代码变得非常简洁。但是客观上匿名内部类和Lambda表达式会使代码可读性变差
     */
}
