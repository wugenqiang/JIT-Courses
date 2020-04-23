<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/sm/menu.css" />
<title>新增菜单</title>
</head>
<body class="bodyStyle">
<div class="content" style=" height:580px">
<div class="header"><b>菜单添加</b></div>
<hr style="width:95%" />
	<form  action="menuAdd?menuLevel=<%=request.getParameter("menuLevel") %>
	&menuId=<%=request.getParameter("menuId") %>"  
	method="post">
	<font color="red">${requestScope.message}</font>
	<div  class="register" style=" height:430px"> 
		<div class="registerLeft">
			<div class="inputStyle">
					菜单名称：<input name="menuName"></input>
					<font color="red">*</font>
			</div>
			<div class="inputStyle">
					菜单排序号：<input name="menuSortId"></input>
					<font color="red">*</font>
			</div>
			<div class="inputStyle">
					菜单URL：<input name="menuUrl"></input>
					<font color="red">*</font>
			</div>
			<div class="inputStyle">
					菜单状态：  <input type="radio" name="menuIsvariable" style="width:40px" checked value="1">有效
    						<input type="radio" name="menuIsvariable" style="width:40px" value="0">无效
					
			</div>
			<div class="inputStyle">	
					<div>菜单描述：</div>	<textarea  name="menuComment" 
					style="height:60px;margin-left:25%"></textarea>
			</div>
		</div>
		</div>
		<div style="display:flex;">
		<div class="btnStyle" style="flex:1;">
		<input type="submit" value="提交" ></input></div>
		<div class="btnStyle" style="flex:1">
		<input type="reset" value="重置" ></input></div>
		</div>
	</form>
	
	</div>
		
</body>
</html>
