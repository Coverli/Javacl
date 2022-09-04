package com.Advance.Network.Internet;

/**
 * URL及HTTP/HTTPS概述
 * */
public class statement {
    /**
        Java的java.net包中还提供了高层次网络编程类——URL，通过URL类访问互联网资源。
        使用URL进行网络编程，不需要对协议本身有太多的了解，相对而言是比较简单的。

        URL概念
        互联网资源是通过URL指定的，URL是Uniform Resource Locator简称，翻译过来是“一致资源定位器”，但人们都习惯URL简称。
        URL组成格式如下：
            协议名://资源名
            “协议名”指明获取资源所使用的传输协议，如http、ftp、gopher和file等，
            “资源名”则应该是资源的完整地址，包括主机名、端口号、文件名或文件内部的一个引用。
            例如：
                https://www.csdn.net
                https://stackoverflow.com
                https://github.com/Coverli
                ftp://192.168.1.1:21
                file:///C:/Users/Coverli/statement.java

        HTTP/HTTPS协议
        访问互联网大多都基于HTTP/HTTPS协议。下面介绍一下HTTP/HTTPS协议。
        HTTP协议
            HTTP是Hypertext Transfer Protocol的缩写，即超文本传输协议。HTTP是一个属于应用层的面向对象的协议，
            其简捷、快速的方式适用于分布式超文本信息的传输。它于1990年提出，经过多年的使用与发展，得到不断完善和扩展。
            HTTP协议支持C/S网络结构，是无连接协议，即每一次请求时建立连接，
            服务器处理完客户端的请求后，应答给客户端然后断开连接，不会一直占用网络资源。
        HTTP/1.1协议共定义了8种请求方法：OPTIONS、HEAD、GET、POST、PUT、DELETE、TRACE和CONNECT。
        在HTTP访问中，一般使用GET和HEAD方法。
            GET方法：是向指定的资源发出请求，发送的信息“显式”地跟在URL后面。GET方法应该只用在读取数据，
                例如静态图片等。GET方法有点像使用明信片给别人写信，“信内容”写在外面，接触到的人都可以看到，因此是不安全的。
            POST方法：是向指定资源提交数据，请求服务器进行处理，例如提交表单或者上传文件等。
                数据被包含在请求体中。POST方法像是把“信内容”装入信封中，接触到的人都看不到，因此是安全的。

        HTTPS协议
            HTTPS是Hypertext Transfer Protocol Secure，即超文本传输安全协议，是超文本传输协议和SSL的组合，
            用以提供加密通信及对网络服务器身份的鉴定。
            简单地说，HTTPS是HTTP的升级版，HTTPS与HTTP的区别是：HTTPS使用https://代替http://，
            HTTPS使用端口443，而HTTP使用端口80来与TCP/IP进行通信。SSL使用40位关键字作为RC4流加密算法，
            这对于商业信息的加密是合适的。HTTPS和SSL支持使用X.509数字认证，如果需要的话，用户可以确认发送者是谁。
     */
}
