<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String webapp = request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="<%=webapp%>/ecside/css/ecside_style.css" />
<script type="text/javascript"
	src="<%=webapp%>/common/js/prototype_mini.js"></script>
<script type="text/javascript"
	src="<%=webapp%>/common/js/ecside_msg_utf8_cn.js"></script>
<script type="text/javascript" src="<%=webapp%>/common/js/ecside.js"></script>
<script type="text/JavaScript" src="<%=webapp%>/common/js/default.js"
	language="javascript"></script>
<title><fmt:message key="cartList.title" /></title>
<content tag="heading">
<fmt:message key="cartList.heading" />
</content>
<meta name="menu" content="CartMenu" />

<c:set var="buttons">
	<html:button property="add" onclick="javascript:add()"
		styleClass="button" value="增加">
	</html:button>
	<html:button property="edit" onclick="javascript:edit()"
		styleClass="button" value="修改">
	</html:button>
	<html:button property="del" onclick="javascript:del()"
		styleClass="button" value="删除">
	</html:button>
	<html:button property="back" onclick="history.go(-1)"
		styleClass="button" value="返回">
	</html:button>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
<input type="hidden" id="selectId" />
<ec:table width="800" items="cartList" var="c"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/cartys.html" title="购物车列表"
	sortable="true" xlsFileName="购物车.xls" classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${c.cartId}; " value="${c.cartId}" width="30"
			viewsAllowed="html" />
		<ec:column property="userId" title="用户Id " />
		<ec:column property="cartCommodityNumber" title="购物条目数量 " />
	</ec:row>
</ec:table>
<br>

<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function add(){
		var url = "editCart.html";    
		location.href=url;
}
function edit(){
 	if($('selectId').value==""){
  	alert("请选中一个购物车");			
	}
	else {
	var url = "editCart.html?id=" +$("selectId").value;    
		location.href=url;
	}
}
function del(){
	if($('selectId').value == ""){
		alert("请先选择一个购物车");
		}
	else{var selection=confirm("是否要将选中的购物车删除?");
		if(selection==true){
			var url = "editCart.html?method=delete&id=" +$("selectId").value;
			location.href=url;
		}
	}
}

</script>

<html:javascript formName="cartForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("cartList");
</script>
