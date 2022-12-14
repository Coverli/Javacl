package com.Advance.IO;

/** I/O流概述 **/
public class IOstatement {
    /*
        数据输入的数据源有多种形式，如文件、网络和键盘等，键盘是默认的标准输入设备。
        而数据输出的目的地也有多种形式，如文件、网络和控制台，控制台是默认的标准输出设备。
        所有的输入形式都抽象为输入流，所有的输出形式都抽象为输出流，它们与设备无关。

        以字节为单位的流称为字节流，以字符为单位的流称为字符流。Java SE提供4个顶级抽象类，
        两个字节流抽象类：InputStream和 OutputStream
        两个字符流抽象类：Reader和 Writer

        01. 字节输入流
            字节输入流根类是InputStream，如下图所示它有很多子类，这些类的说明如下表所示。
            +----------------------------------------------------------------+
            |          类           |              描述                       |
            +----------------------------------------------------------------+
            |   FileInputStream    |   文件输入流                              |
            +----------------------------------------------------------------+
            | ByteArrayInputStream |   面向字节数组的输入流                      |
            +----------------------------------------------------------------+
            |   PipedInputStream   |   管道输入流，用于两个线程之间发数据传递        |
            +----------------------------------------------------------------+
            |  FilterInputStream   |   过滤输入流，它是一个装饰器扩展其他输入流      |
            +----------------------------------------------------------------+
            | BufferedInputStream  |   缓冲区输入流，它是FilterInputStream的子类  |
            +----------------------------------------------------------------+
            |   DataInputStream    |   面向基本数据类型的输入流                   |
            +----------------------------------------------------------------+

                          |----FileInputStream
                          |
                          |----ByteArrayInputStream     |----BufferedInputStream
                          |                             |
            InputStream---|----FilterInputStream--------|----DataInputStream
                          |                             |
                          |----PipedInputStream         |----......
                          |
                          |----......

        02. 字节输出流
            字节输出流根类是OutputStream，如下图所示它有很多子类，这些类的说明如下表所示
            +----------------------------------------------------------------+
            |          类           |              描述                       |
            +----------------------------------------------------------------+
            |   FileOutputStream    |   文件输出流                             |
            +----------------------------------------------------------------+
            | ByteArrayOutputStream |   面向字节数组的输出流                     |
            +----------------------------------------------------------------+
            |   PipedOutputStream   |   管道输出流，用于两个线程之间发数据传递       |
            +----------------------------------------------------------------+
            |  FilterOutputStream   |   过滤输出流，它是一个装饰器扩展其他输出流     |
            +----------------------------------------------------------------+
            | BufferedOutputStream  |  缓冲区输出流，它是FilterOutputStream的子类 |
            +----------------------------------------------------------------+
            |   DataOutputStream    |   面向基本数据类型的输出流                  |
            +----------------------------------------------------------------+

                           |----FileOutputStream
                           |
                           |----ByteArrayOutputStream     |----BufferedOutputStream
                           |                              |
            OutputStream---|----FilterOutputStream--------|----DataOutputStream
                           |                              |
                           |----PipedOutputStream         |----......
                           |
                           |----......

        03. 字符输入流
            字符输入流根类是Reader，这类流以16位的Unicode编码表示的字符为基本处理单位。
            如下图所示它有很多子类，这些类的说明如下表所示
            +-------------------------------------------------------------------------+
            |       类           |                       描述                          |
            +-------------------------------------------------------------------------+
            |   FileReader       |  文件输入流                                          |
            +-------------------------------------------------------------------------+
            |   CharArrayReader  |  面向字符数组的输入流                                  |
            +-------------------------------------------------------------------------+
            |   PipedReader      |  管道输入流，用于两个线程之间的数据传递                    |
            +-------------------------------------------------------------------------+
            |   FilterReader     |  过滤输入流，它是一个装饰器扩展其他输入流                  |
            +-------------------------------------------------------------------------+
            |   BufferedReader   |  缓冲区输入流，它也是装饰器，但不是FilterReader的子类      |
            +-------------------------------------------------------------------------+
            | OutputStreamReader |  把字节流转换为字符流，它也是一个装饰器，是FileReader的父类  |
            +-------------------------------------------------------------------------+

                     |----CharArrayReader
                     |
                     |----FileReader
                     |
                     |----PipedReader
            Reader---|
                     |----BufferedReader
                     |
                     |----OutputStreamReader----FilterReader
                     |
                     |----......

        04. 字符输出流
            字符输出流根类是Writer，这类流以16位的Unicode编码表示的字符为基本处理单位。
            如下图所示它有很多子类，这些类的说明如下表所示。
            +-------------------------------------------------------------------------+
            |       类           |                       描述                          |
            +-------------------------------------------------------------------------+
            |   FileWriter       |  文件输出流                                          |
            +-------------------------------------------------------------------------+
            |   CharArrayWriter  |  面向字符数组的输出流                                  |
            +-------------------------------------------------------------------------+
            |   PipedWriter      |  管道输出流，用于两个线程之间的数据传递                    |
            +-------------------------------------------------------------------------+
            |   FilterWriter     |  过滤输出流，它是一个装饰器扩展其他输出流                  |
            +-------------------------------------------------------------------------+
            |   BufferedWriter   |  缓冲区输出流，它也是装饰器，但不是FilterWriter的子类      |
            +-------------------------------------------------------------------------+
            | OutputStreamWriter |  把字节流转换为字符流，它也是一个装饰器，是FileWriter的父类  |
            +-------------------------------------------------------------------------+

                     |----CharArrayWriter
                     |
                     |----FileWriter
                     |
                     |----PipedWriter
            Writer---|
                     |----BufferedWriter
                     |
                     |----OutputStreamWriter----FilterWriter
                     |
                     |----......
    */
}
