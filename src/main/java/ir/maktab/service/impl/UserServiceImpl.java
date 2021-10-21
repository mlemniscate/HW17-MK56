package ir.maktab.service.impl;

import com.github.javafaker.Faker;
import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.AirlineFlight;
import ir.maktab.domain.Ticket;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.UserService;
import ir.maktab.util.ApplicationContext;

import java.util.Objects;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = repository.findByUsername(username);
        if(Objects.isNull(user))
            throw new NullPointerException("\n----------------------------------" +
                    "\nYour username is wrong!\n" +
                    "----------------------------------\n");
        else if(!user.getPassword().equals(password))
            throw new Exception("\n----------------------------------" +
                    "\nYour password is wrong!\n" +
                    "----------------------------------\n");
        else return user;
    }

    @Override
    public Ticket buyTicket(Long flightId, User user) throws Exception {
        Faker faker = new Faker();
        if (ApplicationContext.getAirlineFlightService().existsById(flightId)) {
            AirlineFlight flight = ApplicationContext.getAirlineFlightService().findById(flightId);
            if (flight.getPrice() <= user.getBalance()) {
                user.setBalance(user.getBalance() - flight.getPrice() - 100);
                Ticket ticket = null;
                for (int i = 0; i < flight.getSeats().size(); i++) {
                    if(Objects.isNull(flight.getSeats().get(i).getReservedUserId())){
                        flight.getSeats().get(i).setReservedUserId(user.getId());
                        ticket = buildTicket(user, faker, flight, i);
                        break;
                    }
                }
                ApplicationContext.getUserService().save(user);
                ApplicationContext.getAirlineFlightService().save(flight);
                ApplicationContext.getTicketService().save(ticket);
            } else {
                throw new Exception("Your balance isn't enough for this ticket.\nPlease charge your account and try again!");
            }
        } else {
            throw new Exception("Your ticket id is wrong!");
        }
        return null;
    }

    @Override
    public User chargeAccount(User user, Integer amount) {
        user.setBalance(user.getBalance() + amount);
        save(user);
        return user;
    }

    private Ticket buildTicket(User user, Faker faker, AirlineFlight flight, int i) {
        return Ticket.builder()
                .seatNumber(flight.getSeats().get(i).getSeatNumber())
                .ticketNumber(faker.bothify("??####"))
                .airlineFlight(flight)
                .user(user)
                .build();
    }
}
