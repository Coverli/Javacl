<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 使用EL解析 --%>
    ${3 > 4}

    <%--
        忽略EL表达式，不解析直接输出，
        在page指令中使用isELIgnored="true"有也可以直接输出，
        但当前页面的所有EL表达式都不会解析
    --%>
    \${3 > 4}
    <hr>

    <h3>算数运算符</h3>
    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>

    <h3>逻辑运算符</h3>
    ${3 > 4  && 3 < 4}<br>
    ${3 > 4  and 3 < 4}<br>

    <h4>empty运算符</h4>
<%
    String str = "";
    request.setAttribute("str",str);

    List list = new ArrayList();
    request.setAttribute("list",list);

    Map map = new HashMap();
    request.setAttribute("map", map);
%>
    ${empty str}
    ${not empty str}

    ${empty list}
    ${not empty list}

    ${empty map}
    ${not empty map}
</body>
</html>
