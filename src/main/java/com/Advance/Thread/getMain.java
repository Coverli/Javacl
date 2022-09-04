package com.Advance.Thread;

/**
 * 获取主线程
 * */
public class getMain {
    /*
        Java程序至少会有一个线程，这就是主线程，程序启动后是由JVM创建主线程，
        程序结束时由JVM停止主线程。主线程它负责管理子线程，即子线程的启动、挂起、停止等等操作。
        其中主线程负责管理子线程，即子线程的启动、挂起、停止等操作。
    */

    public static void main(String[] args) {
        // Thread.currentThread()获得当前线程
        Thread mainThread = Thread.currentThread();
        System.out.println("主线程名：" + mainThread.getName());
    }
}
