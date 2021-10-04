package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Seat;
import ir.maktab.repository.SeatRepository;
import ir.maktab.service.SeatService;

public class SeatServiceImpl extends BaseEntityServiceImpl<Seat, Long, SeatRepository> implements SeatService {

    public SeatServiceImpl(SeatRepository repository) {
        super(repository);
    }

}
