package com.hrms.HRMS.entities.abstracts;

import com.hrms.HRMS.core.constraint.common.BaseConstraint;
import com.hrms.HRMS.core.constraint.common.UserConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * @Setter(AccessLevel.PUBLIC) --> to indicate method type
 */
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = BaseConstraint.COLUMN_ID)
    private Long id;

    @CreatedDate
    @Column(name = BaseConstraint.COLUMN_CREATED_DATE)
    private Date createdDate;

    @CreatedBy
    @Column(name = BaseConstraint.COLUMN_CREATED_BY)
    private String createdBy;

    @LastModifiedDate
    @Column(name = BaseConstraint.COLUMN_UPDATED_DATE)
    private Date updatedDate;

    @LastModifiedBy
    @Column(name = BaseConstraint.COLUMN_UPDATED_BY)
    private String updatedBy;

    /**
     * @Modifying annotation is used for soft delete
     */

}
