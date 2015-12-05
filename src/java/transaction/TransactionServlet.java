package transaction;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Transaction;
import business.Account;
import business.User;
import data.AccountDB;
import java.util.List;
import javax.servlet.RequestDispatcher;
//@WebServlet(urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
        if(request.getParameter("action").equals("transaction")){            
            
            String Amount=request.getParameter("amount");
            String type = request.getParameter("type");
            
            if(!Amount.equals("") && !Amount.equals("0") && !Amount.equals("0.0") && !Amount.equals("0.00")){
                if(type.equals("Savings")){
                    User user = (User)request.getSession().getAttribute("user");
                    Account savings = AccountDB.findByUser(user.getId(), Account.Type.SAVINGS);
                    Account checking = AccountDB.findByUser(user.getId(), Account.Type.CHECKING);
                    savings.debit(Double.parseDouble(Amount));
                    checking.credit(Double.parseDouble(Amount));
                    RequestDispatcher rd = request.getRequestDispatcher("/account_activity.jsp");
                    AccountDB.update(savings);
                    AccountDB.update(checking);
                    List<Transaction> list = AccountDB.AllTransactions(savings);
                }else{
                    User user = (User)request.getSession().getAttribute("user");
                    Account savings = AccountDB.findByUser(user.getId(), Account.Type.SAVINGS);
                    Account checking = AccountDB.findByUser(user.getId(), Account.Type.CHECKING);
                    checking.debit(Double.parseDouble(Amount));
                    savings.credit(Double.parseDouble(Amount));
                    RequestDispatcher rd = request.getRequestDispatcher("/account_activity.jsp");
                    AccountDB.update(savings);
                    AccountDB.update(checking);
                    List<Transaction> list = AccountDB.AllTransactions(checking);
                }
                
            }
        }
    }


}
