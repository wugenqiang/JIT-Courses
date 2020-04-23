<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<a href="sm/positionList">positionList.jsp</a><br/>
<a href="sm/positionAdd">positionAdd.jsp</a><br/>
<a href="sm/accountList">accountList.jsp</a><br/>
<a href="sm/sendemailList">sendemailList.jsp</a><br/>
<a href="sm/departmentList">departmentList.jsp</a><br/>
<a href="sm/menu_list">menu_list.jsp</a><br/>
<a href="<%=request.getContextPath() %>/sm/parameterList">parameters.jsp</a><br/>
<a href="file/fileUpload">file_upload.jsp</a><br/>
<a href="excel/positionVo_list">positionVo_list.jsp</a><br/>

</body>
</html>
