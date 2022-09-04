package com.Advance.IO.ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流使用案例：文件复制
 */
public class FileCopyByteStream {
    /**
        InputStream是字节输入流的根类，它定义了很多方法，影响着字节输入流的行为。
        InputStream主要方法如下：
            int read()：读取一个字节，返回0到255范围内的int字节值。如果已经到达流末尾，而且没有可用的字节，则返回值-1。
            int read(byte b[] )：读取多个字节，数据放到字节数组b中，返回值为实际读取的字节的数量，
                如果已经到达流末尾，而且没有可用的字节，则返回值-1。
            int read(byte b[ ], int off, int len)：最多读取len个字节，数据放到以下标off开始字节数组b中，
                将读取的第一个字节存储在元素b[off]中，下一个存储在b[off+1]中，
                依次类推。返回值为实际读取的字节的数量，如果已经到达流末尾，而且没有可用的字节，则返回值-1。
            void close()：流操作完毕后必须关闭。
            上述所有方法都可能会抛出IOException，因此使用时要注意处理异常。

        OutputStream是字节输出流的根类，它定义了很多方法，影响着字节输出流的行为。
        OutputStream主要方法如下：
            void write(int b)：将b写入到输出流，b是int类型占有32位，写入过程是写入b 的8个低位，b的24个高位将被忽略。
            void write(byte b[ ])：将b.length个字节从指定字节数组b写入到输出流。
            void write(byte b[ ], int off, int len)：把字节数组b中从下标off开始，长度为len的字节写入到输出流。
            void flush()：刷空输出流，并输出所有被缓存的字节。由于某些流支持缓存功能，该方法将把缓存中所有内容强制输出到流中。
            void close( )：流操作完毕后必须关闭。
            上述所有方法都声明抛出IOException，因此使用时要注意处理异常。

        注意：流（包括输入流和输出流）所占用的资源，不能通过JVM的垃圾收集器回收，需要程序员自己释放。
            一种方法是可以在finally代码块调用close()方法关闭流，释放流所占用的资源。
            另一种方法通过自动资源管理技术管理这些流，流（包括输入流和输出流）都实现了AutoCloseable接口，可以使用自动资源管理技术
    */

    /**
        通过一个案例熟悉一下以上方法的使用，该案例实现了文件复制，数据源是文件，
        所以会用到文件输入流FileInputStream，数据目的地也是文件，所以会用到文件输出流FileOutputStream

        FileInputStream和FileOutputStream中主要方法都是继承自InputStream和OutputStream，下面介绍一下它们的构造方法，
        FileInputStream构造方法主要有：
            FileInputStream(String name)：创建FileInputStream对象，name是文件名。
                如果文件不存在则抛出FileNotFoundException异常。
            FileInputStream(File file)：通过File对象创建FileInputStream对象。
                如果文件不存在则抛出FileNotFoundException异常。

        FileOutputStream构造方法主要有：
            FileOutputStream(String name)：通过指定name文件名创建FileOutputStream对象。
                如果name文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
            FileOutputStream(String name, boolean append)：通过指定name文件名创建FileOutputStream对象，
                append参数如果为 true，则将字节写入文件末尾处，而不是写入文件开始处。
                如果name文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
            FileOutputStream(File file)：通过File对象创建FileOutputStream对象。如果file文件存在，
                但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
            FileOutputStream(File file, boolean append)：通过File对象创建FileOutputStream对象，
                append参数如果为 true，则将字节写入文件末尾处，而不是写入文件开始处。如果file文件存在，
                但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

        提示：字符文件流只能复制文本文件，不能是二进制文件
     */

    public static void main(String[] args) {

        // 创建FileInputStream和FileOutputStream对象，这是自动资源管理的写法，不需要自己关闭流
        try (FileInputStream in = new FileInputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\build.txt");
             FileOutputStream out = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\subDir\\build.txt")) {

            // 准备一个缓冲区，它是字节数组，读取输入流的数据保存到缓冲区中，然后将缓冲区中的数据再写入到输出流中
            byte[] buffer = new byte[10];
            /**
                提示：缓冲区大小（字节数组长度）多少合适？
                    缓冲区大小决定了一次读写操作的最多字节数，缓冲区设置的很小，会进行多次读写操作才能完成。
                    所以如果当前计算机内存足够大，而不影响其它应用运行情况下，当然缓冲区是越大越好。
                    本例中缓冲区大小设置的10，源文件中内容是AI162.3764568，共有14个字符，
                    由于这些字符都属于ASCII字符，因此14个字符需要14字节描述，需要读写两次才能完成复制。
             */

            // 首先读取一次，这次读取10个字节
            // 数据保存到buffer中，len是实际读取的字节数
            int len = in.read(buffer);

            while (len != -1) {
                // 使用字节数组构造字符串
                String copyStr = new String(buffer);

                // 打印复制的字符串，用以验证读取次数
                /*
                    从输出的结果看输出了两次，每次10个字节，第一次输出结果AI-162.376容易理解，它是AI162.3764568的前10个字符；
                    那么第二次输出的结果456862.376令人匪夷所思，事实上前4个字符（4568）是第二次读取的，
                    后面的6个字符（62.376）是上一次读取的
                */
                System.out.println(copyStr);

                // 开始写入数据，该语句执行了两次，第一次执行时len为10，第二次执行时len为4
                // 注意！！这里不要使用void write(byte b[ ])方法，因为它没法控制第二次写入的字节数
                out.write(buffer, 0, len);

                /** 再读取一次，该语句执行了两次，第一次执行时len为4，第二次执行时len为-1 */
                len = in.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
