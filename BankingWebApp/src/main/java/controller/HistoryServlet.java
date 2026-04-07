package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import dao.TransactionDAO;
import model.Transaction;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int accNo = Integer.parseInt(req.getParameter("accNo"));

        TransactionDAO dao = new TransactionDAO();
        List<Transaction> list = dao.getTransactions(accNo);

        req.setAttribute("transactions", list);
        RequestDispatcher rd = req.getRequestDispatcher("history.jsp");
        rd.forward(req, res);
    }
    
 
}
