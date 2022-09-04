package com.Advance.IO.CharacterStream;

import java.io.*;

/**
 * 字节流转换字符流
 * */
public class ByteTransformCharacter {
    /**
        有时需要将字节流转换为字符流，InputStreamReader和OutputStreamWriter是为实现这种转换而设计的。
        InputStreamReader构造方法如下：
            InputStreamReader(InputStream in)：将字节流in转换为字符流对象，字符流使用默认字符集。
            InputStreamReader(InputStream in, String charsetName)：将字节流in转换为字符流对象，
                charsetName指定字符流的字符集，字符集主要有：US-ASCII、ISO-8859-1、UTF-8和UTF-16。
                如果指定的字符集不支持会抛出UnsupportedEncodingException异常。
        OutputStreamWriter构造方法如下：
            OutputStreamWriter(OutputStream out)：将字节流out转换为字符流对象，字符流使用默认字符集。
            OutputStreamWriter(OutputStream out,String charsetName)：将字节流out转换为字符流对象，
                charsetName指定字符流的字符集，如果指定的字符集不支持会抛出UnsupportedEncodingException异常。
     */

    public static void main(String[] args) {
        try ( // 创建字节文件输入流对象
              FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\Hello.html");
              // 创建转换流对象
              InputStreamReader isr = new InputStreamReader(fis);
              // 创建字符缓冲输入流对象
              BufferedReader bis = new BufferedReader(isr);

              // 创建字节文件输出流对象
              FileOutputStream fos = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\subDir\\Hello.html");
              // 创建转换流对象
              OutputStreamWriter osw = new OutputStreamWriter(fos);
              // 创建字符缓冲输出流对象
              BufferedWriter bos = new BufferedWriter(osw)) {

            // 首先读取一行文本
            String line = bis.readLine();

            while (line != null) {
            // 开始写入数据
            bos.write(line);
            // 写一个换行符
            bos.newLine();
            // 再读取一行文本
            line = bis.readLine();
        }
            System.out.println("复制完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
