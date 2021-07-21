package com.hrms.HRMS.models;

import com.hrms.HRMS.core.enums.Gender;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

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
