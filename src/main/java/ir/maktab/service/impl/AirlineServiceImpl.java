package ir.maktab.service.impl;

import ir.maktab.domain.Airline;
import ir.maktab.repository.AirlineRepository;
import ir.maktab.service.AirlineService;

import java.util.Objects;

public class AirlineServiceImpl extends BaseUserServiceImpl implements AirlineService {

    public AirlineServiceImpl(AirlineRepository repository) {
        super(repository);
    }


    @Override
    public Airline login(String username, String password) throws Exception {
        Airline airline = (Airline) repository.findByUsername(username);
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
}
