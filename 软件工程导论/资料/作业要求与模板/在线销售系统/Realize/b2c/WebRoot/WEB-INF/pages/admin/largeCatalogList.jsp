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

<title><fmt:message key="largeCatalogList.title" /></title>
<content tag="heading">
<fmt:message key="largeCatalogList.heading" />
</content>
<meta name="menu" content="LargeCatalogMenu" />


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
<ec:table width="830" items="largeCatalogList" var="l"
	retrieveRowsCallback="process"
	action="${pageContext.request.contextPath}/largeCatalogs.html"
	title="商品列表" sortable="true" xlsFileName="largeCatalog.xls"
	classic="true">
	<ec:row>
		<ec:column cell="radiobox" alias="选择" sortable="false"
			onclick="$('selectId').value=${l.largeCatalogId}; "
			value="${l.largeCatalogId}" width="30" viewsAllowed="html" />
		<ec:column property="largeCatalogName" title="大类别名称"></ec:column>
	</ec:row>
</ec:table>
<br>
<c:out value="${buttons}" escapeXml="false" />
<script type="text/javascript">
function add(){
		var url = "editLargeCatalog.html";    
		location.href=url;
}
function edit(){
 	if($('selectId').value==""){
  	alert("请选中一个大类别");			
	}
	else {
	var url = "editLargeCatalog.html?l;largeCatalogId=" +$("selectId").value;    
		location.href=url;
	}
}
function del(){
	if($('selectId').value == ""){
		alert("请先选择一个大类别");
		}
	else{var selection=confirm("是否要将选中的大类别删除?");
		if(selection==true){
			var url = "editLargeCatalog.html?method=delete&largeCatalogId=" +$("selectId").value;
			location.href=url;
		}
	}
}
</script>
<html:javascript formName="largeCatalogForm" cdata="false"
	dynamicJavascript="true" staticJavascript="false" />
<script type="text/javascript">
    highlightTableRows("largeCatalogList");
</script>
