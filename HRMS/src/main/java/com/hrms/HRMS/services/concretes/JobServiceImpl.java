package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;
import com.hrms.HRMS.repositories.JobRepository;
import com.hrms.HRMS.services.abstracts.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public DataResult<List<JobEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(jobRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<JobEntity>> getAll() {
        return new SuccessDataResult<>(jobRepository.findAll(), "Jobs are successfully received");
    }

    @Override
    public DataResult<List<JobEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "jobTitle");
        return new SuccessDataResult<>(jobRepository.findAll(sort), "Jobs are successfully sorted");
    }

    @Override
    public DataResult<JobEntity> save(JobEntity jobEntity) {
        if(jobEntity != null){
            return new SuccessDataResult<>(jobRepository.save(jobEntity));
        }
        return new ErrorDataResult<>("Job could not be added");
    }

    @Override
    public DataResult<JobEntity> update(JobEntity jobEntity) {
        if(jobRepository.existsById(jobEntity.getId())){
            return new SuccessDataResult<>(jobRepository.save(jobEntity));
        }
        return new ErrorDataResult<>(jobEntity,"Job could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(jobRepository.existsById(id)){
            return new SuccessResult("Job is sucessfully deleted");
        }
        return new ErrorResult("Job could not be found");
    }
}
