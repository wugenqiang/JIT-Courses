<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="com.wgq.entity.User" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%
    User user = (User)session.getAttribute("loginUser");
    if(user==null||user.getName()==null){
    	response.sendRedirect(basePath+"User_login.jsp");
    	return;
    }
%>
<!DOCTYPE html>
<html>

	<head>
		<title>图书管理系统首页</title>		
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-table.min.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-editable.css"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrapEx.css"/>
		<script src="js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table-locale-all.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-editable.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table-editable.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrapTable.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrapEx.js" type="text/javascript" charset="utf-8"></script>
	</head>
	
	
	<script type="text/javascript">
		$(function(){
			var oTable = new TableInit();
			oTable.Init();
			
			//管理员权限赋予
			if(<%=user.getUsertype()%>==0){
				$('#btn_add').css({"display":"none"});//对普通用户进行增加功能隐藏
				$('#btn_delete').css({"display":"none"});//对普通用户进行删除功能隐藏		
			}
		});
	</script>

	<body>
		<div class="header">
			<div class="topTxt pull-right">
				<div class="container">
				    <a title="欢迎" target="_blank">欢迎回来</a> |
					<a href="http://lib.jit.edu.cn" title="金科院图书馆官网" target="_blank">金科院图书馆官网</a> |
					<a href="html/exit.html" title="退出">退出</a>
				</div>
			</div>
			<div class="container">
				<div class="topArea">
					<h1 class="logo">
					        <a target="_blank"><img src="img/logo.jpg" alt="金科院图书馆"></a>			
					</h1>
				</div>
			</div>
		</div>
	
		<div class="container">
			<div id="menu">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid">
						<div class="navbar-header">
							<button class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
								<span class="sr-only"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>
							<div class="collapse navbar-collapse pull-right" id="example-navbar-collapse">
							<ul class="nav navbar-nav">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 图书类别 <b class="caret"></b></a>
									<ul class="dropdown-menu dropdown-menu-right">
										<li><a href="#">JAVA网站开发</a></li>
										<li class="divider"></li>
										<li><a href="#">PHP网站开发</a></li>
										<li class="divider"></li>
										<li><a href="#">新媒体UI设计</a></li>
										<li class="divider"></li>
										<li><a href="#">互联网跨境电商</a></li>
										<li class="divider"></li>
										<li><a href="#">大数据分析</a></li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		
	
		<div class="container">
			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="btn_delete" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>删除
				</button>
			</div>
		</div>
	
		<div class="container">
			<table class="table table-bordered" id="table" data-toggle="table">
				<caption class="text-center"><big>图书详细信息列表</big></caption>
			</table>
		</div>
	
	</body>

</html>