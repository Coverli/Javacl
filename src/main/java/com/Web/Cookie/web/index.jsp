<%--
  Created by IntelliJ IDEA.
  User: fqy
  Date: 2018/6/8
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <%
        System.out.println("hello jsp");
        int i = 5;

        String contextPath = request.getContextPath();
        out.print(contextPath);
      %>

      <%!
        int i = 3;
      %>

      <%= i %>
      <%= "hello" %>

      System.out.println("hello jsp");
      <h1>hi~ jsp!</h1>

      <%-- response无论写在哪个位置，都会比out对象先输出到页面，尽量少用，会打乱页面的输出顺序 --%>
      <% response.getWriter().write("response....."); %>
  </body>
</html>
