package ir.maktab.service;

import ir.maktab.base.service.BaseEntityService;
import ir.maktab.domain.Ticket;
import ir.maktab.domain.User;

public interface UserService extends BaseEntityService<User, Long> {
    User login(String username, String password) throws Exception;

    Ticket buyTicket(Long flightId, User user) throws Exception;

    User chargeAccount(User user, Integer amount);
}
