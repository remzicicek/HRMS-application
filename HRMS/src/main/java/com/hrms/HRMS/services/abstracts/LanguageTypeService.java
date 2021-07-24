package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.LanguageTypeEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface LanguageTypeService {

    DataResult<List<LanguageTypeEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<LanguageTypeEntity>> getAll();

    DataResult<List<LanguageTypeEntity>> getAllSorted();

    DataResult<LanguageTypeEntity> save(LanguageTypeEntity languageTypeEntity);

    DataResult<LanguageTypeEntity> update(LanguageTypeEntity languageTypeEntity);

    Result delete(Long id);
}
