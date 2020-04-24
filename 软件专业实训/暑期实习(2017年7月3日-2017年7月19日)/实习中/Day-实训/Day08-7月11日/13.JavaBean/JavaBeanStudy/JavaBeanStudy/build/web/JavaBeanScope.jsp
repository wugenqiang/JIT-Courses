<%-- 
    Document   : JavaBeanScope
    Created on : 2009-11-13, 10:57:55
    Author     : ibm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaBean Test</title>
    </head>
    <body>
        <jsp:useBean id="student3" scope="page" class="com.jsp.Student" />
        <%=student3.getName() %>
        <% student3.setName("temp"); %>
    </body>
</html>
