package com.hrms.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.HRMS.core.constants.LanguageConstant;
import com.hrms.HRMS.core.constants.LanguageTypeConstant;
import com.hrms.HRMS.core.constants.SocialMediaConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "social_medias")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class SocialMediaEntity extends BaseEntity {

    @Column(name = SocialMediaConstant.COLUMN_SOCIAL_MEDIA_URL, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = SocialMediaConstant.COLUMN_SOCIAL_MEDIA_TYPE_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private SocialMediaTypeEntity socialMedia;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = SocialMediaConstant.COLUMN_CV_ID, referencedColumnName = "id", nullable = false, updatable = false)
    @NotNull
    private CvEntity cv;

}
