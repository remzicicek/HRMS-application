package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.entities.concretes.ExperienceEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ExperienceService {

    DataResult<List<ExperienceEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<ExperienceEntity>> getAll();

    DataResult<List<ExperienceEntity>> getAllSorted();

    DataResult<ExperienceEntity> save(ExperienceEntity experienceEntity);

    DataResult<ExperienceEntity> update(ExperienceEntity experienceEntity);

    Result delete(Long id);
}
