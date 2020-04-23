<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>职位修改</title>
</head>
<body>
	<div id="header" style="background-color:#FFA500;width: 350px; float= left;">
	<h3 style="margin-bottom:0;">职位修改</h3></div>
	<div id="content"
		style="background-color: #AA96BD; height: 450px; width: 350px; float: center;">
		<form action="positionUpdateSuccess"  name="myPositionUpdate" method="post">
			<table>
				<tr>
					<td>职位编号：</td>
					<td><input type="text" name="positionId" value="${requestScope.position.positionId}">
				</tr>
				<tr>
					<td>职位名称：</td>
					<td><input type="text" name="positionName" value="${requestScope.position.positionName}">
				</tr>
				<tr>
					<td>职位所属部门：</td>
					<td><input type="number" name="positionDepartmentId" value="${requestScope.position.positionDepartmentId}"><font color="red">*</font></td>
				</tr>
				<tr>
					<td>职位等级：</td>
					<td><input type="text" name="positionLevel" value="${requestScope.position.positionLevel}"><font color="red">*</font></td>
				</tr>
				<tr>
					<td>职位描述:</td>
					<td><textarea rows="10" cols="30" name="positionDescription" value="${requestScope.position.positionDescription}"></textarea></td>
				</tr>
				<tr>
					<td><output type="text" name="positionUpdatedName" value="${requestScope.positionId}"><font color="red"></font></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="修改" name="submit"></td>
					<td><input type="reset" value="重置" name="reset"></td>
				</tr>
			</table>
		</form>
		<p>Tip：点击"提交"按钮.</p>
	</div>
</body>
</html>