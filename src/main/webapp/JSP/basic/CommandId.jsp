<%--
    JSPָ���ʶ�﷨��ʽ
    <%@ ָ���� ����1="����ֵ1" ����2="����ֵ2" ...... %>
--%>
<%--
    pageָ�
    language������JSPҳ��ʹ�õ����ԣ�Ŀǰֻ֧��Java
    extends������JSPҳ��̳е�Java�࣬�����Բ������ã������п���Ӱ��������������Ż�
    import������JSP����İ�
    pageEncoding������JSPҳ��ı����ʽ
    contentType������JSPҳ��� MIME ���ͺ��ַ����루Ĭ��ΪISO-8859-1�����ñ��벻֧�����ģ�
    session��ָ��JSPҳ���Ƿ�ʹ��HTTP��session�Ự����
    buffer������JSP��out�������ʹ�õĻ�������С����λΪKB��Ĭ�ϴ�СΪ8KB������ʹ��8�ı���
    autoFlush������JSPҳ�滺����ʱ���Ƿ��Զ�ˢ�»��棬Ĭ��Ϊtrue�����Ϊfalse�򻺴���ʱ���׳��쳣
    isErrorPage���趨��ǰJSPҳ���Ƿ�Ϊ������ҳ����������һ��JSPҳ��Ĵ���
        ���ֵΪ true ���ҳ�����ʹ�� Exception ����
        ���ֵΪ false ���ҳ�治����ʹ�� Exception ����
    errorPage��ָ����ǰJSPҳ��Ĵ�����JSPҳ��
--%>
<%@ page language="java" import="java.util.Date" pageEncoding="GBK"
         contentType="text/html; charset=GBK" session="true" buffer="32kb" autoFlush="true"
         isErrorPage="false" errorPage="CommandId.jsp"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
    taglibָ�
    prefix������ָ����ǩ��ǰ׺������������Ϊjsp,jspx,java,javax,sun,servlet,sunw
    uti��ָ����ǩ���ļ��Ĵ��λ��
    ���ú������prefix������uri��ǩ���еı�ǩ
    ���磺<c:foreach >
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="GBK">
    <title>ָ���ʽ�ײ�</title>
</head>
<body>
<%--
    includeָ�
    file������ָ��Ҫ�����ļ���·��
--%>
<%@include file="CommandIdtop.jsp"%>
<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String today = sdf.format(date);
%>
��ǰʱ�䣺<%=today%>
<%@include file="CommandIdEnd.jsp"%>

<%--
    ��ע�Ϳ���ע�͵����д���Ƭ�Σ��Ƽ�ʹ������
--%>
<!--
    ��ע��ֻ��ע��HTML����Ƭ��
-->
</body>
</html>