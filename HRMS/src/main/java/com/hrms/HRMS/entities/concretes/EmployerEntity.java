package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.EmployerConstant;
import com.hrms.HRMS.entities.abstracts.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class EmployerEntity extends UserEntity {

    @Column(name = EmployerConstant.COLUMN_COMPANY_NAME, length = 50, nullable = false)
    @NotBlank
    private String companyName;

    @Column(name = EmployerConstant.COLUMN_COMPANY_WEBSITE, length = 50, nullable = false, unique = true)
    @NotBlank
    private String companyWebsite;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisementEntity> jobAdvertisements;

}
