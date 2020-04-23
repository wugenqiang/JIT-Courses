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
<title><fmt:message key="cartDetail.title" /></title>
<content tag="heading">
<fmt:message key="cartDetail.heading" />
</content>

<html:form action="saveCart" method="post" styleId="cartForm"
	onsubmit="return validateCartForm(this)">
	<ul>

		<html:hidden property="cartId" />
		<table cellpadding="" cellspacing="1" class="table" width="800">
			<tr>
				<td>
					<b2c:label styleClass="desc" key="cartForm.cartCommodityNumber" />
					<html:errors property="cartCommodityNumber" />
				</td>
				<td>
					<html:text property="cartCommodityNumber"
						styleId="cartCommodityNumber" styleClass="text medium" />
				</td>
			</tr>
		</table>

		<li class="buttonBar bottom">
			<html:submit styleClass="button" property="method.save"
				onclick="bCancel=false">
				<fmt:message key="button.save" />
			</html:submit>

			<html:submit styleClass="button" property="method.delete"
				onclick="bCancel=true; return confirmDelete('Cart')">
				<fmt:message key="button.delete" />
			</html:submit>

			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("cartForm"));
</script>

<html:javascript formName="cartForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
