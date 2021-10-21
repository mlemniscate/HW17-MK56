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
            out.println(html);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    private String html = "<!DOCTYPE html>\n" +
            "<html lang='en'>\n" +
            "  <head>\n" +
            "    <meta charset='UTF-8' />\n" +
            "    <meta http-equiv='X-UA-Compatible' content='IE=edge' />\n" +
            "    <meta name='viewport' content='width=device-width, initial-scale=1.0' />\n" +
            "    <link rel='stylesheet' href='style.css' />\n" +
            "    <title>Airline App | Airline Menu</title>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <div class='form-container'>\n" +
            "      <p><b>Add your flight service</b></p>\n" +
            "      <form class='form' method='get' action='/MK56HW17_war/airline/add-flight'>\n" +
            "        <label for='from'>From: </label>\n" +
            "        <input id='from' type='text' name='from' required />\n" +
            "        <label for='to'>To: </label>\n" +
            "        <input id='to' type='text' name='to' required />\n" +
            "        <label for='departure'>Departure Time</label>\n" +
            "        <div>\n" +
            "          <input id='departure' type='date' name='departure-date' required />\n" +
            "          <input\n" +
            "            id='departure-time'\n" +
            "            type='time'\n" +
            "            name='departure-time'\n" +
            "            required\n" +
            "          />\n" +
            "        </div>\n" +
            "        <label for='arrival'>Arrival Time</label>\n" +
            "        <div>\n" +
            "          <input id='arrival' type='date' name='arrival-date' required />\n" +
            "          <input id='arrival-time' type='time' name='arrival-time' required />\n" +
            "        </div>\n" +
            "        <label for='price'>Price</label>\n" +
            "        <input id='price' type='text' name='price' required />\n" +
            "        <button class='button' type='submit'>Add</button>\n" +
            "      </form>\n" +
            "    </div>\n" +
            "  </body>\n" +
            "</html>\n";
}
