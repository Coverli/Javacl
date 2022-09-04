package com.Advance.Thread.ThreadManagement;

/**
 * 等待线程结束
 * */
public class WaitingEnd {
    /**
        当前线程调用t1线程的join()方法，则阻塞当前线程，等待t1线程结束，
        如果t1线程结束或等待超时，则当前线程回到就绪状态。
        Thread类提供了多个版本的join()，它们定义如下：
            void join()：等待该线程结束。
            void join(long millis)：等待该线程结束的时间最长为millis毫秒。如果超时为0意味着要一直等下去
            void join(long millis, int nanos)：等待该线程结束的时间最长为millis毫秒加nanos纳秒。

        提示：使用join()方法的场景是，一个线程依赖于另外一个线程的运行结果，所以调用另一个线程的join()方法等它运行完成
     */

    // 共享变量，这个变量在子线程中修改，然后主线程访问它
    static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程 开始...");
        // 使用Lambda表达式创建线程t1，命名未ThreadA，参数是一个线程执行对象Runner
        Thread t1 = new Thread(() -> {
            System.out.println("ThreadA 开始...");
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadA 执行...");
                // 在子线程ThreadA中修改共享变量value
                value++;
            }
            System.out.println("ThreadA 结束...");
        }, "ThreadA");

        // 开始线程t1
        t1.start();
        // 主线程被阻塞，等待t1线程结束
        t1.join();
        System.out.println("value = " + value);
        System.out.println("主线程 结束...");
}
}
