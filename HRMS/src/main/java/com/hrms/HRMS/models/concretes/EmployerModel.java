package com.hrms.HRMS.models.concretes;

import com.hrms.HRMS.models.abstracts.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerModel extends UserModel {

    private String companyName;

    private String companyWebsite;

}
