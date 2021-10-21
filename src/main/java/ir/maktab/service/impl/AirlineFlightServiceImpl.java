package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.AirlineFlight;
import ir.maktab.repository.AirlineFlightRepository;
import ir.maktab.service.AirlineFlightService;

import java.util.List;
import java.util.Objects;

public class AirlineFlightServiceImpl extends BaseEntityServiceImpl<AirlineFlight, Long, AirlineFlightRepository> implements AirlineFlightService {

    public AirlineFlightServiceImpl(AirlineFlightRepository repository) {
        super(repository);
    }


    @Override
    public List<AirlineFlight> findByAirlineId(Long airlineId) {
        return repository.findByAirlineId(airlineId);
    }

    @Override
    public List<AirlineFlight> findByCities(String initialCity, String destinationCity) {
        List<AirlineFlight> flights = repository.findByCities(initialCity, destinationCity);
        flights.forEach(item -> {
            int fullSeatCounter = 0;
            for (int i = 0; i < item.getSeats().size(); i++) {
                if(!Objects.isNull(item.getSeats().get(i).getReservedUserId())) fullSeatCounter++;
            }
            if(fullSeatCounter == item.getSeats().size()) flights.remove(item);
        });
        return flights;
    }
}
