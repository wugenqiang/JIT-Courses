<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
String path=request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数修改</title>
<link href="../css/sm/parameter_add.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="header" >
     <h1 class="center" >参数修改</h1></div>
     
<div class="container" >
	<form action="updateParameter" name="updateParameter"  class="from1" method="post">
		用户名称:<input type="text"  name="parameterName"  value="${requestScope.parameter.parameterName }" ><font style="color:red">*</font><br/>
        
		参数内容:<input style="width:150px;height:50px;" name="parameterConent"  value="${requestScope.parameter.parameterConent }"><br/>
		<font style="color:red">*</font><br/>
		
		关联参数:
		<select name="parameterSpuelid" >
				<option value="${requestScope.parameter.parameterSpuelid }" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
		</select><br/>
		 
		参数描述:<input style="width:250px;height:100px;"  name="parameterComment"  value="${requestScope.parameter.parameterComment }"><br/>
		
		<input type="submit" name="submit" value="提交">
		<input type="reset" name="reset" value="重置">
	</form>

</div>

</body>
</html>

