package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.LanguageEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface LanguageService {

    DataResult<List<LanguageEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<LanguageEntity>> getAll();

    DataResult<List<LanguageEntity>> getAllSorted();

    DataResult<LanguageEntity> save(LanguageEntity languageEntity);

    DataResult<LanguageEntity> update(LanguageEntity languageEntity);

    Result delete(Long id);
}
