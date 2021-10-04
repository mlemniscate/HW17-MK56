package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.domain.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = Account.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends BaseEntity<Long> {

    public static final String TABLE_NAME = "accounts";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String BIRTH_DATE = "birth_date";
    public static final String NATIONAL_CODE = "national_code";
    public static final String PHONE_NUMBER = "phone_number";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = GENDER)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = BIRTH_DATE)
    private LocalDate birthDate;

    @Column(name = NATIONAL_CODE)
    private String nationalCode;

    @Column(name = PHONE_NUMBER)
    private String phoneNumber;

}
