<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<!--将css样式引入-->
	<link rel="stylesheet" type="text/css" href="css/denglu.css" />
	<!--头部-->
	<head>
		<!--以防出现乱码-->
		<!--标题-->
		<title>图书管理系统</title>
	</head>
	<!--主体-->
	<body>
		<div class="content">
			<!--内容-->
			<h1 class="content-title">图书管理系统</h1>
			<div class="content-form">
				<form method="post" action="/LibraryManageSystem/User_login.do" id="form" >
					<div id="change_margin_1">
						<input class="user" type="text" name="name" placeholder="请输入用户名" onblur="oBlur_1()" onfocus="oFocus_1()">
					</div>
					<!--input的value为空时弹出提醒-->
					<div class="text-item">
						<p id="remind_1"></p>
					</div>
					<p id="change_margin_2">
						<input class="password" type="password" name="password" placeholder="请输入密码"onblur="oBlur_2()" onfocus="oFocus_2()">
					</p>
					<div class="text-item">
						<p id="remind_2"></p>
					</div>

					<div id="change_margin_3">
						<input class="content-form-signup" type="submit" value="登录" >
					</div>
				</form>
			</div>
			<div class="content-login-description">没有账户</div><br/>
			
			<div>
				<a class="content-login-link" href="html/User_register.html">注册</a>
			</div>
			
		</div>
	</body>
	<script src="js/User_login.js" type="text/javascript" charset="utf-8"></script>
</html>