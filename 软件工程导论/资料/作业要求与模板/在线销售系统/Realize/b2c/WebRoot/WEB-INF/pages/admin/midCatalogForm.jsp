<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.LargeCatalog"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	List largeCatalogList = (List) request
			.getAttribute("largeCatalogList");
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
<title><fmt:message key="midCatalogDetail.title" />
</title>
<content tag="heading">
<fmt:message key="midCatalogDetail.heading" />
</content>

<html:form action="saveMidCatalog" method="post"
	styleId="midCatalogForm" onsubmit="return validateMidCatalogForm(this)">
	<ul>

		<html:hidden property="midCatalogId" />
		<table cellpadding="" cellspacing="1" class="table" width="700">
			<tr>
				<td>
					<b2c:label styleClass="desc" key="midCatalogForm.midCatalogName" />
					<html:errors property="midCatalogName" />
				</td>
				<td>
					<html:text property="midCatalogName" styleId="midCatalogName"
						styleClass="text medium" />
				</td>
				<td>
					<b2c:label styleClass="desc" key="midCatalogForm.largeCatalogId"></b2c:label>
					<html:errors property="largeCatalogId" />
				</td>
				<td>
					<html:select property="largeCatalogId" styleId="largeCatalogId"
						styleClass="text medium">
						<option>
							请选择大类别
						</option>
						<%
							Iterator it = largeCatalogList.iterator();
							while (it.hasNext()) {
								LargeCatalog l = (LargeCatalog) it.next();
						%>
						<option value="<%=(l.getLargeCatalogId())%>">
							<%=(l.getLargeCatalogName())%>
						</option>
						<%
						}
						%>
					</html:select>
				</td>
			</tr>
		</table>


		<li class="buttonBar bottom">
			<html:submit styleClass="button" property="method.save"
				onclick="bCancel=false">
				<fmt:message key="button.save" />
			</html:submit>

			<html:submit styleClass="button" property="method.delete"
				onclick="bCancel=true; return confirmDelete('MidCatalog')">
				<fmt:message key="button.delete" />
			</html:submit>

			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("midCatalogForm"));
</script>

<html:javascript formName="midCatalogForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
