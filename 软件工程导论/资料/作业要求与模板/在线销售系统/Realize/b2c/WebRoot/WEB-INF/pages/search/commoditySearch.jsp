<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.SmallCatalog"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	List smallCatalogList = (List) request
			.getAttribute("smallCatalogList");
	//List midCatalogList = (List) request.getAttribute("midCatalogList");
	//List largeCatalogList = (List) request
	//.getAttribute("largeCatalogList");
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
<meta name="menu" content="commodityMenu" />

<html:form action="saveCommodity" method="post" styleId="commodityForm"
	onsubmit="return validateCommodityForm(this)"
	enctype="multipart/form-data">
	<tr>
		<td>
			<html:select property="smallCatalogId" styleId="smallCatalogId"
				styleClass="text medium">
				<option value="">
					请选择类别
				</option>
				<%
					Iterator it = smallCatalogList.iterator();
					while (it.hasNext()) {
						SmallCatalog s = (SmallCatalog) it.next();
				%>
				<option value="<%=(s.getSmallCatalogId())%>">
					<%=(s.getSmallCatalogName())%>
				</option>
				<%
				}
				%>
			</html:select>
		</td>
		<c:set var="buttons">
			<html:button property="searchm"
				onclick="javascript:searchCommodity()" styleClass="button"
				value="查询"></html:button>
			<html:button property="viewCommodity" onclick="javascript:edits()"
				styleClass="button" value="查看商品">
			</html:button>
			<html:button property="putInCart" onclick="javascript:putincart()"
				styleClass="button" value="加入购物车">
			</html:button>
		</c:set>
		<c:out value="${buttons}" escapeXml="false" />
	</tr>

</html:form>
<input type="hidden" id="selectId" />

<ec:table width="750" items="commodityList" var="c"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/commoditys.html"
	title="商品列表" sortable="true" classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${c.commodity.commodityId}; "
			value="${c.commodity.commodityId}" width="30" viewsAllowed="html" />
		<ec:column property="commodity.commodityName" title="商品名称">
		</ec:column>
		<ec:column property="commodity.picture" title="商品图片">
			<a href='${pageScope.c.commodity.fileaddress}' target="_blank"> <img
					src='${pageScope.c.commodity.fileaddress}' width="30" height="20" />
			</a>
		</ec:column>
		<ec:column property="commodity.commodityPrice" title="现价"></ec:column>
		<ec:column property="commodity.commodityDiscount" title="折扣"></ec:column>
		<ec:column property="commodity.productor" title="生产商"></ec:column>
		<ec:column property="cartCommodityId" title="放进购物车">
			<a href="editCartCommodity.html">放进购物车</a>
		</ec:column>
	</ec:row>
</ec:table>
<br>
<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function searchCommodity(){
	var form=document.forms[0];
	form.action="searchCommodity.html?method=search";
	form.submit();
}
function edits(){
 	if($('selectId').value==""){
  	alert("请选中一件商品");			
	}
	else {
	var url = "viewCommodity.html?commodityId=" +$("selectId").value;    
		location.href=url;
	}
}
function putincart(){
	if($('selectId').value==""){
  	alert("请选中一件商品");			
	}
	else {
	var url = "editCartCommodity.html?commodityId=" +$("selectId").value;    
		location.href=url;
	}
}
</script>


<html:javascript formName="commodityForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("commodityList");
</script>