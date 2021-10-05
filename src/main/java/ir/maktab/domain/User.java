package ir.maktab.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseUser {

    public static final String TABLE_NAME = "users";
    public static final String EMAIL = "email";
    public static final String MOBILE_PHONE_NUMBER = "mobile_phone_number";
    public static final String BALANCE = "balance";

    @Column(name = EMAIL)
    private String email;

    @Column(name = MOBILE_PHONE_NUMBER)
    private String mobilePhoneNumber;

    @Column(name = BALANCE)
    private Integer balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

}