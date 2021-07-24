package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobPositionEntity;
import com.hrms.HRMS.restControllers.abstracts.JobPositionRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.hrms.HRMS.servicompanyEntityces.abstracts.JobPositionService;

import java.util.List;

@RestController
public class JobPositionRestControllerImpl implements JobPositionRestController {
    
    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionRestControllerImpl(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @Override
    public DataResult<List<JobPositionEntity>> getAll() {
        return jobPositionService.getAll();
    }

    @Override
    public DataResult<List<JobPositionEntity>> getAllSorted() {
        return jobPositionService.getAllSorted();
    }

    @Override
    public DataResult<List<JobPositionEntity>> getList(int pageNo, int pageSize) {
        return jobPositionService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<JobPositionEntity> save(JobPositionEntity jobPositionEntity) {
        return jobPositionService.save(jobPositionEntity);
    }

    @Override
    public DataResult<JobPositionEntity> update(JobPositionEntity jobPositionEntity) {
        return jobPositionService.update(jobPositionEntity);
    }

    @Override
    public Result delete(Long id) {
        return jobPositionService.delete(id);
    }
}
