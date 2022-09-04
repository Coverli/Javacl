package com.Advance.Network.UDPSocket.FileUpload;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UploadServer {
    public static void main(String args[]) {

        System.out.println("服务器端运行...");

        // 创建一个子线程
        Thread t = new Thread(() -> {
            try ( // 创建DatagramSocket对象，指定端口8080，作为服务器一般应该明确指定绑定的端口
                  DatagramSocket socket = new DatagramSocket(8080);
                  FileOutputStream fout = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\Network\\UDPSocket\\FileUpload\\Client\\1.jpg");
                  BufferedOutputStream out = new BufferedOutputStream(fout)) {

                // 准备一个缓冲区
                byte[] buffer = new byte[1024];

                // 由于客户端上传的数据分为很多数据包，因此需要一个循环接收数据包
                while (true) {
                    // 创建数据报包对象，用来接收数据
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    // 接收数据报包，调用receive()方法后会导致线程阻塞，因此需要将接收数据的处理放到一个子线程中
                    socket.receive(packet);
                    // 接收数据长度
                    int len = packet.getLength();

                    if (len == 3) {
                        // 获得结束标志
                        /**
                            与TCP Socket不同UDP Socket无法知道哪些数据包已经是最后一个了，
                            因此需要发送方发出一个特殊的数据包，包中包含了一些特殊标志，
                            当服务器接收到客户端发送bye字符串后结束循环接收数据包
                         */
                        String flag = new String(buffer, 0, 3);
                        // 判断结束标志，如果是bye结束接收
                        if (flag.equals("bye")) {
                            break;
                        }
                    }
                    // 写入数据到文件输出流
                    out.write(buffer, 0, len);
                }
                System.out.println("接收完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // 启动线程
        t.start();
    }
}
