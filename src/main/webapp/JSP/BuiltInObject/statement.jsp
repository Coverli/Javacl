<%@ page language="java" contentType="text/html" pageEncoding="GBK" isErrorPage="true" %>
<html>
<head>
    <meta charset="GBK">
    <title>���ö���</title>
</head>
<body>
<%--
    ���ö���
    ��jspҳ���ڲ���Ҫ���ݿ�ֱ��ʹ�õĶ���һ����9��

    ������                   ��ʵ����                      ����
    pageContext             pageContext                 ��ǰҳ�湲�����ݣ������Ի�ȡ�����˸����ö���
    request                 HttpServletRequest          һ��������ʵĶ����Դ��ת����
    response                HttpServletResponse         ��Ӧ����
    session                 HttpSession                 һ�λỰ�Ķ�������
    application             ServletContext              �����û��乲������
    page                    Object                      ��ǰҳ�棨Servlet���Ķ���this
    out                     JspWriter                   ������ţ����������ҳ����
    config                  ServletConfig               Servlet�����ö���
    exception               Throwable                   �쳣���󣨵�ҳ������ΪisErrorPageʱ���ã�
--%>

    <%
        <%-- pageContext���� --%>
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