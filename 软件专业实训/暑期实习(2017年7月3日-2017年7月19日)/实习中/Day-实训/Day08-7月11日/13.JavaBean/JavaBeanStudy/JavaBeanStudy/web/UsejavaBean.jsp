<%-- 
    Document   : UsejavaBean
    Created on : 2009-9-24, 16:44:51
    Author     : ibm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="student1" scope="page" class="com.jsp.Student" />
        利用标记获得javabean的属性：
        <jsp:getProperty name="student1" property="name"/>
        <br>
        利用对象方法获取javabean的属性
        <%=student1.getName()%>
          <br>
        利用标记设计javabean属性name的值：
        <jsp:setProperty name="student1" property="name" value="temp" />
        获取新属性：
        <%=student1.getName()%>
        <br>
          利用标记设计javabean属性age的值：
        <jsp:setProperty name="student1" property="age" value="12" />
        获取新属性：
        <%=student1.getAge()%>
    </body>
</html>
