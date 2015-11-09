<%-- 
    Document   : password_reset
    Created on : 09-nov-2015, 10:08:15
    Author     : Sebastian PC
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
        <table width="100%">
            <tr>
                <td width="33%">&nbsp;</td>
                <td width="33%" align="center">
                    <form action="new_customer" name="form" id="form" method="post">
                    <input type="hidden" name="action" value="update" />
                    <table>
                        <tr>
                            <td>
                                <input type="text" value="${user.password}" name="password" id="password" style="width:100%" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="save" id="save" value="Save"/>
                            </td>
                        </tr>
                    </table>
                    </form>
                </td>
                <td width="33%">&nbsp;</td>
            </tr>
        </table>
        <c:import url="/footer.jsp" />
    </body>
</html>
