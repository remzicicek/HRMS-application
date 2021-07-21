package com.hrms.HRMS.models.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass // to see upper class parameter in the entity table that is on the database
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends BaseModel {

    private String email;

    private String password;

    private String confirmPassword;

    private String telephoneNumber;
}
