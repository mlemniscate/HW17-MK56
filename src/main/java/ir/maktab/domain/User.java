package ir.maktab.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseUser {

    public static final String TABLE_NAME = "users";
    public static final String EMAIL = "email";
    public static final String MOBILE_PHONE_NUMBER = "mobile_phone_number";

    @Column(name = EMAIL)
    private String email;

    @Column(name = MOBILE_PHONE_NUMBER)
    private String mobilePhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder(builderMethodName = "userBuilder")
    public User(String username, String password, String email, String mobilePhoneNumber, Integer balance, Account account) {
        super(username, password, balance);
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.account = account;
    }
}