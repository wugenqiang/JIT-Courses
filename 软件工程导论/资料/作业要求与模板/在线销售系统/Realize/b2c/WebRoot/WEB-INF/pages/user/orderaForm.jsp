<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.user.model.CartCommodity"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	List cartCommodityList = (List) request
			.getAttribute("cartCommodityList");
	String cartCommodityId = request.getParameter("cartCommodityId");
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
<title><fmt:message key="orderaDetail.title" /></title>
<content tag="heading">
<fmt:message key="orderaDetail.heading" />
</content>

<html:form action="saveOrdera" method="post" styleId="orderaForm"
	onsubmit="return validateOrderaForm(this)">
	<ul>

		<html:hidden property="orderaId" />
		<html:hidden property="cartCommodityId" />

		<li class="buttonBar bottom">
			<html:button property="save" onclick="javascript:savem()"
				styleClass="button">
				<fmt:message key="button.save" />
			</html:button>


			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderaForm"));
</script>
<script type="text/javascript">
function savem(){
	var form = document.forms[0];
    form.action="saveOrdera.html?method=save&cartCommodityId="+<%=cartCommodityId%>; 
    form.submit();  
}
</script>

<html:javascript formName="orderaForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
