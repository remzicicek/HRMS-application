package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EmployerEntity;
import com.hrms.HRMS.entities.concretes.EmployerEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface EmployerService {
    // TODO: EmployerEntity will be CandidateModel

    DataResult<List<EmployerEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<EmployerEntity>> getAll();

    DataResult<List<EmployerEntity>> getAllSorted();

    DataResult<EmployerEntity> save(EmployerEntity employerEntity);

    DataResult<EmployerEntity> update(EmployerEntity employerEntity);

    Result delete(Long id);
}
