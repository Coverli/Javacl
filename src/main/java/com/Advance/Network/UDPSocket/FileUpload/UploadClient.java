package com.Advance.Network.UDPSocket.FileUpload;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UploadClient {
    public static void main(String[] args) {

        System.out.println("客户端运行...");

        // 发送数据不会堵塞线程，因此没有使用子线程
        try ( // 创建DatagramSocket对象，由系统分配可以使用的端口，作为客户端DatagramSocket对象经常自己不指定了，而是有系统分配
              DatagramSocket socket = new DatagramSocket();
              FileInputStream fin = new FileInputStream(".\\src\\main\\java\\com\\Advance\\Network\\UDPSocket\\FileUpload\\Client\\1.jpg");
              BufferedInputStream in = new BufferedInputStream(fin)) {

            // 创建远程主机IP地址对象
            InetAddress address = InetAddress.getByName("localhost");

            // 准备一个缓冲区
            byte[] buffer = new byte[1024];
            // 首次从文件流中读取数据
            int len = in.read(buffer);

            while (len != -1) {
                // 创建数据报包对象
                DatagramPacket packet = new DatagramPacket(buffer, len, address, 8080);
                // 发送数据报包
                socket.send(packet);
                // 再次从文件流中读取数据
                len = in.read(buffer);
            }

            // 创建数据报对象
            DatagramPacket packet = new DatagramPacket("bye".getBytes(), 3, address, 8080);
            // 发送结束标志，这个结束标志是字符串bye，服务器端接收到这个字符串则结束接收数据包
            socket.send(packet);
            System.out.println("上传完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
