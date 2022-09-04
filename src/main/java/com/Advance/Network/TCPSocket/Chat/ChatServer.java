package com.Advance.Network.TCPSocket.Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * */
public class ChatServer {
    public static void main(String[] args) {

        System.out.println("服务器运行...");

        // 创建一个子线程，将网络通信放到子线程中处理是一种很好的做法，
        // 因为网络通信往往有线程阻塞过程，放到子线程中处理就不会阻塞主线程了
        Thread t = new Thread(() -> {
            try (// 创建一个ServerSocket监听端口8080客户请求
                 ServerSocket server = new ServerSocket(8080);
                 // 使用accept()阻塞等待客户端请求
                 Socket socket = server.accept();
                 // 从socket中获得数据输入流
                 DataInputStream in = new DataInputStream(socket.getInputStream());
                 // 从socket中获得数据输出流，数据流主要面向基本数据类型，这里使用它们主要用来输入输出UTF编码的字符串
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                 // System.in是标准输入流，然后使用标准输入流创建缓冲输入流
                 BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

                while (true) {
                    /* 接收数据 */
                    // readUTF()是数据输入流读取字符串
                    String str = in.readUTF();
                    // 打印接收的数据
                    System.out.printf("从客户端接收的数据：【%s】\n", str);

                    /* 发送数据 */
                    // 读取键盘输入的字符串
                    String keyboardInputString = keyboardIn.readLine();
                    // 结束聊天
                    if (keyboardInputString.equals("bye")) {
                        break;
                    }

                    // 发送，行writeUTF()是数据输出流写入字符串
                    out.writeUTF(keyboardInputString);
                    out.flush();
                }
            } catch (Exception e) {
            }

            System.out.println("服务器停止...");
        });
        t.start();
    }
}