<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="../css/sm/account_list.css"">
<title>accountList</title>
</head>
<body>

	<table class="tablelist">
		<tr>
			<th colspan=16>账户信息</th>
			<th><a href="account_addView">添加新用户</a></th>
		</tr>
		<tr>
			<th>序号</th>
			<th>账号</th>
			<th>姓名</th>
			<th>邮箱</th>
			<th>省份</th>
			<th>城市</th>
			<th>地区</th>
			<th>地址</th>
			<th>电话</th>
			<th>座机</th>
			<th>角色</th>
			<th>职位</th>
			<th>部门</th>
			<th>公司</th>
			<th>创建日期</th>
			<th>修改日期</th>
			<th>操&nbsp;&nbsp;作</th>
		</tr>
		<c:forEach items="${requestScope.accounts}" var="account">
			<tr>
				<td>${account.accountId}</td>
				<td>${account.accountName}</td>
				<td>${account.accountRealName}</td>
				<td>${account.accountMail}</td>
				<td>${account.accountProvince}</td>
				<td>${account.accountCity}</td>
				<td>${account.accountDistrict}</td>
				<td>${account.accountAddress}</td>
				<td>${account.accountPhone}</td>
				<td>${account.accountTelephone}</td>
				<td>${account.accountRoleName}</td>
				<td>${account.accountPositionName}</td>
				<td>${account.accountDepartmentName}</td>
				<td>${account.accountCompanyId}</td>
				<td>${account.accountCreatedDatetime}</td>
				<td>${account.accountUpdatedDatetime}</td>
				<td><a href="account_updateView?accountId=${account.accountId}">修改</a>&nbsp;
					<a href="logicDelAccount?accountId=${account.accountId}">删除</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>