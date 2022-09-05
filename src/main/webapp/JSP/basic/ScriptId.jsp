<%@page pageEncoding="GBK" %>
<html>
<head>
    <meta charset="GBK">
    <title>脚本格式</title>
</head>
<body>
<%--
    JSP表达式
    <%= 表达式%>
    注意：<%和=间不能有空格
--%>
<% String str123 = "123"; %>
<%= str123 %>

<%--
    声明标识的语法格式：
    <%! 声明变量或方法的代码 %>
--%>
<%!
    int count (int a, int b) {
        return a+b;
    }
%>

<%--
    代码片段：
    <% Java代码或脚本代码 %>
--%>
<%
    String str = "";
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            str += j+"*"+i+"="+j*i;
            str += "&nbsp";
        }
    }
    str += "<br>";
%>
<%= str %>
</body>
</html>