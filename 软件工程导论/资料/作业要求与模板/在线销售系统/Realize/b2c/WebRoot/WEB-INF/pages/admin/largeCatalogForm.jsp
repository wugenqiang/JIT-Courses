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
<title><fmt:message key="largeCatalogDetail.title" /></title>
<content tag="heading">
<fmt:message key="largeCatalogDetail.heading" />
</content>

<html:form action="saveLargeCatalog" method="post"
	styleId="largeCatalogForm"
	onsubmit="return validateLargeCatalogForm(this)">
	<ul>

		<html:hidden property="largeCatalogId" />
		<table cellpadding="" cellspacing="1" class="table" width="700">
			<tr>
				<td>
					<b2c:label styleClass="desc"
						key="largeCatalogForm.largeCatalogName" />
					<html:errors property="largeCatalogName" />
				</td>
				<td>
					<html:text property="largeCatalogName" styleId="largeCatalogName"
						styleClass="text medium" />
				</td>
			</tr>
		</table>


		<li class="buttonBar bottom">
			<html:submit styleClass="button" property="method.save"
				onclick="bCancel=false">
				<fmt:message key="button.save" />
			</html:submit>

			<html:submit styleClass="button" property="method.delete"
				onclick="bCancel=true; return confirmDelete('LargeCatalog')">
				<fmt:message key="button.delete" />
			</html:submit>

			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("largeCatalogForm"));
</script>

<html:javascript formName="largeCatalogForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
