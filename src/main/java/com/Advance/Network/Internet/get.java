package com.Advance.Network.Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用HttpURLConnection发送GET请求
 * */
public class get {
    // 由于URL类只能发送HTTP/HTTPS的GET方法请求，如果要想发送其他的情况或者对网络请求有更深入的控制时，
    // 可以使用HttpURLConnection类型

    /**
        Web服务网址
        提示：发送GET请求时发送给服务器的参数是放在URL的“?”之后，参数采用键值对形式，
        例如：URL中q=java是一个参数，t是参数名，java是参数名，服务器端会根据参数名获得参数值。
        多个参数之间用“&”分隔，例如q=java&t=blog就是两个参数。
     */
    static String urlString = "https://so.csdn.net/so/search?q=java&t=blog";
    public static void main(String[] args) {
        BufferedReader br = null;
        HttpURLConnection conn = null;

        try {
            URL reqURL = new URL(urlString);
            /**
                用reqURL.openConnection()方法打开一个连接，返回URLConnection对象，
                由于本次连接是HTTP连接，所以返回的是HttpURLConnection对象。
                URLConnection是抽象类，HttpURLConnection是URLConnection的子类。
             */
            conn = (HttpURLConnection) reqURL.openConnection();
            // conn.setRequestMethod("GET")是设置请求方法为GET方法
            conn.setRequestMethod("GET");

            // 打开网络通信输入流，通过conn.getInputStream()打开输入流
            InputStream is = conn.getInputStream();
            // 通过is创建InputStreamReader对象
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            // 通过isr创建BufferedReader对象
            br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            // 日志输出
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                // conn.disconnect()是断开连接，这可以释放资源
                conn.disconnect();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
