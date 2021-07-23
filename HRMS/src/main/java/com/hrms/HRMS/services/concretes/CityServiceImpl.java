package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.repositories.CityRepository;
import com.hrms.HRMS.services.abstracts.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public DataResult<List<CityEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(cityRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<CityEntity>> getAll() {
        return new SuccessDataResult<>(cityRepository.findAll(), "Cities is successfully received");
    }

    @Override
    public DataResult<List<CityEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "jobTitle");
        return new SuccessDataResult<>(cityRepository.findAll(sort), "Cities is successfully sorted");
    }

    @Override
    public DataResult<CityEntity> save(CityEntity cityEntity) {
        if(cityEntity != null){
            return new SuccessDataResult<>(cityRepository.save(cityEntity));
        }
        return new ErrorDataResult<>("City could not be added");
    }

    @Override
    public DataResult<CityEntity> update(CityEntity cityEntity) {
        if(cityRepository.existsById(cityEntity.getId())){
            return new SuccessDataResult<>(cityRepository.save(cityEntity));
        }
        return new ErrorDataResult<>(cityEntity,"City could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(cityRepository.existsById(id)){
            return new SuccessResult("City is sucessfully deleted");
        }
        return new ErrorResult("City could not be found");
    }
}
