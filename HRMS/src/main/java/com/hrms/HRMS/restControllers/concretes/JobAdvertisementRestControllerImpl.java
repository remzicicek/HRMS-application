package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobAdvertisementEntity;
import com.hrms.HRMS.restControllers.abstracts.JobAdvertisementRestController;
import com.hrms.HRMS.services.abstracts.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobAdvertisementRestControllerImpl implements JobAdvertisementRestController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementRestControllerImpl(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @Override
    public DataResult<List<JobAdvertisementEntity>> getAll() {
        return jobAdvertisementService.getAll();
    }

    @Override
    public DataResult<List<JobAdvertisementEntity>> getAllSorted() {
        return jobAdvertisementService.getAllSorted();
    }

    @Override
    public DataResult<List<JobAdvertisementEntity>> getList(int pageNo, int pageSize) {
        return jobAdvertisementService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<JobAdvertisementEntity> save(JobAdvertisementEntity jobAdvertisementEntity) {
        return jobAdvertisementService.save(jobAdvertisementEntity);
    }

    @Override
    public DataResult<JobAdvertisementEntity> update(JobAdvertisementEntity jobAdvertisementEntity) {
        return jobAdvertisementService.update(jobAdvertisementEntity);
    }

    @Override
    public Result delete(Long id) {
        return jobAdvertisementService.delete(id);
    }
}
