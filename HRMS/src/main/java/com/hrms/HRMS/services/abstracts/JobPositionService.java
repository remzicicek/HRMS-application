package com.hrms.HRMS.servicompanyEntityces.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.entities.concretes.JobPositionEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface JobPositionService {

    DataResult<List<JobPositionEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<JobPositionEntity>> getAll();

    DataResult<List<JobPositionEntity>> getAllSorted();

    DataResult<JobPositionEntity> save(JobPositionEntity jobPositionEntity);

    DataResult<JobPositionEntity> update(JobPositionEntity jobPositionEntity);

    Result delete(Long id);
}
