<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.MidCatalog"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	List midCatalogList = (List) request.getAttribute("midCatalogList");
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
<title><fmt:message key="smallCatalogDetail.title" />
</title>
<content tag="heading">
<fmt:message key="smallCatalogDetail.heading" />
</content>

<html:form action="saveSmallCatalog" method="post"
	styleId="smallCatalogForm"
	onsubmit="return validateSmallCatalogForm(this)">
	<ul>

		<html:hidden property="smallCatalogId" />
		<table cellpadding="" cellspacing="1" class="table" width="700">
			<tr>
				<td>

					<b2c:label styleClass="desc"
						key="smallCatalogForm.smallCatalogName" />
					<html:errors property="smallCatalogName" />
				</td>
				<td>
					<html:text property="smallCatalogName" styleId="smallCatalogName"
						styleClass="text medium" />
				</td>
				<td>

					<b2c:label styleClass="desc" key="smallCatalogForm.midCatalogId"></b2c:label>
					<html:errors property="midCatalogId" />
				</td>
				<td>
					<html:select property="midCatalogId" styleId="midCatalogId"
						styleClass="text medium">
						<option>
							请选择中类别
						</option>
						<%
							Iterator it = midCatalogList.iterator();
							while (it.hasNext()) {
								MidCatalog m = (MidCatalog) it.next();
						%>
						<option value="<%=(m.getMidCatalogId())%>">
							<%=(m.getMidCatalogName())%>
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
				onclick="bCancel=true; return confirmDelete('SmallCatalog')">
				<fmt:message key="button.delete" />
			</html:submit>

			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("smallCatalogForm"));
</script>

<html:javascript formName="smallCatalogForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
