package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.LanguageTypeConstant;
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
@Table(name = "language_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","languages"})
public class LanguageTypeEntity extends BaseEntity {

    @Column(name = LanguageTypeConstant.COLUMN_LANGUAGE_TYPE_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String languageName;

    @OneToMany(mappedBy = "languageType")
    private List<LanguageEntity> languages;

}
