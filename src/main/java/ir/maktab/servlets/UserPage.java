package ir.maktab.servlets;

import ir.maktab.domain.User;
import ir.maktab.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user-username");
        String password = request.getParameter("user-password");
        HttpSession session = request.getSession(true);

        PrintWriter out = response.getWriter();
        try {
            User user = ApplicationContext.getUserService().login(username, password);
            session.setAttribute("user", user);

        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}
