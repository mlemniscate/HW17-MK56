package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tickets";
    public static final String TICKET_NUMBER = "ticket_number";
    public static final String SEAT_NUMBER = "seat_number";

    @Column(name = TICKET_NUMBER)
    private String ticketNumber;

    @Column(name = SEAT_NUMBER)
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "airline_flight_id")
    private AirlineFlight airlineFlight;

}