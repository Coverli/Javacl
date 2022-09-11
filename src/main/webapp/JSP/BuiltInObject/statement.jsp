<%@ page language="java" contentType="text/html" pageEncoding="GBK" isErrorPage="true" %>
<html>
<head>
    <meta charset="GBK">
    <title>内置对象</title>
</head>
<body>
<%--
    内置对象：
    在jsp页面内不需要创捷可直接使用的对象，一共有9个

    变量名                   真实类型                      作用
    pageContext             pageContext                 当前页面共享数据，还可以获取其他八个内置对象
    request                 HttpServletRequest          一次请求访问的多个资源（转发）
    response                HttpServletResponse         响应对象
    session                 HttpSession                 一次会话的多个请求间
    application             ServletContext              所有用户间共享数据
    page                    Object                      当前页面（Servlet）的对象，this
    out                     JspWriter                   输出对着，数据输出到页面上
    config                  ServletConfig               Servlet的配置对象
    exception               Throwable                   异常对象（当页面声明为isErrorPage时可用）
--%>

    <%
        <%-- pageContext对象 --%>
        pageContext.setAttribute("msg", "hello");
        pageContext.getAttribute("msg");
        pageContext.getRequest();
        pageContext.getResponse();
        pageContext.getSession();
        pageContext.getServletContext();
        pageContext.getPage();
        pageContext.getOut();
        pageContext.getServletConfig();
        pageContext.getException();
    %>
</body>
</html>