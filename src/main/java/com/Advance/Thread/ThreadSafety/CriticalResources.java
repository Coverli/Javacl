package com.Advance.Thread.ThreadSafety;

/**
 * 临界资源问题
 * */
public class CriticalResources {
    /**
        多一个线程同时运行，有时线程之间需要共享数据，
        一个线程需要其他线程的数据，否则就不能保证程序运行结果的正确性。
     */

    /**
        例如有一个航空公司的机票销售，每一天机票数量是有限的，很多售票点同时销售这些机票
        下面是一个模拟销售机票系统
        在运行结果中，虽然可以能每次运行的结果都不一样，但是从结果看还是能发现一些问题：
        同一张票重复销售、出现。这些问题的根本原因是多个线程间共享的数据导致数据的不一致性。

        提示：多个线程间共享的数据称为共享资源或临界资源，由于是CPU负责线程的调度，
            程序员无法精确控制多线程的交替顺序。这种情况下，多线程对临界资源的访问有时会导致数据的不一致性
     */
    public static void main(String[] args) {
        TicketDB db = new TicketDB();

        // 创建线程t1
        Thread t1 = new Thread(() -> {
            while (true) {
                int currTicketCount = db.getTicketCount();
                // 查询是否有票
                if (currTicketCount > 0) {
                    db.sellTicket();
                } else {
                    // 无票退出
                    break;
                }
            }
        });
        // 开始线程t1
        t1.start();

        // 创建线程t2
        Thread t2 = new Thread(() -> {
            while (true) {
                int currTicketCount = db.getTicketCount();
                // 查询是否有票
                if (currTicketCount > 0) {
                    db.sellTicket();
                } else {
                    // 无票退出
                    break;
                }
            }
        });
        // 开始线程t2
        t2.start();
    }
}

class TicketDB {
    // 机票的数量
    private int ticketCount = 5;

    // 获得当前机票数量
    public int getTicketCount() {
        return ticketCount;
    }

    // 销售机票
    public void sellTicket() {
        try {
            // 线程休眠，阻塞当前线程，模拟等待用户付款
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.printf("第%d号票,已经售出\n", ticketCount);
        ticketCount--;
    }
}