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
<title>Update role info</title>
</head>
<body>
	<form action="<%=basePath%>/sm/updateRole"
		name="updatePermission" method="post">
		<center>
			<table>
				<tr>
					<td>角色名：</td>
					<td><input type="text" name="roleName" /></td>
				</tr>
				<tr>
					<td>角色描述：</td>
					<td><input type="text" name="roleComment" /></td>
				</tr>
				<tr>
					<td>角色等级：</td>
					<td><input type="text" name="roleLevel" /></td>
				</tr>
				<tr>
					<td>角色创建时间：</td>
					<td><input type="text" name="roleCreatedDatetime" /></td>
				</tr>
				<tr>
					<td>角色创建人名：</td>
					<td><input type="text" name="roleCreatedName" /></td>
				</tr>
				<tr>
					<td>角色修改时间：</td>
					<td><input type="text" name="roleUpdatedDatetime" /></td>
				</tr>
				<tr>
					<td>角色修改人名：</td>
					<td><input type="text" name="roleUpdatedName" /></td>
				</tr>
				<tr>
					<td>角色备注1：</td>
					<td><input type="text" name="roleDefault1" /></td>
				</tr>
				<tr>
					<td>角色备注2：</td>
					<td><input type="text" name="roleDefault2" /></td>
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