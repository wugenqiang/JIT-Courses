<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>positionList</title>
</head>
<body>
<body>
	<div align="center">
		<div style="display: flex;">
			<div class="header" style="flex: 2">
				<b>职位信息显示</b>
			</div>
		</div>
		<table class="dataintable">
			<tr>
				<th>职位编号</th>
				<th>职位名称</th>
				<th>职位描述</th>
				<th>职位等级</th>
				<th>部门编号</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.positionList}" var="position">
				<tr>
					<td>${position.positionId}</td>
					<td>${position.positionName}</td>
					<td>${position.positionDescription}</td>
					<td>${position.positionLevel}</td>
					<td>${position.positionDepartmentId}</td>
					<td><a href="">下载</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>


</html>