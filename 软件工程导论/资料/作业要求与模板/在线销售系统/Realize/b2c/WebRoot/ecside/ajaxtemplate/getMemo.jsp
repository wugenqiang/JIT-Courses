<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.ecside.util.ServletUtils" %>
<%
Object memo=ServletUtils.getAttributeFromMapList(request,"recordList.0.MEMO");
if (memo!=null){
%>
<div style="height:30px;border:1px solid white;padding:5px;width:100%"><%=memo%></div>
<%
}
%>
