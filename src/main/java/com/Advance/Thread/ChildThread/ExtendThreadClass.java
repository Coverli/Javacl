package com.Advance.Thread.ChildThread;

/**
 * 继承Thread线程类
 * */
public class ExtendThreadClass {
    /**
        事实上Thread类也实现了Runnable接口，所以Thread类也可以作为线程执行对象，这需要继承Thread类，覆盖run()方法。
     */
    public static void main (String[] args) {
        // 创建线程t1
        Thread t1 = new MyThread();
        // 开始线程t1
        t1.start();

        // 创建线程t2
        Thread t2 = new MyThread("MyThread");
        // 开始线程t2
        t2.start();

        /**
            提示：由于Java只支持单重继承，继承Thread类的方式不能再继承其他父类。
                当开发一些图形界面的应用时，需要一个类既是一个窗口（继承JFrame）又是一个线程体，
                那么只能采用实现Runnable接口方式。
         */
    }
}

//线程执行对象
class MyThread extends Thread {

    /**
        通过super调用父类Thread构造方法
        这两个Thread类构造方法：
            Thread(String name)：name为线程指定一个名字。
            Thread()：线程名字是JVM分配的。
     */
    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    /** 覆盖Thread类的run()方法，run()方法是线程体，需要线程执行的代码编写在这里 */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 打印次数和线程的名字
            System.out.printf("第 %d次执行 - %s\n", i, getName());

            try {
                // 随机生成休眠时间
                long sleepTime = (long) (1000 * Math.random());
                // 线程休眠
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        // 线程执行结束
        System.out.println("执行完成! " + getName());
    }
}