package com.Advance.Network.UDPSocket;

/**
 * UDP Socket通信概述
 */
public class statement {
    /**
        UDP（用户数据报协议）就像日常生活中的邮件投递，是不能保证可靠地寄到目的地。
        UDP是无连接的，对系统资源的要求较少，UDP可能丢包不保证数据顺序。
        但是对于网络游戏和在线视频等要求传输快、实时性高、质量可稍差一点的数据传输，UDP还是非常不错的。
        UDP Socket网络编程比TCP Socket编程简单多，UDP是无连接协议，不需要像TCP一样监听端口，建立连接，然后才能进行通信。

        DatagramSocket类
        java.net包中提供了两个类：DatagramSocket和DatagramPacket用来支持UDP通信。
        DatagramSocket用于在程序之间建立传送数据报的通信连接。DatagramSocket常用的构造方法：
            DatagramSocket()：创建数据报DatagramSocket对象，并将其绑定到本地主机上任何可用的端口。
            DatagramSocket(int port)：创建数据报DatagramSocket对象，并将其绑定到本地主机上的指定端口。
            DatagramSocket(int port, InetAddress laddr)：创建数据报DatagramSocket对象，并将其绑定到指定的本地地址。
        DatagramSocket其他的常用方法有：
            void send(DatagramPacket p)：从发送数据报包。
            void receive(DatagramPacket p)：接收数据报包。
            int getPort()：返回DatagramSocket连接到的远程端口。
            int getLocalPort()：返回DatagramSocket绑定到的本地端口。
            InetAddress getInetAddress()：返回DatagramSocket连接的地址。
            InetAddress getLocalAddress()：返回DatagramSocket绑定的本地地址。
            boolean isClosed()：返回DatagramSocket是否处于关闭状态。
            boolean isConnected()：返回DatagramSocket是否处于连接状态。
            void close()：关闭DatagramSocket。
        DatagramSocket也实现了AutoCloseable接口，通过自动资源管理技术关闭DatagramSocket。

        DatagramPacket类
        DatagramPacket用来表示数据报包，是数据传输的载体。DatagramPacket实现无连接数据包投递服务，
        每投递数据包仅根据该包中信息从一台机器路由到另一台机器。从一台机器发送到另一台机器的多个包可能选择不同的路由，
        也可能按不同的顺序到达，不保证包都能到达目的。DatagramPacket的构造方法：
            DatagramPacket(byte[] buf, int length)：构造数据报包，buf包数据，length是接收包数据的长度。
            DatagramPacket(byte[] buf, int length, InetAddress address, int port)：构造数据报包，
                包发送到指定主机上的指定端口号。
            DatagramPacket(byte[] buf, int offset, int length)：构造数据报包，offset是buf字节数组的偏移量。
            DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)：构造数据报包，
                包发送到指定主机上的指定端口号。
        DatagramPacket常用的方法：
            InetAddress getAddress()：返回发往或接收该数据报包相关的主机的IP地址。
            byte[] getData()：返回数据报包中的数据。
            int getLength()：返回发送或接收到的数据（byte[]）的长度。
            int getOffset()：返回发送或接收到的数据（byte[]）的偏移量。
            int getPort()：返回发往或接收该数据报包相关的主机的端口号。
     */
}
