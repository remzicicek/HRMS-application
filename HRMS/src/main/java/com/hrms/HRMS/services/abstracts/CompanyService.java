package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CompanyService {

    DataResult<List<CompanyEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<CompanyEntity>> getAll();

    DataResult<List<CompanyEntity>> getAllSorted();

    DataResult<CompanyEntity> save(CompanyEntity companyEntity);

    DataResult<CompanyEntity> update(CompanyEntity companyEntity);

    Result delete(Long id);
}
