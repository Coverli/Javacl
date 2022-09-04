package com.Advance.Network.TCPSocket.FileUpload;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * */
public class UploadServer {
    public static void main(String[] args) {
        System.out.println("服务器端运行...");

        try (// 创建一个ServerSocket监听8080端口的客户端请求
             ServerSocket server = new ServerSocket(8080);
             // 使用accept()阻塞当前线程，等待客户端请求。如果不进行阻塞，ServerSocket对象监听的是本机8080端口
             /**
                提示：由于当前线程是主线程，所以server.accept()会阻塞主线程，阻塞主线程是不明智的，
                    如果是在一个图形界面的应用程序，阻塞主线程会导致无法进行任何的界面操作，就是常见的“卡”现象，
                    所以最好是把server.accept()语句放到子线程中。
              */
             Socket socket = server.accept();
             // 由Socket获得输入流，并创建缓冲输入流
             BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
             // 由文件输出流创建缓冲输出流
             FileOutputStream out = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\Network\\TCPSocket\\FileUpload\\Server\\1.jpg")) {

            // 准备一个缓冲区
            byte[] buffer = new byte[1024];
            // 首次从Socket读取数据
            int len = in.read(buffer);
            while (len != -1) {
                // 写入数据到文件
                out.write(buffer, 0, len);
                // 再次从Socket读取数据
                len = in.read(buffer);
            }
            System.out.println("接收完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
