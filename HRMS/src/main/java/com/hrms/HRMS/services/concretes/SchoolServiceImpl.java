package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EducationEntity;
import com.hrms.HRMS.entities.concretes.SchoolEntity;
import com.hrms.HRMS.repositories.SchoolRepository;
import com.hrms.HRMS.services.abstracts.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public DataResult<List<SchoolEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(schoolRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<SchoolEntity>> getAll() {
        return new SuccessDataResult<>(schoolRepository.findAll(), "Schools are successfully received");
    }

    @Override
    public DataResult<List<SchoolEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "schoolName");
        return new SuccessDataResult<>(schoolRepository.findAll(sort), "Schools are successfully sorted");
    }

    @Override
    public DataResult<SchoolEntity> save(SchoolEntity schoolEntity) {
        if(schoolEntity != null){
            return new SuccessDataResult<>(schoolRepository.save(schoolEntity));
        }
        return new ErrorDataResult<>("School could not be added");
    }

    @Override
    public DataResult<SchoolEntity> update(SchoolEntity schoolEntity) {
        if(schoolRepository.existsById(schoolEntity.getId())){
            return new SuccessDataResult<>(schoolRepository.save(schoolEntity));
        }
        return new ErrorDataResult<>(schoolEntity,"School could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(schoolRepository.existsById(id)){
            return new SuccessResult("School is sucessfully deleted");
        }
        return new ErrorResult("School could not be found");
    }
}
