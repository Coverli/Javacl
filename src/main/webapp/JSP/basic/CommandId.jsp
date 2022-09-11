<%--
    JSP指令标识语法格式
    <%@ 指令名 属性1="属性值1" 属性2="属性值2" ...... %>
--%>
<%--
    page指令：
    language：设置JSP页面使用的语言，目前只支持Java
    extends：设置JSP页面继承的Java类，该属性并不常用，而且有可能影响服务器的性能优化
    import：设置JSP导入的包
    pageEncoding：设置JSP页面的编码格式
    contentType：设置JSP页面的 MIME 类型和字符编码（默认为ISO-8859-1，但该编码不支持中文）
    session：指定JSP页面是否使用HTTP的session会话对象
    buffer：设置JSP的out输出对象使用的缓冲区大小，单位为KB，默认大小为8KB，建议使用8的倍数
    autoFlush：设置JSP页面缓存满时，是否自动刷新缓存，默认为true，如果为false则缓存满时将抛出异常
    isErrorPage：设定当前JSP页面是否为错误处理页面来处理另一个JSP页面的错误
        如果值为 true 则该页面可以使用 Exception 对象，
        如果值为 false 则该页面不可以使用 Exception 对象
    errorPage：指定当前JSP页面的错误处理JSP页面
--%>
<%@ page language="java" import="java.util.Date" pageEncoding="GBK"
         contentType="text/html; charset=GBK" session="true" buffer="32kb" autoFlush="true"
         isErrorPage="false" errorPage="CommandId.jsp"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
    taglib指令：
    prefix：用于指定标签的前缀，但不能命名为jsp,jspx,java,javax,sun,servlet,sunw
    uti：指定标签库文件的存放位置
    设置后可以用prefix来引用uri标签库中的标签
    例如：<c:foreach >
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="GBK">
    <title>指令格式底部</title>
</head>
<body>
<%--
    include指令：
    file：用来指定要包含文件的路径
--%>
<%@include file="CommandIdtop.jsp"%>
<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String today = sdf.format(date);
%>
当前时间：<%=today%>
<%@include file="CommandIdEnd.jsp"%>

<%--
    该注释可以注释掉所有代码片段，推荐使用这种
--%>
<!--
    该注释只能注释HTML代码片段
-->
</body>
</html>