<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Permission Info</title>
</head>

<body>
	<form action="<%=basePath%>/sm/addPermissionVO" name="addPermissionVO" method="post">
		<center>
			<table>
				<tr>
					<td>权限名：</td>
					<td><input type="text" name="permissionName" /></td>
				</tr>
				<tr>
					<td>权限内容：</td>
					<td><input type="text" name="permissionContent" /></td>
				</tr>
				<tr>
					<td>权限描述：</td>
					<td><input type="text" name="permissionComment" /></td>
				</tr>
				<tr>
					<td>权限等级：</td>
					<td><input type="text" name="permissionLevel" /></td>
				</tr>
				<tr>
					<td><input type="reset" value="重置" /></td>
					<td><input type="submit" value="提交" /></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>