package com.Advance.Network.UDPSocket.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatClient {
    public static void main(String[] args) {

        System.out.println("客户端运行...");

        // 创建一个子线程
        Thread t = new Thread(() -> {
            try ( // 创建DatagramSocket对象，由系统分配可以使用的端口
                  DatagramSocket socket = new DatagramSocket();
                  BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

                while (true) {
                    /* 发送数据 */
                    // 准备一个缓冲区
                    byte[] buffer = new byte[128];
                    // 服务器IP地址
                    InetAddress address = InetAddress.getByName("localhost");
                    // 服务器端口号
                    int port = 8080;
                    // 读取键盘输入的字符串
                    String keyboardInputString = keyboardIn.readLine();

                    // 通过键盘输入bye，可以退出循环结束线程。
                    if (keyboardInputString.equals("bye")) {
                        break;
                    }

                    // 读取键盘输入的字节数组
                    byte[] b = keyboardInputString.getBytes();
                    // 创建DatagramPacket对象
                    DatagramPacket packet = new DatagramPacket(b, b.length, address, port);
                    // 发送
                    socket.send(packet);

                    /* 接收数据报 */
                    packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    // 接收数据长度
                    int len = packet.getLength();
                    String str = new String(buffer, 0, len);
                    // 打印接收的数据
                    System.out.printf("从服务器接收的数据：【%s】\n", str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // 启动线程
        t.start();
    }
}
