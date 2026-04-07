package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import service.AccountService;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int accNo = Integer.parseInt(req.getParameter("accNo"));
        double amount = Double.parseDouble(req.getParameter("amount"));

        AccountService service = new AccountService();
        boolean status = service.deposit(accNo, amount);

        if (status) {
            res.sendRedirect("dashboard.jsp");
        } else {
            res.sendRedirect("deposit.jsp");
        }
    }
}
