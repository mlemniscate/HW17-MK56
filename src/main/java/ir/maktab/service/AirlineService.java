package ir.maktab.service;

import ir.maktab.domain.Airline;

public interface AirlineService extends BaseUserService {

    Airline login(String username, String password) throws Exception;

}
