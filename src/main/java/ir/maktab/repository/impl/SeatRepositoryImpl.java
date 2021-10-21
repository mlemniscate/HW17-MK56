package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.Seat;
import ir.maktab.repository.SeatRepository;

import javax.persistence.EntityManager;

public class SeatRepositoryImpl extends BaseEntityRepositoryImpl<Seat, Long> implements SeatRepository {

    public SeatRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Seat> getEntityClass() {
        return Seat.class;
    }
}
