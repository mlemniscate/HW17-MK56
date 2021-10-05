package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = BaseUser.TABLE_NAME)
@Inheritance
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseUser extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String BALANCE = "balance";

    @Column(name = USERNAME)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = BALANCE)
    private Integer balance;
}
