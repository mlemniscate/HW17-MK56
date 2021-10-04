package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";
    public static final String EMAIL = "email";
    public static final String MOBILE_PHONE_NUMBER = "mobile_phone_number";
    public static final String BALANCE = "balance";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Column(name = USERNAME, unique = true, nullable = false)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    private String password;

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