package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CityService {

    DataResult<List<CityEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<CityEntity>> getAll();

    DataResult<List<CityEntity>> getAllSorted();

    DataResult<CityEntity> save(CityEntity cityEntity);

    DataResult<CityEntity> update(CityEntity cityEntity);

    Result delete(Long id);
}
