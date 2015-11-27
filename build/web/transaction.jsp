<%-- 
    Document   : transaction
    Created on : 23-nov-2015, 2:31:14
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
                    <form action="transaction" name="form" id="form" method="post">
                    <input type="hidden" name="action" value="transaction" />
                    <table>
                        <tr>
                            <td>
                                <p>Savings balanse: ${checking.balance}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Checking balanse: ${savings.balance}</p>
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td>
                                <span>Transfer to:</span>
                            </td>
                            <td>
                                <select name="type">
                                    <option>Savings</option>
                                    <option>Checking</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Amount to transfer:</span>
                            </td>
                            <td>
                                <input type="text" value="0.00" name="amount" id="amount" style="width:100%" />
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
