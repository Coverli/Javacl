<%@ page pageEncoding="GBK" import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String today = sdf.format(date);
%>
<%= today %>