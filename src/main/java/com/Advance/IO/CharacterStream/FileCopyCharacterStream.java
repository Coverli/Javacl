package com.Advance.IO.CharacterStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流使用案例：文件复制
 */
public class FileCopyCharacterStream {
    /**
        Reader是字符输入流的根类，它定义了很多方法，影响着字符输入流的行为
        Reader主要方法如下：
            int read()：读取一个字符，返回值范围在0~65535(0x00~0xffff)之间。如果因为已经到达流末尾，则返回值-1。
            int read(char[] cbuf)：将字符读入到数组cbuf中，返回值为实际读取的字符的数量，如果因为已经到达流末尾，则返回值-1。
            int read(char[] cbuf, int off, int len)：最多读取len个字符，数据放到以下标off开始字符数组cbuf中，
                将读取的第一个字符存储在元素cbuf[off]中，下一个存储在cbuf[off+1]中，依次类推。
                返回值为实际读取的字符的数量，如果因为已经到达流末尾，则返回值-1。
            void close()：流操作完毕后必须关闭。
        上述所有方法都声明了抛出IOException，因此使用时要注意处理异常。

        Writer是字符输出流的根类，它定义了很多方法，影响着字符输出流的行为
        Writer主要方法如下：
            void write(int c)：将整数值为c的字符写入到输出流，c是int类型占有32位，
                写入过程是写入c的16个低位，c的16个高位将被忽略。
            void write(char[] cbuf)：将字符数组cbuf写入到输出流。
            void write(char[] cbuf, int off, int len)：把字符数组cbuf中从下标off开始，长度为len的字符写入到输出流。
            void write(String str)：将字符串str中的字符写入输出流。
            void write(String str,int off,int len)：将字符串str中从索引off开始处的len个字符写入输出流。
            void flush()：刷空输出流，并输出所有被缓存的字符。由于某些流支持缓存功能，该方法将把缓存中所有内容强制输出到流中。
            void close( )：流操作完毕后必须关闭。
        上述所有方法都可以会抛出IOException，因此使用时要注意处理异常。

        注意 Reader和Writer都实现了AutoCloseable接口，可以使用自动资源管理技术自动关闭它们。
     */

    /**
        通过一个案例熟悉一下它们的使用，该案例实现了文件复制，数据源是文件，
        所以会用到文件输入流FileReader，数据目的地也是文件，所以会用到文件输出流FileWriter。

        FileReader和FileWriter中主要方法都是继承自Reader和Writer。下面介绍一下它们的构造方法，
        FileReader构造方法主要有：
            FileReader(String fileName)：创建FileReader对象，fileName是文件名。
                如果文件不存在则抛出FileNotFoundException异常。
            FileReader(File file)：通过File对象创建FileReader对象。
                如果文件不存在则抛出FileNotFoundException异常。

        FileWriter构造方法主要有：
            FileWriter(String fileName)：通过指定fileName文件名创建FileWriter对象。
                如果fileName文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
            FileWriter(String fileName, boolean append)：通过指定fileName文件名创建FileWriter对象，
                append参数如果为 true，则将字符写入文件末尾处，而不是写入文件开始处。如果fileName文件存在，
                但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
            FileWriter(File file)：通过File对象创建FileWriter对象。如果file文件存在，
                但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
            FileWriter(File file, boolean append)：通过File对象创建FileWriter对象，
                append参数如果为 true，则将字符写入文件末尾处，而不是写入文件开始处。如果file文件存在，
                但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

        注意！！！字符文件流只能复制文本文件，不能是二进制文件
     */

    public static void main(String[] args) {

        try (FileReader in = new FileReader(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\build.txt");
             FileWriter out = new FileWriter(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\subDir\\build.txt")) {

            // 准备一个缓冲区
            char[] buffer = new char[10];
            // 首先读取一次
            int len = in.read(buffer);

            while (len != -1) {
                String copyStr = new String(buffer);
                // 打印复制的字符串
                System.out.println(copyStr);
                // 开始写入数据
                out.write(buffer, 0, len);
                // 再读取一次
                len = in.read(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
