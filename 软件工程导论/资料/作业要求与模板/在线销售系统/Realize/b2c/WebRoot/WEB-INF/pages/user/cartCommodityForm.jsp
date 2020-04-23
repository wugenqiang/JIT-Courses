<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.Commodity"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	List commodityList = (List) request.getAttribute("commodityList");
	String commodityId = request.getParameter("commodityId");
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
<title><fmt:message key="cartCommodityDetail.title" /></title>
<content tag="heading">
<fmt:message key="cartCommodityDetail.heading" />
</content>

<html:form action="saveCartCommodity" method="post"
	styleId="cartCommodityForm"
	onsubmit="return validateCartCommodityForm(this)"
	enctype="multipart/form-data">
	<ul>

		<html:hidden property="cartCommodityId" />
		<html:hidden property="commodityId" />
		<html:hidden property="userId" />
		<table cellpadding="" cellspacing="1" class="table" width="800">
			<tr>
				<td>
					<b2c:label styleClass="desc"
						key="cartCommodityForm.commodityNumber" />
					<html:errors property="commodityNumber" />
				</td>
				<td>
					<html:text property="commodityNumber" styleId="commodityNumber"
						styleClass="text medium" />

				</td>
			</tr>
		</table>

		<li class="buttonBar bottom">
			<html:button property="save" onclick="javascript:savem()"
				styleClass="button">
				<fmt:message key="button.save" />
			</html:button>


			<html:submit styleClass="button" property="method.delete"
				onclick="bCancel=true; return confirmDelete('CartCommodity')">
				<fmt:message key="button.delete" />
			</html:submit>

			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("cartCommodityForm"));
</script>
<script type="text/javascript">
function savem(){
var form = document.forms[0];
        	form.action="saveCartCommodity.html?method=save&commodityId="+<%=commodityId%>; 
        	form.submit();  
}
</script>

<html:javascript formName="cartCommodityForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
