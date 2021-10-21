package ir.maktab.service.impl;

import com.github.javafaker.Faker;
import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Airline;
import ir.maktab.domain.AirlineFlight;
import ir.maktab.domain.Seat;
import ir.maktab.repository.AirlineRepository;
import ir.maktab.service.AirlineService;
import ir.maktab.util.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class AirlineServiceImpl extends BaseEntityServiceImpl<Airline, Long, AirlineRepository> implements AirlineService {

    public AirlineServiceImpl(AirlineRepository repository) {
        super(repository);
    }


    @Override
    public Airline login(String username, String password) throws Exception {
        Airline airline = repository.findByUsername(username);
        if(Objects.isNull(airline))
            throw new NullPointerException("\n----------------------------------" +
                    "\nYour username is wrong!\n" +
                    "----------------------------------\n");
        else if(!airline.getPassword().equals(password))
            throw new Exception("\n----------------------------------" +
                    "\nYour password is wrong!\n" +
                    "----------------------------------\n");
        else return airline;
    }

    @Override
    public void addFlight(String from, String to, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String price, Airline airline) {
        LocalDateTime departureLocalDateTime = getLocalDateTime(departureDate, departureTime);
        LocalDateTime arrivalLocalDateTime = getLocalDateTime(arrivalDate, arrivalTime);

        AirlineFlight airlineFlight = buildAirlineFlight(from, to, price, airline, departureLocalDateTime, arrivalLocalDateTime);
        airline.getFlights().add(airlineFlight);
        ApplicationContext.getAirlineService().save(airline);
    }

    private LocalDateTime getLocalDateTime(String someDate, String someTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = format.parse(someDate + " " + someTime);
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AirlineFlight buildAirlineFlight(String from, String to, String price, Airline airline,
                                             LocalDateTime departureLocalDateTime, LocalDateTime arrivalLocalDateTime) {
        Faker faker = new Faker();
        return AirlineFlight.builder()
                .airline(airline)
                .aircraftModel(faker.aviation().aircraft())
                .airplaneNumber(faker.bothify("?####"))
                .initialPoint(from)
                .destination(to)
                .departureTime(departureLocalDateTime)
                .arrivalTime(arrivalLocalDateTime)
                .flightNumber(faker.bothify("###??"))
                .seats(getSeats())
                .price(Integer.parseInt(price))
                .build();
    }

    private static List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();
        IntStream.range(1, 41).forEach(item -> seats.add(
                Seat.builder().seatNumber(item + "").build()
        ));
        return seats;
    }

}
