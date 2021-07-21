package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface JobService {

    DataResult<List<JobEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<JobEntity>> getAll();

    DataResult<List<JobEntity>> getAllSorted();

    DataResult<JobEntity> save(JobEntity jobEntity);

    DataResult<JobEntity> update(JobEntity jobEntity);

    Result delete(Long id);
}
