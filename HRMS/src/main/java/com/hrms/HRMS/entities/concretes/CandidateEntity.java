package com.hrms.HRMS.entities.concretes;

import com.hrms.HRMS.core.constants.CandidateConstant;
import com.hrms.HRMS.core.enums.Gender;
import com.hrms.HRMS.entities.abstracts.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates"
//        uniqueConstraints =
//            @UniqueConstraint( columnNames =
//                    {
//                       CandidateConstraint.COLUMN_TC_NO,
//                       UserConstraint.COLUMN_EMAIL,
//                       UserConstraint.COLUMN_TELEPHONE_NUMBER
//                    }
//            )
            )
public class CandidateEntity extends UserEntity {

    @Column(name = CandidateConstant.COLUMN_FIRST_NAME, length = 50, nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = CandidateConstant.COLUMN_LAST_NAME, length = 50, nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = CandidateConstant.COLUMN_IDENTITITY_NUMBER, length = 13, nullable = false, unique = true)
    @NotBlank
    private String identityNumber;

    @Column(name = CandidateConstant.COLUMN_BIRTH_DATE, nullable = false)
    @NotNull
    private LocalDate birthDate;

    @Column(name = CandidateConstant.COLUMN_GENDER, length = 6)
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
