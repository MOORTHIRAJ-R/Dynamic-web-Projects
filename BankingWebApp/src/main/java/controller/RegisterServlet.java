package controller;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService service = new UserService();
        boolean status = service.register(username, password);

        if (status) {
            res.sendRedirect("login.jsp");
        } else {
            res.sendRedirect("register.jsp");
        }
    }
}
