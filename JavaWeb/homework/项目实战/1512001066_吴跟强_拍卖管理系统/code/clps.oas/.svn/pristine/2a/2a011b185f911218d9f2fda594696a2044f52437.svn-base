<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>/css/mail.css" rel="stylesheet" type="text/css">
<title>发件箱</title>
</head>
<body>
	<div id="myEmailList">
	<h3>发件箱</h3>
	<a href="toAddEmail">新增</a>
	<table border="1">
		<tr>
			<th>邮件编号</th><th>邮件主题</th><th>收件人</th><th>邮件内容</th><th>操  作</th>
		</tr>
		<c:forEach items="${requestScope.sendemails}" var="sendemail">
		<tr>
			<td>${sendemail.emailId}</td>
			<td>${sendemail.emailSubject}</td>
			<td>${sendemail.emailRecipient}</td>
			<td>${sendemail.emailContent}</td>
			<td><a href="getEmail?emailId=${sendemail.emailId}">修改</a>|<a href="delEmail?emailId=${sendemail.emailId}">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>