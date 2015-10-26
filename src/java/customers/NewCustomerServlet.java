package customers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

            if(FirstName.equals("") || LastName.equals("") || Phone.equals("") || Address.equals("") || City.equals("") || State.equals("") || Zipcode.equals("") || Email.equals("")){
                String message="Please fill out all the form fields";
                RequestDispatcher rd = request.getRequestDispatcher("/new_customer.html");
                rd.include(request, response);
                response.setContentType("text/html");
                out.println("<table width=\"100%\"><tr><td align=\"center\"><h1>"+message+"</h1></td></tr></table>");

            }else{
                String message="The account has been successfully created";
                RequestDispatcher rd = request.getRequestDispatcher("/success.html");
                rd.include(request, response);
                response.setContentType("text/html");
                out.println("<table width=\"100%\"><tr><td align=\"center\"><h1>"+message+"</h1></td></tr></table>");
            }
        }
        
    }

}
