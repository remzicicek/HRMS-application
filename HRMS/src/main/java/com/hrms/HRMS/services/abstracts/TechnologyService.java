package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.TechnologyEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TechnologyService {

    DataResult<List<TechnologyEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<TechnologyEntity>> getAll();

    DataResult<List<TechnologyEntity>> getAllSorted();

    DataResult<TechnologyEntity> save(TechnologyEntity technologyEntity);

    DataResult<TechnologyEntity> update(TechnologyEntity technologyEntity);

    Result delete(Long id);
}
