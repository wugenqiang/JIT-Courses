<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位显示</title>
</head>
<body>
	<h3>Position Info</h3>
	<table border="1">
		<tr>
			<th>职位编号</th><th>职位名称</th><th>职位描述</th><th>职位等级</th><th>职位所属部门</th><th>职位创建时间</th><th>职位创建人</th><th>职位更新时间</th><th>职位更新人</th><th>操  作</th>
		</tr>
		<c:forEach items="${requestScope.positions}" var="position">
		<tr>
			<td>${position.positionId}</td>
			<td>${position.positionName}</td>
			<td>${position.positionDescription}</td>
			<td>${position.positionLevel}</td>
			<td>${position.positionDepartmentId}</td>
			<td>${position.positionCreatedDatetime}</td>
			<td>${position.positionCreatedName}</td>
			<td>${position.positionUpdatedDatetime}</td>
			<td>${position.positionUpdatedName}</td>
			<td><a href="positionUpdate?positionId=${position.positionId}">编辑</a>|<a href="positionAdd?positionId=${position.positionId}">添加</a>|<a href="positionDel?positionId=${position.positionId}">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>