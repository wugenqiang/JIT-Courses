<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>/css/department.css" rel="stylesheet" type="text/css">
<title>部门显示</title>
</head>
<body>
<div id="myDepartmentList">
	<h3>Department Info</h3>
	<a href="toAddDepartment">新增</a>
	<table border="1">
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>上级部门编号</th>
			<th>下级部门编号</th>
			<th>部门等级</th>
			<th>部门邮箱</th>
			<th>部门描述</th>
			<th>部门创建人名</th>
			<th>部门创建日期</th>
			<th>部门修改人名</th>
			<th>部门修改日期</th>
	</tr>
		<c:forEach items="${requestScope.departments}" var="department">
		<tr>
			<td>${department.depaNumber}</td>
			<td>${department.depaName}</td>
			<td>${department.depaFatherNumber}</td>
			<td>${department.depaChildNumber}</td>
			<td>${department.depaLevel}</td>
			<td>${department.depaEmail}</td>
			<td>${department.depaComment}</td>
			<td>${department.depaCreateName}</td>
			<td>${department.depaCreateDatetime}</td>
			<td>${department.depaUpdatedName}</td>
			<td>${department.depaUpdatedDatetime}</td>
			
			<td><a href="updateView?depaNumber=${department.depaNumber}">编辑</a>|<a href="delDepartment?depaNumber=${department.depaNumber}">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>