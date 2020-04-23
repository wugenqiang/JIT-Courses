<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String webapp = request.getContextPath();
SmallCatalog smallCatalog = (SmallCatalog) request.getAttribute("smallCatalog");
%>
<link rel="stylesheet" type="text/css" media="all"
	href="<%=webapp%>/common/calendar/skins/aqua/theme.css" />
<link rel="stylesheet" type="text/css"
	href="<%=webapp%>/ecside/css/ecside_style.css" />
<script type="text/javascript"
	src="<%=webapp%>/common/js/prototype_mini.js"></script>
<script type="text/javascript"
	src="<%=webapp%>/common/js/ecside_msg_utf8_cn.js"></script>
<script type="text/javascript" src="<%=webapp%>/common/js/ecside.js"></script>

<title><fmt:message key="commodityDetail.title" /></title>
<content tag="heading">
<fmt:message key="commodityDetail.heading" />
</content>

<html:form action="saveCommodity" method="post" styleId="commodityForm"
	onsubmit="return validateCommodityForm(this)"
	enctype="multipart/form-data">

	<html:hidden property="commodityId" />
	<table cellpadding="" cellspacing="1" class="table" width="750">
		<tr>
			<td>
				<b2c:label styleClass="desc" key="commodityForm.commodityName" />
				<html:errors property="commodityName" />
				<html:text property="commodityName" styleId="commodityName"
					styleClass="text medium" />
			</td>
			
			<%
			SmallCatalog s=smallCatalog;		
		%>
		<td>
		商品类别：<%=(s.getSmallCatalogName())%>
		</td>
		<% %>
			</tr>
			<tr>
			<td>

				<b2c:label styleClass="desc" key="commodityForm.productor" />
				<html:errors property="productor" />
				<html:text property="productor" styleId="productor"
					styleClass="text medium" />
			</td>		
			<td>
				<b2c:label styleClass="desc" key="commodityForm.commodityPrice" />
				<html:errors property="commodityPrice" />
				<html:text property="commodityPrice" styleId="commodityPrice"
					styleClass="text medium" />
			</td>
			</tr>
			<tr>
			<td>
				<b2c:label styleClass="desc" key="commodityForm.commodityDiscount" />
				<html:errors property="commodityDiscount" />
				<html:text property="commodityDiscount" styleId="commodityDiscount"
					styleClass="text medium" />
			</td>		
			<td>
				<b2c:label styleClass="desc" key="commodityForm.description" />
				<html:errors property="description" />
				<html:textarea property="description" styleId="description" rows="3" />
			</td>
		</tr>
	</table>
	<li class="buttonBar bottom">
		<html:button property="back" onclick="history.go(-1)"
			styleClass="button" value="返回">
		</html:button>
		<html:button property="putInCart" onclick="javascript:putincart()"
				styleClass="button" value="加入购物车">
			</html:button>
	</li>
</html:form>
<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function putincart(){	
	var url = "editCartCommodity.html?commodityId=" +commodityForm.getCommodityId();    
		location.href=url;	
}
</script>
<script type="text/javascript">
    Form.focusFirstElement($("commodityForm"));
</script>

<html:javascript formName="commodityForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>