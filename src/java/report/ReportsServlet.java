/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import business.User;
import data.UserDB;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.*;

public class ReportsServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LocalDateTime month = LocalDateTime.now();
        User user = (User)request.getSession().getAttribute("user");
        List<User> list = UserDB.UserByDate(user, month);
        String report = request.getParameter("report");
        if(report.equals("spreadsheet")){
            
        }
    }
}
