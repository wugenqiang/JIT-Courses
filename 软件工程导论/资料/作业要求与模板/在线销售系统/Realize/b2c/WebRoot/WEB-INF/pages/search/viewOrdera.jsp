<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@page import="com.sjtu.user.model.*"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.*"%>
<%@page import="com.sjtu.model.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	Commodity commodity = (Commodity) request.getAttribute("commodity");
	CartCommodity cartCommodity = (CartCommodity) request
			.getAttribute("cartCommodity");
	User user = (User) request.getAttribute("user");
	Ordera ordera=(Ordera)request.getAttribute("Ordera");
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

<title><fmt:message key="orderaDetail.title" />
</title>
<content tag="heading">
<fmt:message key="orderaDetail.heading" />
</content>
<html:form action="saveOrdera" method="post" styleId="orderaForm"
	onsubmit="return validateOrderaForm(this)"
	enctype="multipart/form-data">

	<html:hidden property="orderaId" />
	<html:hidden property="cartCommodityId" />
	<table cellpadding="" cellspacing="1" class="table" width="750">
		<%
			Commodity c = commodity;
			CartCommodity cc = cartCommodity;
		%>
		<tr>
			<td>
				商品名称:<%=(c.getCommodityName())%>
			</td>
			<td>
				商品描述:<%=(c.getDescription())%>
			</td>
		</tr>
		<tr>
			<td>
				商品单价:<%=(c.getCommodityPrice())%>
			</td>
			<td>
				商品折扣:<%=(c.getCommodityDiscount())%>
			</td>
		</tr>
		<tr>
			<td>
				订购商品数量:<%=(cc.getCommodityNumber())%>
			</td>
		</tr>
		<%%>
	</table>
		<table cellpadding="" cellspacing="1" class="table" width="750">
		<%
			User u = user;			
		%>
		<tr>
			<td>
				姓名:<%=(u.getFullName())%>
			</td>
			<td>
				电话:<%=(u.getPhoneNumber())%>
			</td>
	</tr>
	<tr>		
			<td>
				省:<%=(u.getAddress().getProvince())%>
			</td>
			<td>
				市:<%=(u.getAddress().getCity())%>
			</td>
	</tr>
	<tr>		
			<td>
				地址:<%=(u.getAddress().getAddress())%>
			</td>
	</tr>
	<tr>		
			<td>
				邮编:<%=(u.getAddress().getPostalCode())%>
			</td>
	</tr>
		<%%>
	</table>
	<table cellpadding="" cellspacing="1" class="table" width="750">
		<tr>
			<td>
				<b2c:label styleClass="desc" key="orderaForm.totalPrice" />
				<html:errors property="totalPrice" />
				<html:text property="totalPrice" styleId="totalPrice"
					styleClass="text medium" />
			</td>
			<td>
				<b2c:label styleClass="desc" key="orderaForm.totalDiscount" />
				<html:errors property="totalDiscount" />
				<html:text property="totalDiscount" styleId="totalDiscount"
					styleClass="text medium" />
			</td>
		</tr>
		<tr>
			<td>
				<b2c:label styleClass="desc" key="orderaForm.orderaTime" />
				<html:errors property="orderaTime" />
				<html:text property="orderaTime" styleId="orderaTime"
					styleClass="text medium" />
			</td>
			</tr>
	</table>
	<li class="buttonBar bottom">
		<html:button property="back" onclick="history.go(-1)"
			styleClass="button" value="返回">
		</html:button>
	</li>
</html:form>
<script type="text/javascript">
    Form.focusFirstElement($("orderaForm"));
</script>

<html:javascript formName="orderaForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
