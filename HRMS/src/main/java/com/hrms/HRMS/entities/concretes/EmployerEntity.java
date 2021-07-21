package com.hrms.HRMS.entities.concretes;

import com.hrms.HRMS.core.constraint.CandidateConstraint;
import com.hrms.HRMS.core.constraint.EmployerConstraint;
import com.hrms.HRMS.entities.abstracts.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class EmployerEntity extends UserEntity {

    @Column(name = EmployerConstraint.COLUMN_COMPANY_NAME, length = 50, nullable = false)
    @NotBlank
    private String companyName;

    @Column(name = EmployerConstraint.COLUMN_COMPANY_WEBSITE, length = 50, nullable = false, unique = true)
    @NotBlank
    private String companyWebsite;

}
