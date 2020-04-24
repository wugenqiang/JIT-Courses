// 全局变量a和b，分别获取用户名框和密码框的value值
var a = document.getElementsByTagName("input").item(0);
var b = document.getElementsByTagName("input").item(1);

function submitTest() {
	if(!a.value) { 
		document.getElementById("remind_1").innerHTML = "请输入用户名！";
		return false;
	} 
	if(!b.value) { 
		document.getElementById("remind_2").innerHTML = "请输入密码！";
		return false;
	}
	return true;
}

//用户框验证value值
function oBlur_1() {
	if(!a.value) { 
		document.getElementById("remind_1").innerHTML = "请输入用户名！";
	} 
	else {
		document.getElementById("remind_1").innerHTML = "";
	}
}

//密码框验证value值
function oBlur_2() {
	if(!b.value) {
		document.getElementById("remind_2").innerHTML = "请输入密码！";
	} 
	else { 
		document.getElementById("remind_2").innerHTML = "";
	}
}

//用户框获得焦点的隐藏提醒
function oFocus_1() {
	document.getElementById("remind_1").innerHTML = "";
}

//密码框获得焦点的隐藏提醒
function oFocus_2() {
	document.getElementById("remind_2").innerHTML = "";
}

