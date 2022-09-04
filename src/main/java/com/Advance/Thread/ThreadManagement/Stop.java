package com.Advance.Thread.ThreadManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 线程停止
 * */
public class Stop {
    /**
        线程体中的run()方法结束，线程进入死亡状态，线程就停止了。但是有些业务比较复杂，
        例如想开发一个下载程序，每隔一段执行一次下载任务，下载任务一般会在由子线程执行的，
        休眠一段时间再执行。这个下载子线程中会有一个死循环，但是为了能够停止子线程，设置一个结束变量。
     */

    private static String command = "";

    public static void main(String[] args) {
        // 创建线程t1，参数是一个线程执行对象Runner
        Thread t1 = new Thread(() -> {
            // 一直循环，直到用户输入exit字符串再停止线程
            while (!command.equalsIgnoreCase("exit")) {
                // 线程开始工作
                // TODO
                System.out.println("下载中...");
                try {
                    // 线程休眠
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
            // 线程执行结束
            System.out.println("执行完成!");
        });
        // 开始线程t1
        t1.start();
        try (InputStreamReader ir = new InputStreamReader(System.in);
             BufferedReader in = new BufferedReader(ir)) {
            // 从键盘接收了一个字符串的输入，输入exit并回车即可结束线程
            command = in.readLine();
        } catch (IOException e) {
        }

        /**
            提示：控制线程的停止有人会想到使用Thread提供的stop()方法，这个方法已经不推荐使用了，
                这个方法有时会引发严重的系统故障，类似还是有suspend()和resume()挂起方法。
                Java现在推荐的做法就是采用以上方法的结束变量方式。
         */
    }
}
