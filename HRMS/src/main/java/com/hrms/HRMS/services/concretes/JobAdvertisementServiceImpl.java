package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobAdvertisementEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;
import com.hrms.HRMS.repositories.JobAdvertisementRepository;
import com.hrms.HRMS.repositories.JobRepository;
import com.hrms.HRMS.services.abstracts.JobAdvertisementService;
import com.hrms.HRMS.services.abstracts.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private JobAdvertisementRepository jobAdvertisementRepository;
    private JobRepository jobRepository;

    @Autowired
    public JobAdvertisementServiceImpl(JobAdvertisementRepository jobAdvertisementRepository, JobRepository jobRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.jobRepository = jobRepository;
    }


    @Override
    public DataResult<List<JobAdvertisementEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(jobAdvertisementRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<JobAdvertisementEntity>> getAll() {
        return new SuccessDataResult<>(jobAdvertisementRepository.findAll(), "JobAdvertisements is successfully received");
    }

    @Override
    public DataResult<List<JobAdvertisementEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "advertisement_name");
        return new SuccessDataResult<>(jobAdvertisementRepository.findAll(sort), "Job Advertisements is successfully sorted");
    }

    @Override
    public DataResult<JobAdvertisementEntity> save(JobAdvertisementEntity jobAdvertisementEntity) {
        if(jobAdvertisementEntity != null){
            return new SuccessDataResult<>(jobAdvertisementRepository.save(jobAdvertisementEntity));
        }
        return new ErrorDataResult<>("Job could not be added");
    }

    @Override
    public DataResult<JobAdvertisementEntity> update(JobAdvertisementEntity jobAdvertisementEntity) {
        if(jobAdvertisementRepository.existsById(jobAdvertisementEntity.getId())){
            return new SuccessDataResult<>(jobAdvertisementRepository.save(jobAdvertisementEntity));
        }
        return new ErrorDataResult<>(jobAdvertisementEntity,"Job Advertisement could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(jobAdvertisementRepository.existsById(id)){
            return new SuccessResult("Job Advertisement is sucessfully deleted");
        }
        return new ErrorResult("Job Advertisement could not be found");
    }
}
