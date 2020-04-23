<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>

	<h3>Permission Info</h3>
	<table border="1">
		<tr>
			<th>权限编号</th><th>权限名称</th><th>权限内容</th><th>权限描述</th><th>权限等级</th><th>权限创建时间</th><th>权限创建人</th><th>权限更新时间</th><th>权限更新人</th><th>权限维护时间</th><th>权限审核时间</th><th>操  作</th>
		</tr>
		<c:forEach items="${requestScope.permissions}" var="permission">
		<tr>
			<td>${permission.permissionId}</td>
			<td>${permission.permissionName}</td>
			<td>${permission.permissionContent}</td>
			<td>${permission.permissionComment}</td>
			<td>${permission.permissionLevel}</td>
			<td>${permission.permissionCreatedDatetime}</td>
			<td>${permission.permissionCreatedName}</td>
			<td>${permission.permissionUpdatedDatetime}</td>
			<td>${permission.permissionUpdatedName}</td>
			<td>${permission.maintenanceTime}</td>
			<td>${permission.checkTime}</td>
			<td><a href="<%=basePath%>/sm/showAddPermission"><button>新增</button></a>|
			<a href="<%=basePath%>/sm/showUpdatePermission"><button>编辑</button></a>|
			<a href="delPermission?permissionId=${permission.permissionId}"><button>删除</button></a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>