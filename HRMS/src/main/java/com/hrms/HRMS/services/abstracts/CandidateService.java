package com.hrms.HRMS.services.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.models.concretes.CandidateModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CandidateService {

    DataResult<List<CandidateModel>> getList(@Valid @NotNull int pageNo, int pageSize);

    DataResult<List<CandidateModel>> getAll();

    DataResult<List<CandidateModel>> getAllSorted();

    DataResult<CandidateModel> save(CandidateModel candidateModel);

    DataResult<CandidateModel> update(CandidateModel candidateModel);

    Result delete(Long id);
}
