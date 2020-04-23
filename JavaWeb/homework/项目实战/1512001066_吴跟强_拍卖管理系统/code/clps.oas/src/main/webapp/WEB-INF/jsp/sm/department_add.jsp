<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>新增部门</title>
</head>
<body>
	<div id="header" style="background-color:#FFA500;width: 350px; float= left;">
	<h3 style="margin-bottom:0;">新增部门</h3></div>
	<div id="content"
		style="background-color: #AA96BD; height: 450px; width: 350px; float: center;">
		<form action="addDepartment"  name="myDepartmentAdd" method="post">
			<table>
				<tr>
					<td>部门名称：</td>
					<td><input type="text" name="depaName" value="">
				</tr>
				<tr>
					<td>上级部门编号：</td>
					<td><input type="text" name="depaFatherNumber" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>下级部门编号：</td>
					<td><input type="text" name="depaChildNumber" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>部门等级：</td>
					<td><input type="text" name="depaLevel" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>部门邮箱：</td>
					<td><input type="text" name="depaEmail" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>部门描述:</td>
					<td><textarea rows="10" cols="30" name="depaComment"></textarea></td>
				</tr>
				<tr>
					<td>部门创建人名：</td>
					<td><input type="text" name="depaCreateName" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>部门修改人名：</td>
					<td><input type="text" name="depaUpdatedName" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" name="submit"></td>
					<td><input type="reset" value="重置" name="reset"></td>
				</tr>
			</table>
		</form>
		<p>Tip：点击"提交"按钮.</p>
	</div>
</body>
</html>