package ir.maktab.service;

import ir.maktab.base.service.BaseEntityService;
import ir.maktab.domain.Airline;

public interface AirlineService extends BaseEntityService<Airline, Long> {

    Airline login(String username, String password) throws Exception;

}
