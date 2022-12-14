package com.Advance.Network.DataFormatExchange.Caht;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {

        System.out.println("客户端运行...");

        Thread t = new Thread(() -> {
            try ( // 向127.0.0.1主机8080端口发出连接请求
                  Socket socket = new Socket("127.0.0.1", 8080);
                  DataInputStream in = new DataInputStream(socket.getInputStream());
                  DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                  BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

                while (true) {
                    /* 发送数据 */
                    // 读取键盘输入的字符串
                    String keyboardInputString = keyboardIn.readLine();
                    // 结束聊天
                    if (keyboardInputString.equals("bye")) {
                        break;
                    }

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("message", keyboardInputString);
                    jsonObject.put("userid", "javaee");
                    jsonObject.put("username", "关东升");

                    // 发送
                    out.writeUTF(jsonObject.toString());
                    out.flush();

                    /* 接收数据 */
                    String str = in.readUTF();
                    jsonObject = new JSONObject(str);
                    // 打印接收的数据
                    System.out.printf("从服务器接收的数据：%s \n", str);
                }
            } catch (ConnectException e) {
                System.out.println("服务器未启动！");
            } catch (Exception e) {
            }
            System.out.println("客户端停止！");
        });
        t.start();
    }
}
