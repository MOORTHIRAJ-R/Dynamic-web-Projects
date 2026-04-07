package controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AccountService;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int accNo = Integer.parseInt(req.getParameter("accNo"));
        double amount = Double.parseDouble(req.getParameter("amount"));

        AccountService service = new AccountService();
        boolean status = service.withdraw(accNo, amount);

        if (status) {
            res.sendRedirect("dashboard.jsp");
        } else {
            res.sendRedirect("withdraw.jsp");
        }
    }
}
