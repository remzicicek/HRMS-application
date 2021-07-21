package com.hrms.HRMS.models.concretes;

import com.hrms.HRMS.core.enums.Gender;
import com.hrms.HRMS.models.abstracts.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateModel extends UserModel {

    private String firstName;

    private String lastName;

    private String identityNumber;

    private LocalDate birthDate;

    private Gender gender;
}
