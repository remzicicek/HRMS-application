package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.EducationTypeConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

// Lisan, lise vs
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "education_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})
public class EducationTypeEntity extends BaseEntity {

    @Column(name = EducationTypeConstant.COLUMN_EDUCATION_TYPE_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String educationTypeName;

    @Column(name = EducationTypeConstant.COLUMN_DEPARTMENT_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String departmentName;

    @OneToMany(mappedBy = "educationType")
    private List<EducationEntity> educations;

}
