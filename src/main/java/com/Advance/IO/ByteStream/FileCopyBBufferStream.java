package com.Advance.IO.ByteStream;

import java.io.*;

/** 字节缓冲流使用案例：文件复制 */
public class FileCopyBBufferStream {
    /**
        BufferedInputStream和BufferedOutputStream称为字节缓冲流，使用字节缓冲流内置了一个缓冲区，
        第一次调用read方法时尽可能多地从数据源读取数据到缓冲区，后续再到用read方法时先看看缓冲区中是否有数据，
        如果有则读缓冲区中的数据，如果没有再将数据源中的数据读入到缓冲区，这样可以减少直接读数据源的次数。
        通过输出流调用write方法写入数据时，也先将数据写入到缓冲区，缓冲区满了之后再写入数据目的地，
        这样可以减少直接对数据目的地写入次数。使用了缓冲字节流可以减少I/O操作次数，提高效率。

        BufferedInputStream的父类是FilterInputStream，BufferedOutputStream的父类是FilterOutputStream，
        FilterInputStream和FilterOutputStream称为过滤流。
        过滤流的作用是扩展其他流，增强其功能。
        那么BufferedInputStream和BufferedOutputStream增强了缓冲能力。

        提示：过滤流实现了装饰器（Decorator）设计模式，这种设计模式能够在运行时扩充一个类的功能。
            而继承在编译时扩充一个类的功能。

        BufferedInputStream和BufferedOutputStream中主要方法都是继承自InputStream和OutputStream，
        下面介绍一下它们的构造方法，
        BufferedInputStream构造方法主要有：
            BufferedInputStream(InputStream in)：通过一个底层输入流in对象创建缓冲流对象，缓冲区大小是默认的，默认值8192。
            BufferedInputStream(InputStream in, int size)：通过一个底层输入流in对象创建缓冲流对象，
                size指定的缓冲区大小，缓冲区大小应该是2的n次幂，这样可提供缓冲区的利用率。
        BufferedOutputStream构造方法主要有：
            BufferedOutputStream(OutputStream out)：通过一个底层输出流out对象创建缓冲流对象，缓冲区大小是默认的，默认值8192。
            BufferedOutputStream(OutputStream out, int size)：通过一个底层输出流out对象创建缓冲流对象，
                size指定的缓冲区大小，缓冲区大小应该是2的n次幂，这样可提高缓冲区的利用率。
     */

    public static void main (String[] args) {
        FileCopyBBufferStream fcbs = new FileCopyBBufferStream();
        fcbs.buS();
        fcbs.byS();
    }

    /** 将package com.Advance.IO.ByteStream.FileCopyByteStream.java文件复制的案例改造成缓冲流实现 */
    void buS() {

        try (FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\build.zip");
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\subDir\\build.zip");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            //开始时间，获取当前系统纳秒时间
            long startTime = System.nanoTime();
            // 准备一个缓冲区，这个缓冲区与缓冲流内置缓冲区不同，决定是否进行I/O操作次数的是缓冲流内置缓冲区
            byte[] buffer = new byte[10];
            // 首先读取一次
            int len = bis.read(buffer);

            while (len != -1) {
                // 开始写入数据
                bos.write(buffer, 0, len);
                // 再读取一次
                len = bis.read(buffer);
            }

            //结束时间，获取当前系统纳秒时间
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("使用字节缓冲流耗时：" + (elapsedTime / 1000000.0) + " 毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 使用字节流 */
    void byS () {
        try (FileInputStream in = new FileInputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\build2.zip");
             FileOutputStream out = new FileOutputStream(".\\src\\main\\java\\com\\Advance\\IO\\TestDir\\subDir\\build2.zip")) {

            //开始时间，当前系统纳秒时间
            long startTime = System.nanoTime();
            // 准备一个缓冲区
            byte[] buffer = new byte[10];
            // 首先读取一次
            int len = in.read(buffer);

            while (len != -1) {
                // 开始写入数据
                out.write(buffer, 0, len);
                // 再读取一次
                len = in.read(buffer);
            }

            //结束时间，当前系统纳秒时间
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("使用字节流耗时：" + (elapsedTime / 1000000.0) + " 毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
