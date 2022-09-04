package com.Advance.Thread.ThreadManagement;

public class Runner implements Runnable {
    /**
        Java中创建一个子线程涉及到：java.lang.Thread类和java.lang.Runnable接口。
        Thread是线程类，创建一个Thread对象就会产生一个新的线程。
        而线程执行的程序代码是在实现Runnable接口对象的run()方法中编写的，实现Runnable接口对象是线程执行对象。

        线程执行对象实现Runnable接口的run()方法，run()方法是线程执行的入口，
        该线程要执行程序代码都在此编写的，run()方法称为线程体。

        提示：主线程中执行入口是main(String[] args)方法，这里可以控制程序的流程，管理其他的子线程等。
            子线程执行入口是线程执行对象（实现Runnable接口对象）的run()方法，在这个方法可以编写子线程相关处理代码。

        创建线程Thread对象时，可以将线程执行对象传递给它，这需要是使用Thread类如下两个构造方法：
            Thread(Runnable target, String name)：target是线程执行对象，实现Runnable接口。name为线程指定一个名字。
            Thread(Runnable target)：target是线程执行对象，实现Runnable接口。线程名字是由JVM分配的。
     */

    /** 编写执行线程代码，run()是线程体，在该方法中编写你自己的线程处理代码 */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 打印次数和线程的名字，Thread.currentThread()可以获得当前线程对象
            System.out.printf("第 %d次执行 - %s\n", i, Thread.currentThread().getName());
            try {
                // 随机生成休眠时间
                long sleepTime = (long) (1000 * Math.random());
                /**
                    Thread.sleep(sleepTime)是休眠当前线程, sleep是静态方法它有两个版本：
                        static void sleep(long millis)：在指定的毫秒数内让当前正在执行的线程休眠。
                        static void sleep(long millis, int nanos) 在指定的毫秒数加指定的纳秒数内让当前正在执行的线程休眠。
                 */
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        // 线程执行结束
        System.out.println("执行完成! " + Thread.currentThread().getName());
    }
}