<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/sm/account_form.css" rel="stylesheet" type="text/css" />
<title>updateAccount</title>
<script type="text/javascript">
	function checkForm() {
		
		var AccountPwd = document.forms["addAccount"]["AccountPwd"].value;
		var rePwd = document.forms["addAccount"]["AccountPwd"].value;
		var AccountMail = document.forms["addAccount"]["AccountMail"].value;
		
		
		if(AccountPwd != rePwd){
			document.getElementById("passSpan").innerHTML = " 密码不一致";
			}
		
		var atpos=AccountMail.indexOf("@");
		var dotpos=AccountMail.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=AccountMail.length){
			alert("不是一个有效的 e-mail地址");
	  		return false;
		}
	}
</script>
</head>
<body>
	<div id="header">
		<h1 class="center">更新账户</h1>
	</div>
	<div class="container">
		<form action="updateAccount?accountId=${account.accountId}"
			class="from1" name="updateAccount" onsubmit="return checkForm();"
			method="post">
			<table>

				<tr>
					<td>账号:</td>
					<td><input type="text" name="accountName" required="required"
						value="${account.accountName}"><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>账户密码 :</td>
					<td><input type="password" name="accountPwd"
						required="required" value="${account.accountPass}"><span
						style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="password" name="rePwd" required="required"
						value="${account.accountPass}"><span id="passSpan"></span><span
						style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="accountRealName"
						value="${account.accountRealName}"><br></td>
				</tr>
				<tr>
					<td>用户邮箱:</td>
					<td><input type="text" name="accountMail" required="required"
						value="${account.accountMail}"><span style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>省份:</td>
					<td><select name="accountProvince">
							<option value="江苏省">江苏省</option>
							<option value="${account.accountProvince}" selected>${account.accountProvince}</option>
					</select><br></td>
				</tr>
				<tr></tr>
				<tr></tr>

				<tr>
					<td>城市:</td>
					<td><select name="accountCity">
							<option value="南京市">南京市</option>
							<option value="上海市">上海市</option>
							<option value="${account.accountCity}" selected>${account.accountCity}</option>
					</select><span style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>

				<tr>
					<td>区县:</td>
					<td><select name="accountDistrict">
							<option value="江宁" selected>江宁</option>
							<option value="鼓楼">鼓楼</option>
							<option value="${account.accountDistrict}" selected>${account.accountDistrict}</option>
					</select><span style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>

				<tr>
					<td>地址:</td>
					<td><textarea rows="10" cols="20" name="accountAddress">${account.accountAddress}</textarea><span
						style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>电话:</td>
					<td><input type="text" name="accountPhone"
						value="${account.accountPhone}"><span style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>座机:</td>
					<td><input type="text" name="accountTelephone"
						value="${account.accountTelephone}"><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>角色:</td>
					<td><select name="accountRoleId">
							<option value="1">普通用户</option>
							<option value="2">超级管理员</option>
							<option value="3">客服管理员</option>
							<option value="${account.accountRoleId}" selected></option>
					</select><span style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>用户职位:</td>
					<td><select name="accountPositionId" required="required">
							<option value="1">初级工程师</option>
							<option value="2">中级工程师</option>
							<option value="3">高级工程师</option>
							<option value="${account.accountPositionId}" selected></option>
					</select><span style="color: red">&nbsp;&nbsp;*</span><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>部门:</td>
					<td><select name="accountDepartmentId">
							<option value="1">技术部门</option>
							<option value="2">HR</option>
							<option value="3">设计部门</option>
							<option value="${account.accountDepartmentId}" selected></option>
					</select><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>公司:</td>
					<td><select name="accountCompanyId">
							<option value="1">金陵科技学院1</option>
							<option value="2">金陵科技学院2</option>
							<option value="3">金陵科技学院3</option>
							<option value="${account.accountCompanyId}" selected></option>
					</select><br></td>
				</tr>
				<tr></tr>
				<tr></tr>
			</table>

			<div>
				<p>
					<input type="submit" value="保存"></input>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
