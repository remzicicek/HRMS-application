package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.JobPositionConstant;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","experiences"})
public class JobPositionEntity extends BaseEntity {

    @Column(name = JobPositionConstant.COLUMN_JOB_POSTION_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String positionName;

    @OneToMany(mappedBy = "jobPosition")
    private List<ExperienceEntity> experiences;

}
