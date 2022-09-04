package com.Advance.Thread.ThreadSafety;

/**
 * Synchronized方法
 * */
public class SynchronizedMethod {
    /**
        synchronized关键字修饰方法实现线程同步，方法所在的对象被锁定
     */

    public static void main(String[] args) {
        TicketDB1 db = new TicketDB1();

        Thread t1 = new Thread(() -> {
            while (true) {
                int currTicketCount = db.getTicketCount();
                if (currTicketCount > 0) {
                    db.sellTicket();
                } else {
                    break;
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                int currTicketCount = db.getTicketCount();
                if (currTicketCount > 0) {
                    db.sellTicket();
                } else {
                    break;
                }
            }
        });
        t2.start();
    }
}

class TicketDB1 {
    private int ticketCount = 5;

    public synchronized int getTicketCount() {
        return ticketCount;
    }

    public synchronized void sellTicket() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.printf("第%d号票,已经售出\n", ticketCount);
        ticketCount--;
    }

    /**
        public synchronized int getTicketCount()和public synchronized void sellTicket()
        两个方法都使用了synchronized关键字，表明这两个方法是同步的，
        被锁定的，每一个时刻只能由一个线程访问。并不是每一个方法都有必要加锁的，要仔细研究加上的必要性

        public synchronized int getTicketCount()加锁可以防止出现第0号票情况和5张票卖出6次的情况
        public synchronized void sellTicket()加锁是防止出现销售两种一样的票
     */
}
