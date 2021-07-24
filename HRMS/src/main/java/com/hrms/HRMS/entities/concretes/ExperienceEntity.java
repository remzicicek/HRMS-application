package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class ExperienceEntity extends BaseEntity {

    @Column(name = ExperienceConstant.COLUMN_START_DATE, nullable = false)
    @NotBlank
    @NotNull
    private LocalDate startDate;

    @Column(name = ExperienceConstant.COLUMN_END_DATE)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = ExperienceConstant.COLUMN_JOB_POSITION, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private JobPositionEntity jobPosition;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = ExperienceConstant.COLUMN_COMPANY_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = ExperienceConstant.COLUMN_CV_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CvEntity cv;

}
