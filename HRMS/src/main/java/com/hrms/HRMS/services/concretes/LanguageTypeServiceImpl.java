package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.LanguageTypeEntity;
import com.hrms.HRMS.repositories.LanguageTypeRepository;
import com.hrms.HRMS.services.abstracts.LanguageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageTypeServiceImpl implements LanguageTypeService {
    
    private final LanguageTypeRepository languageTypeRepository;

    @Autowired
    public LanguageTypeServiceImpl(LanguageTypeRepository languageTypeRepository) {
        this.languageTypeRepository = languageTypeRepository;
    }

    @Override
    public DataResult<List<LanguageTypeEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(languageTypeRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<LanguageTypeEntity>> getAll() {
        return new SuccessDataResult<>(languageTypeRepository.findAll(), "LanguageTypes are successfully received");
    }

    @Override
    public DataResult<List<LanguageTypeEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "languageName");
        return new SuccessDataResult<>(languageTypeRepository.findAll(sort), "LanguageTypes are successfully sorted");
    }

    @Override
    public DataResult<LanguageTypeEntity> save(LanguageTypeEntity languageTypeEntity) {
        if(languageTypeEntity != null){
            return new SuccessDataResult<>(languageTypeRepository.save(languageTypeEntity));
        }
        return new ErrorDataResult<>("LanguageType could not be added");
    }

    @Override
    public DataResult<LanguageTypeEntity> update(LanguageTypeEntity languageTypeEntity) {
        if(languageTypeRepository.existsById(languageTypeEntity.getId())){
            return new SuccessDataResult<>(languageTypeRepository.save(languageTypeEntity));
        }
        return new ErrorDataResult<>(languageTypeEntity,"LanguageType could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(languageTypeRepository.existsById(id)){
            return new SuccessResult("LanguageType is sucessfully deleted");
        }
        return new ErrorResult("LanguageType could not be found");
    }
}
