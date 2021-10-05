package ir.maktab.repository;

import ir.maktab.domain.Airline;

public interface AirlineRepository extends BaseUserRepository {
    Airline findByUsername(String username);
}
