package com.hrms.HRMS.entities.abstracts;

import com.hrms.HRMS.core.constraint.common.UserConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass // to see upper class parameter in the entity table that is on the database
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserEntity extends BaseEntity{

    /**
     * Nullable= false dmeek database tablosunda NotNull bölümü açık demektir.
     * @NotNull annotasyonu bunu yapmaz.
     */

    @Column(name = UserConstraint.COLUMN_EMAIL, length = 50, nullable = false, unique = true)
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Column(name = UserConstraint.COLUMN_PASSWORD, length = 50, nullable = false)
    @NotBlank
    @NotNull
    private String password;

    @Column(name = UserConstraint.COLUMN_TELEPHONE_NUMBER, length = 50, nullable = false, unique = true)
    @NotBlank
    private String telephoneNumber;

}
