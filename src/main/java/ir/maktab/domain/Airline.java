package ir.maktab.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airline extends BaseUser {

    public static final String AIRLINE_NAME = "airline_name";
    public static final String BALANCE = "balance";

    @Column(name = AIRLINE_NAME)
    private String airlineName;

    @Column(name = BALANCE)
    private Integer balance;

    @Override
    public String toString() {
        return airlineName;
    }
}
