<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sjtu.admin.model.SmallCatalog"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String webapp = request.getContextPath();
	List smallCatalogList = (List) request
			.getAttribute("smallCatalogList");
%>
<link rel="stylesheet" type="text/css" media="all"
	href="<%=webapp%>/common/calendar/skins/aqua/theme.css" />
<link rel="stylesheet" type="text/css"
	href="<%=webapp%>/ecside/css/ecside_style.css" />
<script type="text/javascript"
	src="<%=webapp%>/common/js/prototype_mini.js"></script>
<script type="text/javascript"
	src="<%=webapp%>/common/js/ecside_msg_utf8_cn.js"></script>
<title><fmt:message key="commodityDetail.title" /></title>
<content tag="heading">
<fmt:message key="commodityDetail.heading" />
</content>

<html:form action="saveCommodity" method="post" styleId="commodityForm"
	onsubmit="return validateCommodityForm(this)"
	enctype="multipart/form-data">
	<ul>

		<html:hidden property="commodityId" />
		<table cellpadding="" cellspacing="1" class="table" width="800">
			<tr>
				<td>
					<b2c:label styleClass="desc" key="commodityForm.commodityName" />
					<html:errors property="commodityName" />
				</td>
				<td>
					<html:text property="commodityName" styleId="commodityName"
						styleClass="text medium" />
				</td>
				<td>

					<b2c:label styleClass="desc" key="commodityForm.smallCatalogId" />
					<html:errors property="smallCatalogId" />
				</td>
				<td>
					<html:select property="smallCatalogId" styleId="smallCatalogId"
						styleClass="text medium">
						<option>
							请选择小类别
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
			</tr>
			<tr>
				<td>


					<b2c:label styleClass="desc" key="commodityForm.commodityPrice" />
					<html:errors property="commodityPrice" />
				</td>
				<td>
					<html:text property="commodityPrice" styleId="commodityPrice"
						styleClass="text medium" />
				</td>
				<td>
					<b2c:label styleClass="desc" key="commodityForm.commodityDiscount" />
					<html:errors property="commodityDiscount" />
				</td>
				<td>
					<html:text property="commodityDiscount" styleId="commodityDiscount"
						styleClass="text medium" />

				</td>
			</tr>

			<tr>
				<td>

					<b2c:label styleClass="desc" key="commodityForm.productor" />
					<html:errors property="productor" />
				</td>
				<td>
					<html:text property="productor" styleId="productor"
						styleClass="text medium" />
				</td>
				<td>
					<b2c:label styleClass="desc" key="commodityForm.file" />
					<html:errors property="file" />
				</td>
				<td>
					<html:file property="file" styleId="file" styleClass="text medium" />
				</td>
			</tr>
			<tr>
				<td>
					<b2c:label styleClass="desc" key="commodityForm.description" />
					<html:errors property="description" />
				</td>
				<td>
					<html:textarea property="description" styleId="description"
						rows="3" />
				</td>
			</tr>
		</table>

		<li class="buttonBar bottom">
			<html:submit styleClass="button" property="method.save"
				onclick="bCancel=false">
				<fmt:message key="button.save" />
			</html:submit>

			<html:submit styleClass="button" property="method.delete"
				onclick="bCancel=true; return confirmDelete('Commodity')">
				<fmt:message key="button.delete" />
			</html:submit>

			<html:cancel styleClass="button" onclick="bCancel=true">
				<fmt:message key="button.cancel" />
			</html:cancel>
		</li>
	</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("commodityForm"));
</script>

<html:javascript formName="commodityForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript"
	src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
