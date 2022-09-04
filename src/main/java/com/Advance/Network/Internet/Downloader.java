package com.Advance.Network.Internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 案例：下载器
 * */
public class Downloader {
    // Web服务网址
    private static String urlString = "https://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fimg.jj20.com%252Fup%252Fallimg%252F811%252F041914135038%252F140419135038-3-1200.jpg%26refer%3Dhttp%253A%252F%252Fimg.jj20.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Dauto%3Fsec%3D1664717446%26t%3D207688862f58802746eb9e7cb3331c42&thumburl=https%3A%2F%2Fimg0.baidu.com%2Fit%2Fu%3D707084994%2C2531626623%26fm%3D253%26fmt%3Dauto%26app%3D138%26f%3DJPEG%3Fw%3D889%26h%3D500";

    public static void main(String[] args) {
        download();
    }

    // 下载方法
    private static void download() {
        HttpURLConnection conn = null;
        try {
            // 创建URL对象
            URL reqURL = new URL(urlString);
            // 打开连接
            conn = (HttpURLConnection) reqURL.openConnection();
            try (// 从连接对象获得输入流
                 InputStream is = conn.getInputStream();
                 // 创建缓冲流输入流，使用缓冲流可以提高读写效率
                 BufferedInputStream bin = new BufferedInputStream(is);
                 // 创建文件输出流
                 OutputStream os = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\Network\\Internet\\Downloader\\1.jpeg");
                 // 创建缓冲流输出流
                 BufferedOutputStream bout = new BufferedOutputStream(os);) {

                byte[] buffer = new byte[1024];
                int bytesRead = bin.read(buffer);
                while (bytesRead != -1) {
                    bout.write(buffer, 0, bytesRead);
                    bytesRead = bin.read(buffer);
                }
            } catch (IOException e) {
            }
            System.out.println("下载完成。");
        } catch (IOException e) {
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
