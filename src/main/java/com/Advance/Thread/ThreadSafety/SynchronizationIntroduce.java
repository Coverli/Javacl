package com.Advance.Thread.ThreadSafety;

/**
 * 多线程同步
 * */
public class SynchronizationIntroduce {
    /**
        为了防止多线程对临界资源的访问有时会导致数据的不一致性，Java提供了“互斥”机制，
        可以为这些资源对象加上一把“互斥锁”，在任一时刻只能由一个线程访问，
        即使该线程出现阻塞，该对象的被锁定状态也不会解除，其他线程仍不能访问该对象，
        这就多线程同步。线程同步保证线程安全的重要手段，但是线程同步客观上会导致性能下降。

        可以通过两种方式实现线程同步，两种方式都涉及到使用synchronized关键字，
        一种是synchronized方法，使用synchronized关键字修饰方法，对方法进行同步；
        另一种是synchronized语句，使用synchronized关键字放在对象前面限制一段代码的执行。
     */
}
