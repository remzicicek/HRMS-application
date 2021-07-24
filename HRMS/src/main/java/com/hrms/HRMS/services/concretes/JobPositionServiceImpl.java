package com.hrms.HRMS.services.concretes;
import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobPositionEntity;
import com.hrms.HRMS.repositories.JobPositionRepository;
import com.hrms.HRMS.servicompanyEntityces.abstracts.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {
    
    private final JobPositionRepository jobPositionRepository;

    @Autowired
    public JobPositionServiceImpl(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    @Override
    public DataResult<List<JobPositionEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(jobPositionRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<JobPositionEntity>> getAll() {
        return new SuccessDataResult<>(jobPositionRepository.findAll(), "JobPositions are successfully received");
    }

    @Override
    public DataResult<List<JobPositionEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "positionName");
        return new SuccessDataResult<>(jobPositionRepository.findAll(sort), "JobPositions are successfully sorted");
    }

    @Override
    public DataResult<JobPositionEntity> save(JobPositionEntity jobPositionEntity) {
        if(jobPositionEntity != null){
            return new SuccessDataResult<>(jobPositionRepository.save(jobPositionEntity));
        }
        return new ErrorDataResult<>("JobPosition could not be added");
    }

    @Override
    public DataResult<JobPositionEntity> update(JobPositionEntity jobPositionEntity) {
        if(jobPositionRepository.existsById(jobPositionEntity.getId())){
            return new SuccessDataResult<>(jobPositionRepository.save(jobPositionEntity));
        }
        return new ErrorDataResult<>(jobPositionEntity,"JobPosition could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(jobPositionRepository.existsById(id)){
            return new SuccessResult("JobPosition is sucessfully deleted");
        }
        return new ErrorResult("JobPosition could not be found");
    }
}
