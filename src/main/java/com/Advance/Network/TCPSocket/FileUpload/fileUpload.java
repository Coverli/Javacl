package com.Advance.Network.TCPSocket.FileUpload;

/**
 * 单向数据传输案例：文件上传工具
 * */
public class fileUpload {
    /**
        基于TCP Socket编程比较复杂，先从一个简单的文件上传工具案例介绍TCP Socket编程基本流程。
        上传过程是一个单向Socket通信过程，如图1.png所示，客户端通过文件输入流读取文件，
        然后从Socket获得输出流写入数据，写入数据完成上传成功，客户端任务完成。
        服务器端从Socket获得输入流，然后写入文件输出流，写入数据完成上传成功，服务器端任务完成。

        提示：案例测试时，先运行服务器，再运行客户端。
            测试Socket程序最好打开两个命令行窗口，通过java指令分别运行服务器程序和客户端程序，
            需要注意当前运行的路径，需要指定类路径，
     */
}
