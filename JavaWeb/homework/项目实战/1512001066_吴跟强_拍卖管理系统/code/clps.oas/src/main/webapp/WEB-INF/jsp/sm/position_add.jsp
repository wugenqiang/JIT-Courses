<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增职位</title>
</head>
<body>
	<div id="header" style="background-color:#FFA500;width: 350px; float= left;">
	<h3 style="margin-bottom:0;">新增职位</h3></div>
	<div id="content"
		style="background-color: #AA96BD; height: 350px; width: 350px; float: center;">
		<form action="positionAddsuccess" name="myPositionAdd" method="post">
			<table>
				<tr>
					<td>职位名称：</td>
					<td><input type="text" name="positionName" value="">
				</tr>
				<tr>
					<td>职位所属部门：</td>
					<td><input type="number" name="positionDepartmentId" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>职位等级：</td>
					<td><input type="text" name="positionLevel" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>职位描述:</td>
					<td><textarea rows="10" cols="30" name="positionDescription" name=""></textarea></td>
				</tr>
				<tr>
					<td>职位更新人：</td>
					<td><input type="text" name="positionCreatedName" value="${requestScope.positionCreatedName}"><font color="red">*</font></td>
				</tr>
					<!-- <td>
						<select name="levels">
							<option value="">组长</option>
							<option value="">经理</option>
							<option value="">总监</option>
							<option value="">总经理</option>
							<option value="" selected>职员</option>
						</select>
						<font color="red">*</font>
					</td> -->
				</tr>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" name="submit"></td>
					<td>&nbsp;&nbsp;</td>
					<td><input type="reset" value="重置" name="reset"></td>
				</tr>
			</table>
		</form>
		<p>Tip：点击"提交"按钮.</p>
	</div>
</body>
</html>