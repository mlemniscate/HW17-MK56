package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Ticket;
import ir.maktab.repository.TicketRepository;
import ir.maktab.service.TicketService;

public class TicketServiceImpl extends BaseEntityServiceImpl<Ticket, Long, TicketRepository> implements TicketService {

    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

}
