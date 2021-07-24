package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.LanguageEntity;
import com.hrms.HRMS.repositories.LanguageRepository;
import com.hrms.HRMS.services.abstracts.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public DataResult<List<LanguageEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(languageRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<LanguageEntity>> getAll() {
        return new SuccessDataResult<>(languageRepository.findAll(), "Languages are successfully received");
    }

    @Override
    public DataResult<List<LanguageEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "languageType");
        return new SuccessDataResult<>(languageRepository.findAll(sort), "Languages are successfully sorted");
    }

    @Override
    public DataResult<LanguageEntity> save(LanguageEntity languageEntity) {
        if(languageEntity != null){
            return new SuccessDataResult<>(languageRepository.save(languageEntity));
        }
        return new ErrorDataResult<>("Language could not be added");
    }

    @Override
    public DataResult<LanguageEntity> update(LanguageEntity languageEntity) {
        if(languageRepository.existsById(languageEntity.getId())){
            return new SuccessDataResult<>(languageRepository.save(languageEntity));
        }
        return new ErrorDataResult<>(languageEntity,"Language could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(languageRepository.existsById(id)){
            return new SuccessResult("Language is sucessfully deleted");
        }
        return new ErrorResult("Language could not be found");
    }
}
