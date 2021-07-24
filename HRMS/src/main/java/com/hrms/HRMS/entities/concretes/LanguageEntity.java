package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.EducationConstant;
import com.hrms.HRMS.core.constants.LanguageConstant;
import com.hrms.HRMS.core.enums.LanguageLevel;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class LanguageEntity extends BaseEntity {

    @Column(name = LanguageConstant.COLUMN_LANGUAGE_LEVEL, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private LanguageLevel languageLevel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = LanguageConstant.COLUMN_LANGUAGE_TYPE_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private LanguageTypeEntity languageType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = LanguageConstant.COLUMN_CV_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CvEntity cv;
}
