package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.entities.concretes.SchoolTypeEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SchoolTypeService {

    DataResult<List<SchoolTypeEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<SchoolTypeEntity>> getAll();

    DataResult<List<SchoolTypeEntity>> getAllSorted();

    DataResult<SchoolTypeEntity> save(SchoolTypeEntity schoolTypeEntity);

    DataResult<SchoolTypeEntity> update(SchoolTypeEntity schoolTypeEntity);

    Result delete(Long id);
}
