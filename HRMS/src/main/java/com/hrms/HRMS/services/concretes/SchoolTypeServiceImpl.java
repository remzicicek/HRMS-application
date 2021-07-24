package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EducationEntity;
import com.hrms.HRMS.entities.concretes.SchoolTypeEntity;
import com.hrms.HRMS.repositories.SchoolRepository;
import com.hrms.HRMS.repositories.SchoolTypeRepository;
import com.hrms.HRMS.services.abstracts.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolTypeServiceImpl implements SchoolTypeService {
    
    private final SchoolTypeRepository schoolTypeRepository;

    @Autowired
    public SchoolTypeServiceImpl(SchoolTypeRepository schoolTypeRepository) {
        this.schoolTypeRepository = schoolTypeRepository;
    }

    @Override
    public DataResult<List<SchoolTypeEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(schoolTypeRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<SchoolTypeEntity>> getAll() {
        return new SuccessDataResult<>(schoolTypeRepository.findAll(), "SchoolTypes are successfully received");
    }

    @Override
    public DataResult<List<SchoolTypeEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "schoolTypeName");
        return new SuccessDataResult<>(schoolTypeRepository.findAll(sort), "SchoolTypes are successfully sorted");
    }

    @Override
    public DataResult<SchoolTypeEntity> save(SchoolTypeEntity schoolTypeEntity) {
        if(schoolTypeEntity != null){
            return new SuccessDataResult<>(schoolTypeRepository.save(schoolTypeEntity));
        }
        return new ErrorDataResult<>("SchoolType could not be added");
    }

    @Override
    public DataResult<SchoolTypeEntity> update(SchoolTypeEntity schoolTypeEntity) {
        if(schoolTypeRepository.existsById(schoolTypeEntity.getId())){
            return new SuccessDataResult<>(schoolTypeRepository.save(schoolTypeEntity));
        }
        return new ErrorDataResult<>(schoolTypeEntity,"SchoolType could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(schoolTypeRepository.existsById(id)){
            return new SuccessResult("SchoolType is sucessfully deleted");
        }
        return new ErrorResult("SchoolType could not be found");
    }
}
