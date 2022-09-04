package com.Advance.Network.TCPSocket;

/**
 * TCP Socket通信概述
 * */
public class statement {
    /**
        TCP/IP协议的传输层有两种传输协议：TCP（传输控制协议）和 UDP（用户数据报协议）。
        TCP是面向连接的可靠数据传输协议。TCP就像好比电话，电话接通后双方才能通话，在挂断电话之前，电话一直占线。
        TCP连接一旦建立起来，一直占用，直到关闭连接。
        另外，TCP为了保证数据的正确性，会重发一切没有收到的数据，还会对进行数据内容进行验证，
        并保证数据传输的正确顺序。因此TCP协议对系统资源的要求较多。

        Socket是网络上的两个程序，通过一个双向的通信连接，实现数据的交换。
        这个双向链路的一端称为一个Socket。Socket通常用来实现客户端和服务端的连接。
        Socket是TCP/IP协议的一个十分流行的编程接口，
        一个Socket由一个IP地址和一个端口号唯一确定，一旦建立连接Socket还会包含本机和远程主机的IP地址和远端口号，
        如下图所示，Socket是成对出现的

        +-------------------------+                                     +-------------------------+
        |       服务器端程序        |                                     |       客户端程序          |
        +-------------------------+                                     +-------------------------+
        |        Socket           |                                     |         Socket          |
        | 本地：192.168.1.7:8080   |                                     | 本地：192.168.1.5:8081   |
        |远程主机：192.168.1.5：8081|                                     |远程主机：192.168.1.7：8080|
        |                         |                                     |                         |
        |               输入流 <---|--------------   --------------------|---> 输入流               |
        |                         |               X                     |                         |
        |               输出流 ----|--------------   --------------------|---- 输出流               |
        |                         |                                     |                         |
        +-------------------------+                                     +-------------------------+


        使用Socket进行C/S结构编程，通信过程如图statement.png所示
        服务器端监听某个端口是否有连接请求，服务器端程序处于阻塞状态，直到客户端向服务器端发出连接请求，
        服务器端接收客户端请求，服务器会响应请求，处理请求，然后将结果应答给客户端，这样就会建立连接。
        一旦连接建立起来，通过Socket可以获得输入输出流对象。借助于输入输出流对象就可以实现服务器与客户端的通信，
        最后不要忘记关闭Socket和释放一些资源（包括：关闭输入输出流）

        Socket类
        java.net包为TCP Socket编程提供了两个核心类：Socket和ServerSocket，分别用来表示双向连接的客户端和服务器端
        Socket常用的构造方法有：
            Socket(InetAddress address, int port) ：创建Socket对象，并指定远程主机IP地址和端口号。
            Socket(InetAddress address, int port, InetAddress localAddr, int localPort)：创建Socket对象，
                并指定远程主机IP地址和端口号，以及本机的IP地址（localAddr）和端口号（localPort）。
            Socket(String host, int port)：创建Socket对象，并指定远程主机名和端口号，IP地址为null，
                null表示回送地址，即127.0.0.1。
            Socket(String host, int port, InetAddress localAddr, int localPort)：创建Socket对象，
                并指定远程主机和端口号，以及本机的IP地址（localAddr）和端口号（localPort）。host主机名，
                IP地址为null，null表示回送地址，即127.0.0.1。
        Socket其他的常用方法有：
            InputStream getInputStream()：通过此Socket返回输入流对象。
            OutputStream getOutputStream()：通过此Socket返回输出流对象。
            int getPort()：返回Socket连接到的远程端口。
            int getLocalPort()：返回Socket绑定到的本地端口。
            InetAddress getInetAddress()：返回Socket连接的地址。
            InetAddress getLocalAddress()：返回Socket绑定的本地地址。
            boolean isClosed()：返回Socket是否处于关闭状态。
            boolean isConnected()：返回Socket是否处于连接状态。
            void close()：关闭Socket。
        注意：Socket与流类似所占用的资源，不能通过JVM的垃圾收集器回收，需要程序员释放。
            一种方法是可以在finally代码块调用close()方法关闭Socket，释放流所占用的资源。
            另一种方法通过自动资源管理技术释放资源，Socket和ServerSocket都实现了AutoCloseable接口。

        ServerSocket类
        ServerSocket类常用的构造方法有：
            ServerSocket(int port, int maxQueue)：创建绑定到特定端口的服务器Socket。
                maxQueue设置连接的请求最大队列长度，如果队列满时，则拒绝该连接。默认值是50。
            ServerSocket(int port)：创建绑定到特定端口的服务器Socket。最大队列长度是50。
        ServerSocket其他的常用方法有：
            InputStream getInputStream()：通过此Socket返回输入流对象。
            OutputStream getOutputStream()：通过此Socket返回输出流对象。
            boolean isClosed()：返回Socket是否处于关闭状态。
            Socket accept()：侦听并接收到Socket的连接。此方法在建立连接之前一直阻塞。
            void close()：关闭Socket。
        ServerSocket类本身不能直接获得I/O流对象，而是通过accept()方法返回Socket对象，
        通过Socket对象取得I/O流对象，进行网络通信。此外，ServerSocket也实现了AutoCloseable接口，
        通过自动资源管理技术关闭ServerSocket。
     */
}
