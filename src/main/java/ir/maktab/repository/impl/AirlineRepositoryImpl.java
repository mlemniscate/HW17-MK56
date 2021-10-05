package ir.maktab.repository.impl;

import ir.maktab.domain.Airline;
import ir.maktab.repository.AirlineRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AirlineRepositoryImpl extends BaseUserRepositoryImpl implements AirlineRepository {

    public AirlineRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Airline findByUsername(String username) {
        List<Airline> list = getEntityManager().createQuery(
                "select a from Airline a where a.username = :username", Airline.class)
                .setParameter("username", username)
                .getResultList();
        if(list.size() > 0) return list.get(0);
        else return null;
    }
}
