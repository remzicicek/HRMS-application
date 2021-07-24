package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.entities.concretes.EducationTypeEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface EducationTypeService {

    DataResult<List<EducationTypeEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<EducationTypeEntity>> getAll();

    DataResult<List<EducationTypeEntity>> getAllSorted();

    DataResult<EducationTypeEntity> save(EducationTypeEntity educationTypeEntity);

    DataResult<EducationTypeEntity> update(EducationTypeEntity educationTypeEntity);

    Result delete(Long id);
}
