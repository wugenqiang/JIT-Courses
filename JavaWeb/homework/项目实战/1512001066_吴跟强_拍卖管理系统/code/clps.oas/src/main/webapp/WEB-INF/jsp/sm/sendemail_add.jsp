<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>新增邮件</title>
</head>
<body>
	<div id="header" style="background-color:#FFA500;width: 350px; float= left;">
	<h3 style="margin-bottom:0;">新增邮件</h3></div>
	<div id="content"
		style="background-color: #AA96BD; height: 450px; width: 350px; float: center;">
		<form action="addEmail"  name="myEmailAdd" method="post">
			<table>
				<tr>
					<td>邮件主题：</td>
					<td><input type="text" name="emailSubject" value="">
				</tr>
				<tr>
					<td>收件人：</td>
					<td><input type="text" name="emailRecipient" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>收件人id：</td>
					<td><input type="text" name="emailRecipientId" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>邮件内容:</td>
					<td><textarea rows="10" cols="30" name="emailContent"></textarea></td>
				</tr>
				<tr>
					<td>邮件状态：</td>
					<td><input type="text" name="emailStatus" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>邮件是否有效：</td>
					<td><input type="text" name="emailIsVisable" value=""><font color="red">*</font></td>
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