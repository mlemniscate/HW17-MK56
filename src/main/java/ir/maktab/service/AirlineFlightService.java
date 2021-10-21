package ir.maktab.service;

import ir.maktab.base.service.BaseEntityService;
import ir.maktab.domain.AirlineFlight;

import java.util.List;

public interface AirlineFlightService extends BaseEntityService<AirlineFlight, Long> {

    List<AirlineFlight> findByAirlineId(Long airlineId);

    List<AirlineFlight> findByCities(String initialCity, String destinationCity);
}
