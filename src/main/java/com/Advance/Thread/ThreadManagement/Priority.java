package com.Advance.Thread.ThreadManagement;

/**
 * 线程优先级
 * */
public class Priority {
    /**
        线程的调度程序根据线程决定每次线程应当何时运行，Java提供了10种优先级，分别用1~10整数表示，
        最高优先级是10用常量MAX_PRIORITY表示；
        最低优先级是1用常量MIN_PRIORITY；
        默认优先级是5用常量NORM_PRIORITY表示。
        Thread类提供了setPriority(int newPriority)方法可以设置线程优先级，
        通过getPriority()方法获得线程优先级
     */
    public static void main (String[] args) {
        // 创建线程t1，参数是一个线程执行对象Runner
        Thread t1 = new Thread(new Runner());
        t1.setPriority(Thread.MAX_PRIORITY);
        // 开始线程t1
        t1.start();

        // 创建线程t2，参数是一个线程执行对象Runner
        Thread t2 = new Thread(new Runner(), "MyThread");
        t2.setPriority(Thread.MIN_PRIORITY);
        // 开始线程t2
        t2.start();

        // 获取程优先级
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
    }
}
