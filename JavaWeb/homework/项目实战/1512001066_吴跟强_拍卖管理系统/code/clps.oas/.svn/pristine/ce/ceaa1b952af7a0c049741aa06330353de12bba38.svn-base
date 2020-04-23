<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>
	<h3>Role Info</h3>
	<table border="1">
		<tr>
			<th>角色编号</th>
			<th>角色名字</th>
			<th>角色描述</th>
			<th>角色等级</th>
			<th>角色创建日期</th>
			<th>角色创建人名</th>
			<th>角色更新日期</th>
			<th>角色更新人名</th>
			<th>角色备注1</th>
			<th>角色备注2</th>
			<th>操 作</th>
		</tr>
		<c:forEach items="${requestScope.roles}" var="role">
			<tr>
				<td>${role.roleId}</td>
				<td>${role.roleName}</td>
				<td>${role.roleComment}</td>
				<td>${role.roleLevel}</td>
				<td>${role.roleCreatedDatetime}</td>
				<td>${role.roleCreatedName}</td>
				<td>${role.roleUpdatedDatetime}</td>
				<td>${role.roleUpdatedName}</td>
				<td>${role.roleDefault1}</td>
				<td>${role.roleDefault2}</td>
				<td><a href="editRole?roleId=${role.roleId}">编辑</a>| <a
					href="delRole?roleId=${role.roleId}">删除</a>| <a
					href="addRole?roleId=${role.roleId}">新增</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>