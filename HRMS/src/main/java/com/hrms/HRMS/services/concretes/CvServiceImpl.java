package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.CvEntity;
import com.hrms.HRMS.repositories.CvRepository;
import com.hrms.HRMS.services.abstracts.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {
    
    private final CvRepository cvRepository;

    @Autowired
    public CvServiceImpl(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public DataResult<List<CvEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(cvRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<CvEntity>> getAll() {
        return new SuccessDataResult<>(cvRepository.findAll(), "Cvs are successfully received");
    }

    @Override
    public DataResult<List<CvEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "candidate");
        return new SuccessDataResult<>(cvRepository.findAll(sort), "Cvs are successfully sorted");
    }

    @Override
    public DataResult<CvEntity> save(CvEntity cvEntity) {
        if(cvEntity != null){
            return new SuccessDataResult<>(cvRepository.save(cvEntity));
        }
        return new ErrorDataResult<>("Cv could not be added");
    }

    @Override
    public DataResult<CvEntity> update(CvEntity cvEntity) {
        if(cvRepository.existsById(cvEntity.getId())){
            return new SuccessDataResult<>(cvRepository.save(cvEntity));
        }
        return new ErrorDataResult<>(cvEntity,"Cv could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(cvRepository.existsById(id)){
            return new SuccessResult("Cv is sucessfully deleted");
        }
        return new ErrorResult("Cv could not be found");
    }
}
