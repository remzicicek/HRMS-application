package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.ExperienceEntity;
import com.hrms.HRMS.repositories.ExperienceRepository;
import com.hrms.HRMS.services.abstracts.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    //TODO: Adayların tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve "devam ediyor" olarak görüntülenmelidir.

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public DataResult<List<ExperienceEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(experienceRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<ExperienceEntity>> getAll() {
        return new SuccessDataResult<>(experienceRepository.findAll(), "Experiences are successfully received");
    }

    @Override
    public DataResult<List<ExperienceEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        return new SuccessDataResult<>(experienceRepository.findAll(sort), "Experiences are successfully sorted");
    }

    @Override
    public DataResult<ExperienceEntity> save(ExperienceEntity experienceEntity) {
        if(experienceEntity != null){
            return new SuccessDataResult<>(experienceRepository.save(experienceEntity));
        }
        return new ErrorDataResult<>("Experience could not be added");
    }

    @Override
    public DataResult<ExperienceEntity> update(ExperienceEntity experienceEntity) {
        if(experienceRepository.existsById(experienceEntity.getId())){
            return new SuccessDataResult<>(experienceRepository.save(experienceEntity));
        }
        return new ErrorDataResult<>(experienceEntity,"Experience could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(experienceRepository.existsById(id)){
            return new SuccessResult("Experience is sucessfully deleted");
        }
        return new ErrorResult("Experience could not be found");
    }
}
