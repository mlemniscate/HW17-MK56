package ir.maktab.servlets.airline;

import ir.maktab.domain.Airline;
import ir.maktab.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineAddFlight extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureDate = request.getParameter("departure-date");
        String departureTime = request.getParameter("departure-time");
        String arrivalDate = request.getParameter("arrival-date");
        String arrivalTime = request.getParameter("arrival-time");
        String price = request.getParameter("price");

        HttpSession session = request.getSession(true);

        Airline airline = (Airline) session.getAttribute("airline");

        ApplicationContext.getAirlineService().addFlight(
                from,
                to,
                departureDate,
                departureTime,
                arrivalDate,
                arrivalTime,
                price,
                airline
        );



        PrintWriter out = response.getWriter();


    }



}
