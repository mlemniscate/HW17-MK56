package ir.maktab.service.front.menu;

import com.github.javafaker.Faker;
import ir.maktab.domain.Airline;
import ir.maktab.domain.AirlineFlight;
import ir.maktab.domain.Seat;
import ir.maktab.service.front.input.InputString;
import ir.maktab.util.ApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.IntStream;

public class AirlineMenu extends Menu implements RunnableMenu<Void> {

    private final Airline airline;
    Faker faker = new Faker();

    public AirlineMenu(Airline airline) {
        super(new ArrayList<>(Arrays.asList("Show Flights", "Add New Flight", "Exit")));
        this.airline = airline;
        showAirlineFlights();
    }

    @Override
    public Void runMenu() {
        while (true) {
            switch (getItemFromConsole()) {
                case 1:
                    showAirlineFlights();
                    break;
                case 2:
                    addNewFlight();
                    break;
                case 3:
                    if (new CheckMenu("Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }

    private void addNewFlight() {
        AirlineFlight airlineFlight = buildAirlineFlight();
        airlineFlight = ApplicationContext.getAirlineFlightService().save(airlineFlight);
        if(airlineFlight.getId() != null)
            System.out.println("\n---------------------------------------" +
                    "\nYour flight add successfully!\n" +
                    "---------------------------------------\n");
    }

    private AirlineFlight buildAirlineFlight() {
        LocalDateTime departureTime = getRandomLocalDateTime();
        return AirlineFlight.builder()
                .airline(airline)
                .aircraftModel(faker.aviation().aircraft())
                .airplaneNumber(faker.bothify("?####"))
                .initialPoint(getCity("Initial Point"))
                .destination(getCity("Destination"))
                .departureTime(departureTime)
                .arrivalTime(departureTime.plusHours(5))
                .flightNumber(faker.bothify("###??"))
                .seats(getSeats())
                .price(faker.number().numberBetween(500_000, 1_000_000))
                .build();
    }

    private LocalDateTime getRandomLocalDateTime() {
        return faker.date().between(
                new GregorianCalendar(2021, 11, 20).getTime(),
                new GregorianCalendar(2022, 2, 20).getTime()
        ).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private String getCity(String point) {
        return new InputString("Enter your " + point + " City: ")
                .getStringInput();
    }

    private static List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();
        IntStream.range(1, 41).forEach(item -> seats.add(
                Seat.builder().seatNumber(item + "").build()
        ));
        return seats;
    }

    private void showAirlineFlights() {
        List<AirlineFlight> flights = ApplicationContext.getAirlineFlightService().findByAirlineId(airline.getId());
        for (int i = 0; i < flights.size(); i++) {
            System.out.println("--------------------------------------------------");
            System.out.printf("#%d: %s\n", (i+1),flights.get(i));
            System.out.println("--------------------------------------------------");
        }
    }
}
