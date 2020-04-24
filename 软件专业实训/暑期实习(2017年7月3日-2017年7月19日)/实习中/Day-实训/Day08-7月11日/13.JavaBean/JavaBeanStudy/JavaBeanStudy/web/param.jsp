<%-- 
    Document   : param
    Created on : 2009-11-13, 10:35:57
    Author     : ibm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("gb2312"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>利用请求参数设置javabean属性</title>
    </head>
    <body>
        <jsp:useBean id="student2" scope="page" class="com.jsp.Student" />
        <jsp:setProperty name="student2" property="name" param="UserName" />
        <jsp:setProperty name="student2" property="age" param="age" />
        <jsp:setProperty name="student2" property="major" param="major" />
        <table >
        <tr>
            <td>姓名</td>
            <td><jsp:getProperty name="student2" property="name" /></td>
        </tr>
         <tr>
            <td>年龄</td>
            <td><jsp:getProperty name="student2" property="age" /></td>
        </tr>
         <tr>
            <td>专业</td>
            <td><jsp:getProperty name="student2" property="major" /></td>
        </tr>
        </table>
    </body>
</html>
