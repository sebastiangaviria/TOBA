<%-- 
    Document   : account_activity
    Created on : 09-nov-2015, 10:27:01
    Author     : Setastian PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table width="100%" border="0">
            <tr>
              <td colspan="5" style="border:#CCCCCC 3px solid;">
                  <c:import url="/header.html" />
              </td>
            </tr>
            <tr>
              <td colspan="5">&nbsp;</td>
            </tr>
        </table>
        <table width="100%" border="0">
            <tr>
                <td align="center">
                    <c:if test="${sessionScope.user != null}" > 
                        <h2>Welcome ${user.firstName} ${user.lastName}</h2>
                    </c:if>
                    <c:if test="${sessionScope.user == null}" > 
                        <h2>Not Logged In</h2>
                    </c:if>
                </td>
            </tr>
            <c:forEach items = "${list}" var="list">
                <tr>
                  <td><c:out value="${list.id}"/></td>
                  <td><c:out value="${list.account}"/></td>
                  <td><c:out value="${list.amount}"/></td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="/footer.jsp" />
    </body>
</html>
