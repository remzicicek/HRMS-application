package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EducationEntity;
import com.hrms.HRMS.entities.concretes.EducationTypeEntity;
import com.hrms.HRMS.repositories.EducationTypeRepository;
import com.hrms.HRMS.services.abstracts.EducationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationTypeServiceImpl implements EducationTypeService {
    
    private final EducationTypeRepository educationTypeRepository;

    @Autowired
    public EducationTypeServiceImpl(EducationTypeRepository educationTypeRepository) {
        this.educationTypeRepository = educationTypeRepository;
    }

    @Override
    public DataResult<List<EducationTypeEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(educationTypeRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<EducationTypeEntity>> getAll() {
        return new SuccessDataResult<>(educationTypeRepository.findAll(), "EducationTypies are successfully received");
    }

    @Override
    public DataResult<List<EducationTypeEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "educationTypeName");
        return new SuccessDataResult<>(educationTypeRepository.findAll(sort), "EducationTypies are successfully sorted");
    }

    @Override
    public DataResult<EducationTypeEntity> save(EducationTypeEntity educationTypeEntity) {
        if(educationTypeEntity != null){
            return new SuccessDataResult<>(educationTypeRepository.save(educationTypeEntity));
        }
        return new ErrorDataResult<>("Education could not be added");
    }

    @Override
    public DataResult<EducationTypeEntity> update(EducationTypeEntity educationTypeEntity) {
        if(educationTypeRepository.existsById(educationTypeEntity.getId())){
            return new SuccessDataResult<>(educationTypeRepository.save(educationTypeEntity));
        }
        return new ErrorDataResult<>(educationTypeEntity,"EducationType could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(educationTypeRepository.existsById(id)){
            return new SuccessResult("EducationType is sucessfully deleted");
        }
        return new ErrorResult("EducationType could not be found");
    }
}
