

	package controller;

	import jakarta.servlet.*;
	import jakarta.servlet.http.*;
	import jakarta.servlet.annotation.WebServlet;
	import java.io.IOException;

	import service.AccountService;

	@WebServlet("/transfer")
	public class TransferServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest req, HttpServletResponse res)
	            throws IOException {

	        int fromAcc = Integer.parseInt(req.getParameter("fromAcc"));
	        int toAcc = Integer.parseInt(req.getParameter("toAcc"));
	        double amount = Double.parseDouble(req.getParameter("amount"));

	        AccountService service = new AccountService();
	        boolean status = service.transfer(fromAcc, toAcc, amount);

	        if (status) {
	            res.sendRedirect("dashboard.jsp");
	        } else {
	            res.sendRedirect("transfer.jsp");
	        }
	    }
	}




