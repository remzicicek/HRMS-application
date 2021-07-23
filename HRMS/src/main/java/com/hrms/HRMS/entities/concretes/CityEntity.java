package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.CityConstant;
import com.hrms.HRMS.core.constants.JobConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class CityEntity extends BaseEntity {

    @Column(name = CityConstant.COLUMN_CITY_NAME, length = 50, nullable = false, unique = true)
    @NotBlank
    @NotNull
    private String cityName;

    @ManyToMany(mappedBy = "cities", fetch = FetchType.LAZY)
    private List<JobAdvertisementEntity> jobAdvertisements;
}
