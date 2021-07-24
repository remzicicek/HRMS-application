package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.SchoolConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

// Hacettepe vs

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})
public class SchoolEntity extends BaseEntity {

    @Column(name = SchoolConstant.COLUMN_SCHOOL_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String schoolName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = SchoolConstant.COLUMN_SCHOOL_TYPE, referencedColumnName = "id", nullable = false, updatable = false)
    private SchoolTypeEntity schoolType;

    @OneToMany(mappedBy = "school")
    private List<EducationEntity> educations;

}
