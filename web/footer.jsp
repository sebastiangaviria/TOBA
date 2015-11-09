<%-- 
    Document   : footer
    Created on : 09-nov-2015, 11:06:55
    Author     : Sebastian PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table widht="100%">
            <tr>
                <td align="center">
                    <% 
                        GregorianCalendar currentDate = new GregorianCalendar();
                        int currentYear = currentDate.get(Calendar.YEAR);
                    %>
                    <p align="center">&copy; Copyright <%= currentYear %> Sebastian Gaviria</p>
                </td>
            </tr>
        </table>
    </body>
</html>
