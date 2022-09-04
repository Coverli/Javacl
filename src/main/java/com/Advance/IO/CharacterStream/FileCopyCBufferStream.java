package com.Advance.IO.CharacterStream;

import java.io.*;

/** 字符缓冲流使用案例：文件复制 */
public class FileCopyCBufferStream {
    /**
        BufferedReader和BufferedWriter称为字符缓冲流。
        BufferedReader特有方法和构造方法有：
            String readLine()：读取一个文本行，如果因为已经到达流末尾，则返回值null。
            BufferedReader(Reader in)：构造方法，通过一个底层输入流in对象创建缓冲流对象，缓冲区大小是默认的，默认值8192。
            BufferedReader(Reader in, int size)：构造方法，通过一个底层输入流in对象创建缓冲流对象，
                size指定的缓冲区大小，缓冲区大小应该是2的n次幂，这样可提高缓冲区的利用率。

        BufferedWriter特有方法和构造方法主要有：
            void newLine()：写入一个换行符。
            BufferedWriter(Writerout)：构造方法，通过一个底层输出流out 对象创建缓冲流对象，缓冲区大小是默认的，默认值8192。
            BufferedWriter(Writerout, int size)：构造方法，通过一个底层输出流out对象创建缓冲流对象，
                size指定的缓冲区大小，缓冲区大小应该是2的n次幂，这样可提高缓冲区的利用率。
     */

    public static void main(String[] args) {
        try (FileReader fis = new FileReader(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\Hello.html");
             BufferedReader bis = new BufferedReader(fis);
             FileWriter fos = new FileWriter(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\subDir\\Hello.html");
             BufferedWriter bos = new BufferedWriter(fos)) {

            // 首先读取一行文本，当读取是文本为null时说明流已经读完了
            String line = bis.readLine();

            while (line != null) {
                // 开始写入数据
                bos.write(line);

                // 由于在输入流的readLine方法会丢掉一个换行符或回车符，为了保持复制结果完全一样，
                // 因此需要在写完一个文本后，调用输出流的newLine方法写入一个换行符。
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
