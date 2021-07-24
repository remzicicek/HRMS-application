package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.CvEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CvService {

    DataResult<List<CvEntity>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<CvEntity>> getAll();

    DataResult<List<CvEntity>> getAllSorted();

    DataResult<CvEntity> save(CvEntity cvEntity);

    DataResult<CvEntity> update(CvEntity cvEntity);

    Result delete(Long id);
}
