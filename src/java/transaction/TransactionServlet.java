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
                    Transaction transaction = new Transaction(Double.parseDouble(Amount));
                    User user = new User();
                    Account account = new Account();
                    AccountDB.select(user.getId());
                    Account savings=new Account(Account.Type.SAVINGS);
                    savings.debit(Double.parseDouble(Amount));
                    AccountDB.select(user.getId());
                    Account checking=new Account(Account.Type.CHECKING);
                    checking.credit(Double.parseDouble(Amount));
                    RequestDispatcher rd = request.getRequestDispatcher("/account_activity.jsp");
                    AccountDB.update(account);
                    List<Transaction> list = AccountDB.AllTransactions(account);
                }else{
                    Transaction transaction = new Transaction(Double.parseDouble(Amount));
                    User user = new User();
                    Account account = new Account();
                    AccountDB.select(user.getId());
                    Account savings=new Account(Account.Type.SAVINGS);
                    savings.credit(Double.parseDouble(Amount));
                    AccountDB.select(user.getId());
                    Account checking=new Account(Account.Type.CHECKING);
                    checking.debit(Double.parseDouble(Amount));
                    RequestDispatcher rd = request.getRequestDispatcher("/account_activity.jsp");
                    AccountDB.update(account);
                    List<Transaction> list = AccountDB.AllTransactions(account);
                }
                
            }
        }
    }


}
