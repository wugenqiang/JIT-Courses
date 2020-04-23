<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link href="../css/sm/menu.css" rel="stylesheet" type="text/css"/>
  <style type="text/css">
  
  a{
            height: 21px;
            line-height: 21px;
            padding: 0 11px;
       		background-color:#3F3F3F;
            border: 1px #3F3F3F solid;
            border-radius: 3px;
            /*color: #fff;*/
            display: inline-block;
            text-decoration: none;
            font-size: 12px;
            outline: none;
            color:#fff;
   }
    
  
  </style>
</head>

<body>
<div style="display:flex;">
	<div class="header" style="flex:2"><b>菜单信息表</b></div>
	<div style="flex:1">
	<form action="<%=request.getContextPath() %>/sm/menu_list" method="GET">
			<select name="date">
					<option value="0">全部</option>
					<option value="7">近七天</option>
					<option value="30">近三十天</option>
					
			</select>
			<input name="keyWord"></input>
			<input type="submit" value="查询"></input>
	</div>
</div>
		<table class="dataintable">
			<tr>
			<th>编号</th>
			<th>名称</th>
			<th>排序号</th>
			<th>等级</th>
			<th>父Id</th>
			<th>状态</th>
			<th>描述</th>
			<th>创建日期</th>
			<th>创建人名</th>
			<th>修改日期</th>
			<th>修改人名</th>
			<th>操作</th>
			</tr>
	<c:forEach items="${requestScope.listMenu}" var="menu">
 	<tr>
		<td>${menu.menuId}</td>
		<td>${menu.menuName}</td>
		<td>${menu.menuSortId}</td>
		<td>${menu.menuLevel}</td>
		<td>${menu.menuParentid}</td>
		<td>${menu.menuIsvariable}</td>
		<td>${menu.menuComment}</td>
		<td>${menu.menuCreatedDatetime}</td>
		<td>${menu.menuCreatedName}</td>
		<td>${menu.menuUpdatedDatetime}</td>
		<td>${menu.menuUpdatedName}</td>
		<td><a href="<%=request.getContextPath() %>/sm/menu_add?menuLevel=${menu.menuLevel}&menuId=${menu.menuId}">添加子菜单</a>
		<a href="<%=request.getContextPath() %>/sm/findMenuById?menuId=${menu.menuId}">修改</a>
		<a href="<%=request.getContextPath() %>/sm/changeMenuState?menuId=${menu.menuId}">启用删除</a>
		</td>
	</tr>
	</c:forEach>

</table>
</form>

</body>
</html>