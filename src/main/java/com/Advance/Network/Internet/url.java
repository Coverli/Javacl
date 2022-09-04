package com.Advance.Network.Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL类
 * */
public class url {
    /**
        Java 的java.net.URL类用于请求互联网上的资源，采用HTTP/HTTPS协议，请求方法是GET方法，
        一般是请求静态的、少量的服务器端数据。
        URL类常用构造方法：
            URL(String spec)：根据字符串表示形式创建URL对象。
            URL(String protocol, String host, String file)：根据指定的协议名、主机名和文件名称创建URL对象。
            URL(String protocol, String host, int port, String file)：根据指定的协议名、主机名、端口号
                和文件名称创建URL对象。
        URL类常用方法：
            InputStream openStream()：打开到此URL的连接，并返回一个输入流。
            URLConnection openConnection()：打开到此URL的新连接，返回一个URLConnection对象。
     */

    public static void main(String[] args) {
        // Web网址
        String url = "https://github.com/Coverli";
        URL reqURL;
        try {
            // 创建URL对象，参数是一个HTTP网址
            reqURL = new URL(url);
            } catch (MalformedURLException e1) {
            return;
        }
        try ( // 打开网络通信输入流，通过URL对象的openStream()方法打开输入流
              InputStream is = reqURL.openStream();
              InputStreamReader isr = new InputStreamReader(is, "utf-8");
              BufferedReader br = new BufferedReader(isr)) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }

            // 日志输出
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
