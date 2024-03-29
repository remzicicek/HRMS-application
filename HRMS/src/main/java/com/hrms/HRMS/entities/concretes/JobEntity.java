package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.JobConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobEntity extends BaseEntity {

    @Column(name = JobConstant.COLUMN_JOB_TITLE, length = 50, nullable = false, unique = true)
    @NotBlank
    @NotNull
    private String jobTitle;

    @ManyToMany(mappedBy = "jobs", fetch = FetchType.LAZY)
    private List<JobAdvertisementEntity> jobAdvertisements = new ArrayList<>();

}
