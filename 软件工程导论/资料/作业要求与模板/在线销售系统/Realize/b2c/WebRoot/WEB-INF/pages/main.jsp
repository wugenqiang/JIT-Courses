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
	<title><fmt:message key="main.title" /></title>
<content tag="heading">
<fmt:message key="main.heading" />
</content>
