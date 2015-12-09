<%-- 
    Document   : reports
    Created on : 05-dic-2015, 4:39:35
    Author     : Sebastian PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="now" class="java.util.Date">
        <s:date name="now" var="formattedDate" format="dd-MM-yyyy"/>
        <s:textfield name="date" value="%{formattedDate}"/>
        <table>
            <c:forEach items = "${list}" var="list">
                <tr>
                  <td><c:out value="${list.userName}"/></td>
                  <td><c:out value="${list.firstName} ${list.lastName}"/></td>
                  <td><c:out value="${list.username}"/></td>
                  <td><c:out value="${list.registered}"/></td>
                </tr>
            </c:forEach>
        </table>
        <table>
            <tr>
                <td>
                    <form action="report" method="post">
                        <input type="hidden" value="spreadsheet" name="report">
                        <input type="submit" value="View As Spreadsheet" id="submit">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>