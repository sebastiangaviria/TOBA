<%-- 
    Document   : success
    Created on : 09-nov-2015, 9:42:08
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
        <table>
            <tr>
                <td>
                    <p>First Name: ${user["firstName"]}</p>
                    <p>Last Name: ${user["lastName"]}</p>
                    <p>Phone: ${user["phone"]}</p>
                    <p>Address: ${user["address"]}</p>
                    <p>City: ${user["city"]}</p>
                    <p>State: ${user["state"]}</p>
                    <p>Zipcode: ${user["zipcode"]}</p>
                    <p>Email: ${user["email"]}</p>
                    <p>Username: ${user["username"]}</p>
                    <p>Password: ${user["password"]}</p>
                </td>
            </tr>
        </table>
        <c:import url="/footer.jsp" />
    </body>
</html>
