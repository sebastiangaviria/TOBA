package login;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=request.getParameter("user");
        String password=request.getParameter("password");
        if(username.equals("jsmith@toba.com") && password.equals("letmein")){
            RequestDispatcher rd = request.getRequestDispatcher("/account_activity.html");
            rd.include(request, response);
            //request.getRequestDispatcher("account_activity.html");
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/login_failure.html");
            rd.include(request, response);
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
