<%@page pageEncoding="GBK" %>
<html>
<head>
    <meta charset="GBK">
    <title>动作格式</title>
</head>
<body>
<h3>&lt;jsp:include&gt;包含动态文件</h3>
<%--
    包含文件标识<jsp:include>：
    用于向当前页面中包含其他文件，被包含的可以是动态文件，也可以是静态文件
    <jsp:inclde page="url" flush="false|true"/> 或
    <jsp:inclde page="url" flush="false|true">
        子动作标识<jsp:param>
    </jsp:include>
    page：指定被包含文件的相对路径
    flush：可选属性，设置是否刷新缓冲区
    子动作标识<jsp:param>：用于向被包含的动态页面中传递参数
--%>
<jsp:include page="ActionIdInclude.jsp" />

<%--
    请求转发标识<jsp:forward>：
    可以将请求转发到其他的Web资源
    <jsp:forward page="url"/>或
    <jsp:forward page="url">
        子动作标识<jsp:param>
    <jsp:forward>
    page：指定请求转发的目标页面
    子动作标识<jsp:param>：用于向被包含的动态页面中传递参数
--%>
<jsp:forward page="ActionIdForward.jsp"/>

<%--
    传递参数标识<jsp:param>：
    用于为其他标识传递参数
    <jsp:param name="参数名" value="参数值"/>
    name：指定参数名
    value：设置对应的参数值
--%>
<jsp:forward page="ActionParam.jsp">
    <jsp:param name="userid" value="7"/>
</jsp:forward>
</body>
</html>