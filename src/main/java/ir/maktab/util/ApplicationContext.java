package ir.maktab.util;

import ir.maktab.repository.*;
import ir.maktab.repository.impl.*;
import ir.maktab.service.*;
import ir.maktab.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final AccountRepository accountRepository;
    private static final AirlineFlightRepository airlineFlightRepository;
    private static final AirlineRepository airlineRepository;
    private static final SeatRepository seatRepository;
    private static final TicketRepository ticketRepository;
    private static final TransactionRepository transactionRepository;
    private static final UserRepository userRepository;

    private static final AccountService accountService;
    private static final AirlineFlightService airlineFlightService;
    private static final AirlineService airlineService;
    private static final SeatService seatService;
    private static final TicketService ticketService;
    private static final TransactionService transactionService;
    private static final UserService userService;

    static {
        EntityManager entityManager = HibernateUtil.getMainEntityManagerFactory().createEntityManager();
        accountRepository = new AccountRepositoryImpl(entityManager);
        airlineFlightRepository = new AirlineFlightRepositoryImpl(entityManager);
        airlineRepository = new AirlineRepositoryImpl(entityManager);
        seatRepository = new SeatRepositoryImpl(entityManager);
        ticketRepository = new TicketRepositoryImpl(entityManager);
        transactionRepository = new TransactionRepositoryImpl(entityManager);
        userRepository = new UserRepositoryImpl(entityManager);

        accountService = new AccountServiceImpl(accountRepository);
        airlineFlightService = new AirlineFlightServiceImpl(airlineFlightRepository);
        airlineService = new AirlineServiceImpl(airlineRepository);
        seatService = new SeatServiceImpl(seatRepository);
        ticketService = new TicketServiceImpl(ticketRepository);
        transactionService = new TransactionServiceImpl(transactionRepository);
        userService = new UserServiceImpl(userRepository);
    }

    public static AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public static AirlineFlightRepository getAirlineFlightRepository() {
        return airlineFlightRepository;
    }

    public static AirlineRepository getAirlineRepository() {
        return airlineRepository;
    }

    public static SeatRepository getSeatRepository() {
        return seatRepository;
    }

    public static TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public static TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static AccountService getAccountService() {
        return accountService;
    }

    public static AirlineFlightService getAirlineFlightService() {
        return airlineFlightService;
    }

    public static AirlineService getAirlineService() {
        return airlineService;
    }

    public static SeatService getSeatService() {
        return seatService;
    }

    public static TicketService getTicketService() {
        return ticketService;
    }

    public static TransactionService getTransactionService() {
        return transactionService;
    }

    public static UserService getUserService() {
        return userService;
    }
}
