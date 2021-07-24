package com.hrms.HRMS.entities.concretes;

import com.hrms.HRMS.core.constants.CandidateConstant;
import com.hrms.HRMS.core.constants.CompanyConstant;
import com.hrms.HRMS.core.constants.CvConstant;
import com.hrms.HRMS.core.constants.ExperienceConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
public class CvEntity extends BaseEntity {

    @Column(name = CvConstant.COLUMN_CV_DESCRIPTION, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String cvDescription;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = CvConstant.COLUMN_CANDIDATE_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CandidateEntity candidate;

    @OneToMany(mappedBy = "cv")
    private List<ExperienceEntity> experiences;

    @OneToMany(mappedBy = "cv")
    private List<EducationEntity> educations;

    @OneToMany(mappedBy = "cv")
    private List<LanguageEntity> languages;

    @OneToMany(mappedBy = "cv")
    private List<SocialMediaEntity> socialMedias;

    @OneToMany(mappedBy = "cv")
    private List<TechnologyEntity> technologies;
}
