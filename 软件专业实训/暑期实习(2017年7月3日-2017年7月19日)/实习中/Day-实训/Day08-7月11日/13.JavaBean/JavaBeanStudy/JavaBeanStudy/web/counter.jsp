<%-- 
    Document   : counter
    Created on : 2009-11-13, 11:03:49
    Author     : ibm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" %>

<html>
<head>
<title>网页计数器</title>
</head>
<body bgcolor="#FFFFFF">
<jsp:useBean id="counter" scope="application" class="com.jsp.Counter" />
<center>当前页面访问次数：
<jsp:getProperty name="counter" property="count" />
</center>
</body>
</html>

