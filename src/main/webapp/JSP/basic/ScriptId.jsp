<%@page pageEncoding="GBK" %>
<html>
<head>
    <meta charset="GBK">
    <title>�ű���ʽ</title>
</head>
<body>
<%--
    JSP���ʽ
    <%= ���ʽ%>
    ע�⣺<%��=�䲻���пո�
--%>
<% String str123 = "123"; %>
<%= str123 %>

<%--
    ������ʶ���﷨��ʽ��
    <%! ���������򷽷��Ĵ��� %>
--%>
<%!
    int count (int a, int b) {
        return a+b;
    }
%>

<%--
    ����Ƭ�Σ�
    <% Java�����ű����� %>
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