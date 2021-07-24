package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.EducationConstant;
import com.hrms.HRMS.core.constants.ExperienceConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
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
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class EducationEntity extends BaseEntity {

    @Column(name = EducationConstant.COLUMN_START_DATE, nullable = false)
    @NotBlank
    @NotNull
    private LocalDate startDate;

    @Column(name = EducationConstant.COLUMN_GRADUATION_DATE)
    private LocalDate graduationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = EducationConstant.COLUMN_SCHOOL_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private SchoolEntity school;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = EducationConstant.COLUMN_EDUCATION_TYPE_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private EducationTypeEntity educationType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = EducationConstant.COLUMN_CV_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CvEntity cv;

//    @OneToOne(mappedBy = "education")
//    private CandidateEntity candidate;
}
