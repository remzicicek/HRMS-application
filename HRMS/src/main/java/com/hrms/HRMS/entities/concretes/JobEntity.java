package com.hrms.HRMS.entities.concretes;

import com.hrms.HRMS.core.constants.JobConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class JobEntity extends BaseEntity {

    @Column(name = JobConstant.COLUMN_JOB_TITLE, length = 50, nullable = false, unique = true)
    @NotBlank
    @NotNull
    private String jobTitle;

    // @Lob means that Length is 255
    @Lob
    @Column(name = JobConstant.COLUMN_DESCRIPTION)
    @NotBlank
    @NotNull
    private String description;

    @Column(name = JobConstant.COLUMN_MININMUM_SALARY, nullable = false)
    @NotNull
    private Double minSalary;

    @Column(name = JobConstant.COLUMN_MAXIMUM_SALARY, nullable = false)
    @NotNull
    private Double maxSalary;

    @Column(name = JobConstant.COLUMN_EMPLOYEE_QUOTA, nullable = false)
    @NotNull
    private Integer employeeQuota;

}
