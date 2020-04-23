<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数显示</title>
<link href="../css/sm/parameter_list.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="content">

<form action="queryParameter" >
	<table  >
	
	<tr>
	<th>参数编号</th>
	<th>参数名称</th>
	<th>参数内容</th>
	<th>参数关联id</th>
	<th>参数描述</th>
	<th>创建人名</th>
	<th>创建日期</th>
	<th>修改人名</th>
	<th>修改日期</th>
	<th>操&nbsp;作</th>
	</tr>
	<c:forEach items="${requestScope.parameters }" var="parameter">
	<tr>
		<td>${parameter.parameterId}</td>
		<td>${parameter.parameterName}</td>	
		<td>${parameter.parameterConent}</td>		
		<td>${parameter.parameterSpuelid}</td>		
		<td>${parameter.parameterComment}</td>	
		<td>${parameter.parameterCreatedName}</td>	
		<td>${parameter.parameterCreatedDatetime}</td>
		<td>${parameter.parameterUpdatedName}</td>
		<td>${parameter.parameterUpdatedDatetime}</td>
		<td>
	<a href="parameterAdd">新增</a>|
		<a href="findParameterById?parameterId=${parameter.parameterId}">修改</a>|
		<a href="deleteParameter?parameterId=${parameter.parameterId}">删除</a></td>

</tr>
</c:forEach>
</table>
</form>
</div>
</body>
</html>