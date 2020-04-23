<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载文件显示页面</title>
</head>

<body>
<div align="center">

	<h2>文件列表</h2>
	<form action="../index.jsp" method="post">
	<!-- 遍历Map集合 -->
	<c:forEach var="me" items="${fileNameMap}">
		<c:url value="/file/fileDownload" var="urlDownload">
			<c:param name="fileName" value="${me.key}"></c:param>
		</c:url>
        ${me.value}<a href="${urlDownload}">下载</a>
		<br />
	</c:forEach>
	<br>
	<button type="submit" formaction="../index.jsp">返回</button>
	</form>
</div>
</body>
</html>