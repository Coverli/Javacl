<%@page pageEncoding="GBK" %>
<html>
<head>
    <meta charset="GBK">
    <title>������ʽ</title>
</head>
<body>
<h3>&lt;jsp:include&gt;������̬�ļ�</h3>
<%--
    �����ļ���ʶ<jsp:include>��
    ������ǰҳ���а��������ļ����������Ŀ����Ƕ�̬�ļ���Ҳ�����Ǿ�̬�ļ�
    <jsp:inclde page="url" flush="false|true"/> ��
    <jsp:inclde page="url" flush="false|true">
        �Ӷ�����ʶ<jsp:param>
    </jsp:include>
    page��ָ���������ļ������·��
    flush����ѡ���ԣ������Ƿ�ˢ�»�����
    �Ӷ�����ʶ<jsp:param>�������򱻰����Ķ�̬ҳ���д��ݲ���
--%>
<jsp:include page="ActionIdInclude.jsp" />

<%--
    ����ת����ʶ<jsp:forward>��
    ���Խ�����ת����������Web��Դ
    <jsp:forward page="url"/>��
    <jsp:forward page="url">
        �Ӷ�����ʶ<jsp:param>
    <jsp:forward>
    page��ָ������ת����Ŀ��ҳ��
    �Ӷ�����ʶ<jsp:param>�������򱻰����Ķ�̬ҳ���д��ݲ���
--%>
<jsp:forward page="ActionIdForward.jsp"/>

<%--
    ���ݲ�����ʶ<jsp:param>��
    ����Ϊ������ʶ���ݲ���
    <jsp:param name="������" value="����ֵ"/>
    name��ָ��������
    value�����ö�Ӧ�Ĳ���ֵ
--%>
<jsp:forward page="ActionParam.jsp">
    <jsp:param name="userid" value="7"/>
</jsp:forward>
</body>
</html>