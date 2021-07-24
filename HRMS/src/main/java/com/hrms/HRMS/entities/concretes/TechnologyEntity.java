package com.hrms.HRMS.entities.concretes;

import com.hrms.HRMS.core.constants.SocialMediaConstant;
import com.hrms.HRMS.core.constants.TechnologyConstant;
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
@Table(name = "technologies")
public class TechnologyEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = TechnologyConstant.COLUMN_TECHNOLOGY_TYPE_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private TechnologyTypeEntity technologyType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = TechnologyConstant.COLUMN_CV_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CvEntity cv;
}
