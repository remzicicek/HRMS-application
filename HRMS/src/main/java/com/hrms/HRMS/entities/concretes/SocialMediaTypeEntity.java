package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.SocialMediaTypeConstant;
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
// github, linkedIn vs

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "social_media_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","socialMedias"})
public class SocialMediaTypeEntity extends BaseEntity {

    @Column(name = SocialMediaTypeConstant.COLUMN_SOCIAL_MEDIA_TYPE_NAME, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String socialMediaName;


    @OneToMany(mappedBy = "socialMedia")
    private List<SocialMediaEntity> socialMedias;
}
