<%-- 
    Document   : error_404.jsp
    Created on : 24-oct-2015, 13:30:17
    Author     : Esteban PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 
<% response.setStatus(404); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR 404! Page not found.</h1>
    </body>
</html>
