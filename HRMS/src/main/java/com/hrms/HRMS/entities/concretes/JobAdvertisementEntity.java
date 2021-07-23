package com.hrms.HRMS.entities.concretes;

import com.hrms.HRMS.core.constants.JobConstant;
import com.hrms.HRMS.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisementEntity extends BaseEntity {

    @Column(name = JobConstant.COLUMN_ADVERTISEMENT_NAME, nullable = false)
    @NotNull
    @NotBlank
    private String advertisementName;

    // @Lob means that Length is 255
    @Lob
    @Column(name = JobConstant.COLUMN_DESCRIPTION)
    @NotBlank
    @NotNull
    private String description;

    @Column(name = JobConstant.COLUMN_MININMUM_SALARY, nullable = false)
    @NotNull
    private Double minSalary;

    @Column(name = JobConstant.COLUMN_MAXIMUM_SALARY, nullable = false)
    @NotNull
    private Double maxSalary;

    @Column(name = JobConstant.COLUMN_NEEDED_QUOTA, nullable = false)
    @NotNull
    private Integer neededQuota;

    @Column(name = JobConstant.COLUMN_ACTIVE, nullable = false, columnDefinition = "boolean default false")
    @NotNull
    private boolean isActive;

    @Column(name = JobConstant.COLUMN_DUE_DATE, nullable = false)
    @NotNull
    private LocalDate dueDate;

    @Column(name = JobConstant.COLUMN_RELEASE_DATE, nullable = false)
    @NotNull
    private LocalDate releaseDate;

    /**
     * Firstly Relational classes is added and then this class is added with relaitonal object informations.
     */

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "advertisement_matches_job",
        joinColumns = {
           @JoinColumn(name = "job_id", referencedColumnName = "id",
                nullable = false, updatable = false)
        },
        inverseJoinColumns = {
           @JoinColumn(name = "advertisement_id", referencedColumnName = "id",
                nullable = false, updatable = false)
        }
    )
    private List<JobEntity> jobs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "advertisement_matches_city",
            joinColumns = {
                    @JoinColumn(name = "city_id", referencedColumnName = "id",
                            nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "advertisement_id", referencedColumnName = "id",
                            nullable = false, updatable = false)
            }
    )
    private List<CityEntity> cities;

    // Burada İş ilanı ile eşlecek ManyToMany

    // İş ilanı = Job Advertisement: İş verenle eşlecek (Bir işveren birden fazla ilan verir OneToMany olacak çünkü her ilan işverene özeldir. Aynı ilanı başkası veremez.)
// Job ile eşlecek her iş ilanı Aynı job için verebilir (ManyToMany)
    // City ile eşlecek Her iş ilanı her city için olabilir. ManyToMany

}
