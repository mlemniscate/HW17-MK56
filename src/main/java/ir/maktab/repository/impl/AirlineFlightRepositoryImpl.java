package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.AirlineFlight;
import ir.maktab.repository.AirlineFlightRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AirlineFlightRepositoryImpl extends BaseEntityRepositoryImpl<AirlineFlight, Long> implements AirlineFlightRepository {

    public AirlineFlightRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<AirlineFlight> getEntityClass() {
        return AirlineFlight.class;
    }

    @Override
    public List<AirlineFlight> findByAirlineId(Long airlineId) {
        return getEntityManager().createQuery(
                " from AirlineFlight a where a.airline.id = :airline_id", AirlineFlight.class)
                .setParameter("airline_id", airlineId)
                .getResultList();
    }

    @Override
    public List<AirlineFlight> findByCities(String initialCity, String destinationCity) {
        return getEntityManager().createQuery(
                " from AirlineFlight a " +
                        "where a.initialPoint = :initial and " +
                        "a.destination = :destination", AirlineFlight.class)
                .setParameter("initial", initialCity)
                .setParameter("destination", destinationCity)
                .getResultList();
    }
}
