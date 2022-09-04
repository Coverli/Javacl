package com.Advance.Network.DataFormatExchange.Caht;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {

        System.out.println("服务器运行...");

        Thread t = new Thread(() -> {
            try ( // 创建一个ServerSocket监听端口8080客户请求
                  ServerSocket server = new ServerSocket(8080);
                  // 使用accept()阻塞等待客户端请求
                  Socket socket = server.accept();
                  DataInputStream in = new DataInputStream(socket.getInputStream());
                  DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                  BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

                while (true) {
                    /* 接收数据 */
                    String str = in.readUTF();
                    // JSON解码，对从客户端返回的字符串进行解码，并返回JSON对象
                    JSONObject jsonObject = new JSONObject(str);
                    // 打印接收的数据
                    System.out.printf("从客户端接收的数据：%s\n", jsonObject);

                    /* 发送数据 */
                    // 读取键盘输入的字符串
                    String keyboardInputString = keyboardIn.readLine();
                    // 结束聊天
                    if (keyboardInputString.equals("bye")) {
                        break;
                    }

                    // 编码，船检新的JSON对象，并添加JSON对象
                    jsonObject = new JSONObject();
                    jsonObject.put("message", keyboardInputString);
                    jsonObject.put("userid", "acid");
                    jsonObject.put("username", "赵1");

                    // 发送
                    out.writeUTF(jsonObject.toString());
                    out.flush();
                }
            } catch (Exception e) {
            }
            System.out.println("服务器停止...");
        });
        t.start();
    }
}
