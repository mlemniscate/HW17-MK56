package ir.maktab.servlets;

import ir.maktab.domain.Airline;
import ir.maktab.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlinePage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("airline-username");
        String password = request.getParameter("airline-password");
        HttpSession session = request.getSession(true);

        PrintWriter out = response.getWriter();
        try {
            Airline airline = ApplicationContext.getAirlineService().login(username, password);
            session.setAttribute("airline", airline);
            out.println(airline);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}
