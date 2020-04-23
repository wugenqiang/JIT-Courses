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
<title><fmt:message key="cartCommodityList.title" /></title>
<content tag="heading">
<fmt:message key="cartCommodityList.heading" />
</content>
<meta name="menu" content="CartCommodityMenu" />

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
	<html:button property="putInOrder" onclick="javascript:putinorder()"
		styleClass="button" value="加入定单">
	</html:button>
	<html:button property="back" onclick="history.go(-1)"
		styleClass="button" value="返回">
	</html:button>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
<input type="hidden" id="selectId" />
<ec:table width="800" items="cartCommodityList" var="c"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/cartCommoditys.html"
	title="购物条目列表" sortable="true" xlsFileName="购物条目.xls" classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${c.cartCommodity.cartCommodityId}; "
			value="${c.cartCommodity.cartCommodityId}" width="30"
			viewsAllowed="html" />
		<ec:column property="commodity.commodityName" title="商品名称 " />
		<ec:column property="user.username" title="用户名 " />
		<ec:column property="cartCommodity.commodityNumber" title="商品数量"></ec:column>
	</ec:row>
</ec:table>
<br>


<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function add(){
		var url = "editCartCommodity.html";    
		location.href=url;
}
function edit(){
 	if($('selectId').value==""){
  	alert("请选中一个购物车条目");			
	}
	else {
	var url = "editCartCommodity.html?cartCommodityId=" +$("selectId").value;    
		location.href=url;
	}
}
function del(){
	if($('selectId').value == ""){
		alert("请先选择一个购物车条目");
		}
	else{var selection=confirm("是否要将选中的购物车条目删除?");
		if(selection==true){
			var url = "editCartCommodity.html?method=delete&cartCommodityId=" +$("selectId").value;
			location.href=url;
		}
	}
}
function putinorder(){
	if($('selectId').value==""){
  	alert("请选中一个购物车条目");			
	}
	else {
	var url = "editOrdera.html?cartCommodityId=" +$("selectId").value; 	
		location.href=url;
	}
}

</script>

<html:javascript formName="cartCommodityForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("cartCommodityList");
</script>
