<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<div align="center">
		<h2>文件上传</h2>

		<form method="post" action="/clps.oas/file/doUpload"
			enctype="multipart/form-data">
			<input type="file" name="file" />
			<button type="submit">上传</button>
		</form>
	</div>


</body>
</html>