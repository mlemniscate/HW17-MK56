package ir.maktab.repository;

import ir.maktab.base.repository.BaseEntityRepository;
import ir.maktab.domain.Airline;

public interface AirlineRepository extends BaseEntityRepository<Airline, Long> {
    Airline findByUsername(String username);
}
