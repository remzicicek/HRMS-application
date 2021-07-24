package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.SchoolTypeConstant;
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

// University vs
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools"})
public class SchoolTypeEntity extends BaseEntity {

    @Column(name = SchoolTypeConstant.COLUMN_SCHOOL_TYPE_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String schoolTypeName;

    @OneToMany(mappedBy = "schoolType")
    private List<SchoolEntity> schools;
}
