package ir.maktab.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Airline extends BaseUser {

    public static final String AIRLINE_NAME = "airline_name";

    @Column(name = AIRLINE_NAME)
    private String airlineName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "airline_id")
    private List<AirlineFlight> flights = new ArrayList<>();

    @Builder(builderMethodName = "airlineBuilder")
    public Airline(String username, String password, String airlineName, Integer balance) {
        super(username, password, balance);
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {
        return airlineName;
    }
}
