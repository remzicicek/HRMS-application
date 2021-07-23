package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobAdvertisementEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisementEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<JobAdvertisementEntity>> getAll();

    DataResult<List<JobAdvertisementEntity>> getAllSorted();

    DataResult<JobAdvertisementEntity> save(JobAdvertisementEntity jobAdvertisementEntity);

    DataResult<JobAdvertisementEntity> update(JobAdvertisementEntity jobAdvertisementEntity);

    Result delete(Long id);
}
