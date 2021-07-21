package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;
import com.hrms.HRMS.restControllers.abstracts.JobRestController;
import com.hrms.HRMS.services.abstracts.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobRestControllerImpl implements JobRestController {

    private JobService jobService;

    @Autowired
    public JobRestControllerImpl(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public DataResult<List<JobEntity>> getAll() {
        return jobService.getAll();
    }

    @Override
    public DataResult<List<JobEntity>> getAllSorted() {
        return jobService.getAllSorted();
    }

    @Override
    public DataResult<List<JobEntity>> getList(int pageNo, int pageSize) {
        return jobService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<JobEntity> save(JobEntity jobEntity) {
        return jobService.save(jobEntity);
    }

    @Override
    public DataResult<JobEntity> update(JobEntity jobEntity) {
        return jobService.update(jobEntity);
    }

    @Override
    public Result delete(Long id) {
        return jobService.delete(id);
    }
}
