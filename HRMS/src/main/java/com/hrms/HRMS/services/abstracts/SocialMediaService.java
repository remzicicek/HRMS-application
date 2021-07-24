package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.SocialMediaEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SocialMediaService {

    DataResult<List<SocialMediaEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<SocialMediaEntity>> getAll();

    DataResult<List<SocialMediaEntity>> getAllSorted();

    DataResult<SocialMediaEntity> save(SocialMediaEntity socialMediaEntity);

    DataResult<SocialMediaEntity> update(SocialMediaEntity socialMediaEntity);

    Result delete(Long id);
}
