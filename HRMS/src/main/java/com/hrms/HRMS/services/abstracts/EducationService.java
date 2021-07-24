package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EducationEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface EducationService {

    DataResult<List<EducationEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<EducationEntity>> getAll();

    DataResult<List<EducationEntity>> getAllSorted();

    DataResult<EducationEntity> save(EducationEntity educationEntity);

    DataResult<EducationEntity> update(EducationEntity educationEntity);

    Result delete(Long id);
}
