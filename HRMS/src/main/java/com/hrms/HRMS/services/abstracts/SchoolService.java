package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.entities.concretes.SchoolEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SchoolService {

    DataResult<List<SchoolEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<SchoolEntity>> getAll();

    DataResult<List<SchoolEntity>> getAllSorted();

    DataResult<SchoolEntity> save(SchoolEntity schoolEntity);

    DataResult<SchoolEntity> update(SchoolEntity schoolEntity);

    Result delete(Long id);
}
