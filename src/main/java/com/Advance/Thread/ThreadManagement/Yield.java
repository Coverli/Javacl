package com.Advance.Thread.ThreadManagement;

/**
 * 线程让步
 * */
public class Yield implements Runnable {
    /**
        线程类Thread还提供一个静态方法yield()，调用yield()方法能够使当前线程给其他线程让步。
        它类似于sleep()方法，能够使运行状态的线程放弃CPU使用权，暂停片刻，然后重新回到就绪状态。
        与sleep()方法不同的是，sleep()方法是线程进行休眠，能够给其他线程运行的机会，
        无论线程优先级高低都有机会运行。而yield()方法只给相同优先级或更高优先级线程机会。

        提示：yield()方法只能给相同优先级或更高优先级的线程让步，yield()方法在实际开发中很少使用，
            大多都使用sleep()方法，sleep()方法可以控制时间，而yield()方法不能
     */

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 打印次数和线程的名字
            System.out.printf("第 %d次执行 - %s\n", i,
            Thread.currentThread().getName());
            Thread.yield();
        }
        // 线程执行结束
        System.out.println("执行完成! " + Thread.currentThread().getName());
    }
}
