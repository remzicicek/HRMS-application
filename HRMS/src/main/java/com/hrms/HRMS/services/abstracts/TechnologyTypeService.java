package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.TechnologyTypeEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TechnologyTypeService {

    DataResult<List<TechnologyTypeEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<TechnologyTypeEntity>> getAll();

    DataResult<List<TechnologyTypeEntity>> getAllSorted();

    DataResult<TechnologyTypeEntity> save(TechnologyTypeEntity technologyTypeEntity);

    DataResult<TechnologyTypeEntity> update(TechnologyTypeEntity technologyTypeEntity);

    Result delete(Long id);
}
