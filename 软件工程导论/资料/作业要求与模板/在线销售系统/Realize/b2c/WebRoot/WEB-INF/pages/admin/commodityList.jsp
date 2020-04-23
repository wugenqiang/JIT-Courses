<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title><fmt:message key="commodityList.title" />
</title>
<content tag="heading">
<fmt:message key="commodityList.heading" />
</content>
<meta name="menu" content="CommodityMenu" />
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
<ec:table width="830" items="commodityList" var="c"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/commoditys.html"
	title="商品列表" sortable="true" xlsFileName="commodity.xls" classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${c.commodity.commodityId}; "
			value="${c.commodity.commodityId}" width="30" viewsAllowed="html" />
		<ec:column property="commodity.commodityName" title="商品名称"></ec:column>
		<ec:column property="commodity.picture" title="商品图片">
			<a href='${pageScope.c.commodity.fileaddress}' target="_blank"> <img
					src='${pageScope.c.commodity.fileaddress}' width="30" height="20" />
			</a>
		</ec:column>
		<ec:column property="smallCatalog.smallCatalogName" title="小类别名称"></ec:column>
		<ec:column property="commodity.description" title="描述"></ec:column>
		<ec:column property="commodity.commodityPrice" title="单价"></ec:column>
		<ec:column property="commodity.commodityDiscount" title="折扣"></ec:column>
		<ec:column property="commodity.productor" title="生产商"></ec:column>
	</ec:row>
</ec:table>
<br>

<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function add(){
		var url = "editCommodity.html";    
		location.href=url;
}
function edit(){
 	if($('selectId').value==""){
  	alert("请选中一件商品");			
	}
	else {
	var url = "editCommodity.html?commodityId=" +$("selectId").value;    
		location.href=url;
	}
}
function del(){
	if($('selectId').value == ""){
		alert("请先选择一件商品");
		}
	else{var selection=confirm("是否要将选中的商品删除?");
		if(selection==true){
			var url = "editCommodity.html?method=delete&commodityId=" +$("selectId").value;
			location.href=url;
		}
	}
}
</script>
<html:javascript formName="commodityForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("commodityList");
</script>
