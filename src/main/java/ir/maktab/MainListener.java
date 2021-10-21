package ir.maktab;

import com.github.javafaker.Faker;
import ir.maktab.domain.*;
import ir.maktab.domain.enums.Gender;
import ir.maktab.util.ApplicationContext;
import ir.maktab.util.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class MainListener implements ServletContextListener {
    private static final Faker faker = new Faker();


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.getMainEntityManagerFactory().createEntityManager();
//        enterAirlines();
//        enterUsers();
    }

    private static void enterUsers() {
        User userFake = buildUser("userfake");
        ApplicationContext.getUserService().save(userFake);
        IntStream.range(1, 51).forEach(item -> {
            User user = buildUser(faker.name().username());
            ApplicationContext.getUserService().save(user);
        });
    }

    private static User buildUser(String username) {
        return User.userBuilder()
                .account(buildAccount())
                .username(username)
                .password("123456")
                .email(faker.internet().emailAddress())
                .balance(600_000)
                .mobilePhoneNumber(faker.phoneNumber().phoneNumber())
                .build();
    }

    private static Account buildAccount() {
        return Account.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .gender(Gender.randomGender())
                .birthDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .nationalCode(faker.numerify("##########"))
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .build();
    }

    private static void enterAirlineFlights(Airline airline) {
        Faker fakerCountry = new Faker(new Locale("tr"));
        IntStream.range(1, 11).forEach(item -> {
            AirlineFlight airlineFlight = buildAirlineFlight(fakerCountry, airline);
            ApplicationContext.getAirlineFlightService().save(airlineFlight);
        });
    }

    private static AirlineFlight buildAirlineFlight(Faker fakerTr, Airline airline) {
        LocalDateTime departureTime = getRandomLocalDateTime();
        return AirlineFlight.builder()
                .airline(airline)
                .aircraftModel(faker.aviation().aircraft())
                .airplaneNumber(faker.bothify("?####"))
                .initialPoint(fakerTr.address().cityName())
                .destination(fakerTr.address().cityName())
                .departureTime(departureTime)
                .arrivalTime(departureTime.plusHours(6))
                .flightNumber(faker.bothify("###??"))
                .seats(getSeats())
                .price(faker.number().numberBetween(500_000, 1_000_000))
                .build();
    }

    private static List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();
        IntStream.range(1, 41).forEach(item -> seats.add(
                Seat.builder().seatNumber(item + "").build()
        ));
        return seats;
    }

    private static LocalDateTime getRandomLocalDateTime() {
        return faker.date().between(
                new GregorianCalendar(2021, 10, 20).getTime(),
                new GregorianCalendar(2022, 5, 20).getTime()
        ).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static void enterAirlines() {
        IntStream.range(0, 5).forEach(item -> {
            Airline airline = buildAirline();
            enterAirlineFlights(airline);
        });
    }

    private static Airline buildAirline() {
        return Airline.airlineBuilder()
                .airlineName(faker.company().name())
                .balance(faker.number().numberBetween(500_000, 1_000_000_000))
                .username(faker.name().username())
                .password("123456")
                .build();
    }
}
