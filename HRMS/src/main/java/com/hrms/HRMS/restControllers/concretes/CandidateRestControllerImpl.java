package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.models.concretes.CandidateModel;
import com.hrms.HRMS.restControllers.abstracts.CandidateRestController;
import com.hrms.HRMS.services.abstracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidateRestControllerImpl implements CandidateRestController {

    private CandidateService candidateService;

    @Autowired
    public CandidateRestControllerImpl(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @Override
    public DataResult<List<CandidateModel>> getAll() {
        return candidateService.getAll();
    }

    @Override
    public DataResult<List<CandidateModel>> getAllSorted() {
        return candidateService.getAllSorted();
    }

    @Override
    public DataResult<List<CandidateModel>> getList(int pageNo, int pageSize) {
        return candidateService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<CandidateModel> save(CandidateModel candidateModel) {
        return candidateService.save(candidateModel);
    }

    @Override
    public DataResult<CandidateModel> update(CandidateModel candidateModel) {
        return candidateService.update(candidateModel);
    }

    @Override
    public Result delete(Long id) {
        return candidateService.delete(id);
    }
}
