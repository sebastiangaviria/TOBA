package customers;

import business.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.User;
import business.Account;
import data.AccountDB;
import data.UserDB;
//@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
        if(request.getParameter("action").equals("save")){
            String FirstName=request.getParameter("FirstName");
            String LastName=request.getParameter("LastName");
            String Phone=request.getParameter("Phone");
            String Address=request.getParameter("Address");
            String City=request.getParameter("City");
            String State=request.getParameter("State");
            String Zipcode=request.getParameter("Zipcode");
            String Email=request.getParameter("Email");
            String Username =LastName + Zipcode;
            String Password = "welcome1";
            
            User user = new User(FirstName, LastName, Phone, Address, City, State, Zipcode, Email, Username, Password);
            Account savings=new Account(Account.Type.SAVINGS, 25.00, user);
            Account checking=new Account(Account.Type.CHECKING, 0.00, user);
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if(FirstName.equals("") || LastName.equals("") || Phone.equals("") || Address.equals("") || City.equals("") || State.equals("") || Zipcode.equals("") || Email.equals("")){
                String message="Please fill out all the form fields";
                RequestDispatcher rd = request.getRequestDispatcher("/new_customer.html");
                rd.include(request, response);
                response.setContentType("text/html");
                out.println("<table width=\"100%\"><tr><td align=\"center\"><h1>"+message+"</h1></td></tr></table>");

            }else{
                String message="The account has been successfully created";
                RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
                UserDB.insert(user);
                AccountDB.insert(savings);
                AccountDB.insert(checking);
                rd.include(request, response);
                response.setContentType("text/html");
                out.println("<table width=\"100%\"><tr><td align=\"center\"><h1>"+message+"</h1></td></tr></table>");
            }
        }else if(request.getParameter("action").equals("update")){
            String Password = request.getParameter("password");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if(user == null){
                user = new User();
            }
            user.setPassword(Password);
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("/account_activity.jsp");
            UserDB.update(user);
            rd.include(request, response);
        }
        
    }

}
