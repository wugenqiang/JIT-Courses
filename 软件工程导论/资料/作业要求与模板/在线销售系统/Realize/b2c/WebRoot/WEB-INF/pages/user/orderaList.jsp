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
<title><fmt:message key="orderaList.title" /></title>
<content tag="heading">
<fmt:message key="orderaList.heading" />
</content>
<meta name="menu" content="OrderaMenu" />

<c:set var="buttons">
	<html:button property="add" onclick="javascript:view()"
		styleClass="button" value="查看">
	</html:button>
	<html:button property="back" onclick="history.go(-1)"
		styleClass="button" value="返回">
	</html:button>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
<input type="hidden" id="selectId" />
<ec:table width="800" items="orderaList" var="c"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/orderas.html" title="订单列表"
	sortable="true" xlsFileName="订单.xls" classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${c.ordera.orderaId}; "
			value="${c.ordera.orderaId}" width="30" viewsAllowed="html" />
		<ec:column property="user.username" title="用户名 " />		
		<ec:column property="commodity.commodityName" title="商品名称"></ec:column>
		<ec:column property="cartCommodity.commodityNumber" title="商品数量" />
		<ec:column property="ordera.totalPrice" title="总价 " />
		<ec:column property="ordera.totalDiscount" title="总折扣"></ec:column>
		<ec:column property="ordera.orderaTime" title="订单时间"></ec:column>
	</ec:row>
</ec:table>
<br>

<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function view(){
if($('selectId').value==""){
  	alert("请选中一个订单");			
	}
	else {
	var url = "viewOrdera.html?orderaId=" +$("selectId").value;    
		location.href=url;
	}		
}
</script>

<html:javascript formName="orderaForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("orderaList");
</script>
