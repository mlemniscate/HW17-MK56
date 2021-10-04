package ir.maktab.service.front.menu;

import ir.maktab.domain.AirlineFlight;
import ir.maktab.domain.User;
import ir.maktab.service.front.input.InputInt;
import ir.maktab.service.front.input.InputString;
import ir.maktab.util.ApplicationContext;

import java.util.*;

public class UserMenu extends Menu implements RunnableMenu<Void> {

    private User user;
    private List<AirlineFlight> flights;

    public UserMenu(User user) {
        super(new ArrayList<>(Arrays.asList("Buy Ticket", "Chose Cities Again", "Ordered By", "Charge Account", "Exit")));
        this.user = user;
        chooseCitiesAndShow();
    }

    @Override
    public Void runMenu() {
        while (true) {
            switch (getItemFromConsole()) {
                case 1:
                    buyTicket();
                    break;
                case 2:
                    chooseCitiesAndShow();
                    break;
                case 3:
                    orderedFlightsBy();
                    break;
                case 4:
                    chargeAccount();
                    break;
                case 5:
                    if (new CheckMenu("Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }

    private void chargeAccount() {
        Integer amount = getMoneyAmount();
        user = ApplicationContext.getUserService().chargeAccount(this.user, amount);
    }

    private Integer getMoneyAmount() {
        return new InputInt("Enter your money amount you want charge: ",
                "Your amount must be in range(500,000 - 10,000,000).",
                10_000_000, 500_000, null)
                .getIntInput();
    }

    private void buyTicket() {
        Long flightId = getTicketId();
        try {
            ApplicationContext.getUserService().buyTicket(flightId, user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printMessage(String s) {
        System.out.println("--------------------------------------------------");
        System.out.println(s);
        System.out.println("--------------------------------------------------");
    }

    private Long getTicketId() {
        return Long.parseLong(
                new InputString("Enter your flight id: ")
                        .getStringInput()
        );
    }

    private void orderedFlightsBy() {
        int comparatorItem = new Menu(new ArrayList<>(Arrays.asList("Price", "Airline"))).getItemFromConsole();
        int orderItem = new Menu(new ArrayList<>(Arrays.asList("Asc", "Desc"))).getItemFromConsole();
        if (comparatorItem == 1) {
            flights.sort(Comparator.comparing(AirlineFlight::getPrice));
            if (orderItem == 2) {
                Collections.reverse(flights);
            }
        } else if (comparatorItem == 2) {
            flights.sort(Comparator.comparing(flight -> flight.getAirline().getAirlineName()));
            if (orderItem == 2) {
                Collections.reverse(flights);
            }
        }
        showFlights();
    }

    private void chooseCitiesAndShow() {
        String initialCity = getCity("From");
        String destinationCity = getCity("To");
        flights = ApplicationContext.getAirlineFlightService().findByCities(initialCity, destinationCity);
        showFlights();
    }

    private void showFlights() {
        for (int i = 0; i < flights.size(); i++) {
            printMessage(String.format("#%d: %s\n", (i + 1), flights.get(i)));
        }
    }

    private String getCity(String msg) {
        return new InputString(msg + ": ").getStringInput();
    }
}
