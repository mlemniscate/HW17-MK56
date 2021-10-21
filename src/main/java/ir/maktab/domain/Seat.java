package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Seat.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat extends BaseEntity<Long> {

    public static final String TABLE_NAME = "seats";
    public static final String SEAT_NUMBER = "seat_number";
    public static final String RESERVED_USER_ID = "reserved_user_id";

    @Column(name = SEAT_NUMBER)
    private String seatNumber;

    @Column(name = RESERVED_USER_ID)
    private Long reservedUserId;

}
