package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.EducationEntity;
import com.hrms.HRMS.repositories.EducationRepository;
import com.hrms.HRMS.services.abstracts.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    // TODO: Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte ve "devam ediyor" olarak görüntülenmelidir.

    private EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public DataResult<List<EducationEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(educationRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<EducationEntity>> getAll() {
        return new SuccessDataResult<>(educationRepository.findAll(), "Educations are successfully received");
    }

    @Override
    public DataResult<List<EducationEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");
        return new SuccessDataResult<>(educationRepository.findAll(sort), "Educations are successfully sorted");
    }

    @Override
    public DataResult<EducationEntity> save(EducationEntity educationEntity) {
        if(educationEntity != null){
            return new SuccessDataResult<>(educationRepository.save(educationEntity));
        }
        return new ErrorDataResult<>("Education could not be added");
    }

    @Override
    public DataResult<EducationEntity> update(EducationEntity educationEntity) {
        if(educationRepository.existsById(educationEntity.getId())){
            return new SuccessDataResult<>(educationRepository.save(educationEntity));
        }
        return new ErrorDataResult<>(educationEntity,"Education could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(educationRepository.existsById(id)){
            return new SuccessResult("Education is sucessfully deleted");
        }
        return new ErrorResult("Education could not be found");
    }
}
