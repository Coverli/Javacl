package com.Advance.Network.Internet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用HttpURLConnection发送POST请求
 * */
public class post {
    // 本例子中所使用的地址不允许以POST方式提交，所以运行时会产生Exception，返回HTTP状态码405

    static String urlString = "https://so.csdn.net/so/search";
    public static void main(String[] args) {
        BufferedReader br = null;
        HttpURLConnection conn = null;

        try {
            URL reqURL = new URL(urlString);
            conn = (HttpURLConnection) reqURL.openConnection();
            conn.setRequestMethod("POST");
            // conn.setDoOutput(true)是设置请求过程可以传递参数给服务器
            conn.setDoOutput(true);

            String param = "q=java&t=blog";

            /**
                设置参数，将请求参数发送给服务器
                conn.getOutputStream()是打开输出流，
                new DataOutputStream(conn.getOutputStream())是创建基于数据输出流
                dStream.writeBytes(param)是向输出流中写入数据
                dStream.close()是关闭流，并将数据写入到服务器端
             */
            DataOutputStream dStream = new DataOutputStream(conn.getOutputStream());
            dStream.writeBytes(param);
            dStream.close();

            // 打开网络通信输入流
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
