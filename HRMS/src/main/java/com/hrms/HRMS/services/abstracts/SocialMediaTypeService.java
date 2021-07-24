package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaTypeEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SocialMediaTypeService {

    DataResult<List<SocialMediaTypeEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<SocialMediaTypeEntity>> getAll();

    DataResult<List<SocialMediaTypeEntity>> getAllSorted();

    DataResult<SocialMediaTypeEntity> save(SocialMediaTypeEntity socialMediaTypeEntity);

    DataResult<SocialMediaTypeEntity> update(SocialMediaTypeEntity socialMediaTypeEntity);

    Result delete(Long id);
}
