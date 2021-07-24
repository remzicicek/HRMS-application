package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.TechnologyTypeConstant;
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
@Table(name = "technology_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","technologies"})
public class TechnologyTypeEntity extends BaseEntity {

    @Column(name = TechnologyTypeConstant.COLUMN_TECHNOLOGY_TYPE_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String technologyName;

    @OneToMany(mappedBy = "technologyType")
    private List<TechnologyEntity> technologies;

}
