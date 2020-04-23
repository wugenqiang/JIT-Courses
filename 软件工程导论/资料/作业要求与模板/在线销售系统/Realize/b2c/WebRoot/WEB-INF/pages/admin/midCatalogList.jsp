<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title><fmt:message key="midCatalogList.title" /></title>
<content tag="heading">
<fmt:message key="midCatalogList.heading" />
</content>
<meta name="menu" content="MidCatalogMenu" />

<c:set var="buttons">
	<html:button property="add" onclick="javascript:add()"
		styleClass="button" value="增加">
	</html:button>
	<html:button property="edit" onclick="javascript:edit()"
		styleClass="button" value="修改">
	</html:button>
	<html:button property="del" onclick="javascript:del()"
		styleClass="button" value="删除">
	</html:button>
	<html:button property="back" onclick="history.go(-1)"
		styleClass="button" value="返回">
	</html:button>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
<input type="hidden" id="selectId" />
<ec:table width="830" items="midCatalogList" var="m"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/midCatalogs.html"
	title="商品列表" sortable="true" xlsFileName="midCatalog.xls"
	classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${m.midCatalog.midCatalogId}; "
			value="${m.midCatalog.midCatalogId}" width="30" viewsAllowed="html" />
		<ec:column property="midCatalog.midCatalogName" title="中类别名称"></ec:column>
		<ec:column property="largeCatalog.largeCatalogName" title="大类别名称"></ec:column>
	</ec:row>
</ec:table>
<br>
<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function add(){
		var url = "editMidCatalog.html";    
		location.href=url;
}
function edit(){
 	if($('selectId').value==""){
  	alert("请选中一个中类别");			
	}
	else {
	var url = "editMidCatalog.html?midCatalogId=" +$("selectId").value;    
		location.href=url;
	}
}
function del(){
	if($('selectId').value == ""){
		alert("请先选择一个中类别");
		}
	else{var selection=confirm("是否要将选中的中类别删除?");
		if(selection==true){
			var url = "editMidCatalog.html?method=delete&midCatalogId=" +$("selectId").value;
			location.href=url;
		}
	}
}
</script>
<html:javascript formName="midCatalogForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("midCatalogList");
</script>
