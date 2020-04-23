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
<title>Update Permission Info</title>
</head>
<body>
	<form action="<%=basePath%>/sm/updatePermission"
		name="updatePermission" method="post">
		<center>
			<table>
				<tr>
					<td>权限编号：</td>
					<td><input type="text" name="permissionId" value="${permission.permissionId}"/></td>
				</tr>
				<tr>
					<td>权限名：</td>
					<td><input type="text" name="permissionName" value="${permission.permissionName}"/></td>
				</tr>
				<tr>
					<td>权限内容：</td>
					<td><input type="text" name="permissionContent" value="${permission.permissionContent}"/></td>
				</tr>
				<tr>
					<td>权限描述：</td>
					<td><input type="text" name="permissionComment" value="${permission.permissionComment}"/></td>
				</tr>
				<tr>
					<td>权限等级：</td>
					<td><input type="text" name="permissionLevel" value="${permission.permissionLevel}"/></td>
				</tr>
				<tr>
					<td>权限创建时间：</td>
					<td><input type="text" name="permissionCreatedDatetime" value="${permission.permissionCreatedDatetime}"/></td>
				</tr>
				<tr>
					<td>权限创建人：</td>
					<td><input type="text" name="permissionCreatedName" value="${permission.permissionCreatedName}"/></td>
				</tr>
				<tr>
					<td>权限修改时间：</td>
					<td><input type="text" name="permissionUpdatedDatetime" value="${permission.permissionUpdatedDatetime}"/></td>
				</tr>
				<tr>
					<td>权限修改人：</td>
					<td><input type="text" name="permissionUpdatedName" value="${permission.permissionUpdatedName}"/></td>
				</tr>
				<tr>
					<td>权限维护时间：</td>
					<td><input type="text" name="maintenanceTime" value="${permission.maintenanceTime}"/></td>
				</tr>
				<tr>
					<td>权限审核时间：</td>
					<td><input type="text" name="checkTime" value="${permission.checkTime}"/></td>
				</tr>
				<tr>
					<td>权限是否有效：</td>
					<td><input type="text" name="isVisible" value="${permission.isVisible}"/></td>
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