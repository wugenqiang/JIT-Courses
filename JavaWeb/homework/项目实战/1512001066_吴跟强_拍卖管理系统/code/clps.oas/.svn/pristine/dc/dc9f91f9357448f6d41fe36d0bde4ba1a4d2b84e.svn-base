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
<div class="header"><b>菜单修改</b></div>
<hr style="width:95%" />
	<form  action="menuUpdate?menuId=${requestScope.menuInfo.menuId}&
	menuIsvariable=${requestScope.menuInfo.menuIsvariable}" 
	method="post">
	<font color="red">${requestScope.message}</font>
	<div  class="register" style=" height:430px"> 
		<div class="registerLeft">
			<div class="inputStyle">
					菜单名称：<input name="menuName" value="${requestScope.menuInfo.menuName}"></input>
					<font color="red">*</font>
			</div>
			<div class="inputStyle">
					菜单排序号：<input name="menuSortId" value="${requestScope.menuInfo.menuSortId}"></input>
					<font color="red">*</font>
			</div>
			<div class="inputStyle">
					菜单等级：<input name="menuLevel" value="${requestScope.menuInfo.menuLevel}"></input>
					<font color="red">*</font>
			</div>
			
			<div class="inputStyle">
					菜单父Id：<input name="menuParentid" value="${requestScope.menuInfo.menuParentid}"></input>
					<font color="red">*</font>
			</div>
			
			
			<div class="inputStyle">
					菜单URL：<input name="menuUrl" value="${requestScope.menuInfo.menuUrl}"></input>
					<font color="red">*</font>
			</div>
			<div class="inputStyle">	
					<div>菜单描述：</div>	<textarea  name="menuComment" 
					style="height:60px;margin-left:25%">${requestScope.menuInfo.menuComment}</textarea>
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
