package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.TechnologyTypeEntity;
import com.hrms.HRMS.repositories.TechnologyTypeRepository;
import com.hrms.HRMS.services.abstracts.TechnologyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyTypeServiceImpl implements TechnologyTypeService {
    
    private final TechnologyTypeRepository technologyTypeRepository;

    @Autowired
    public TechnologyTypeServiceImpl(TechnologyTypeRepository technologyTypeRepository) {
        this.technologyTypeRepository = technologyTypeRepository;
    }

    @Override
    public DataResult<List<TechnologyTypeEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(technologyTypeRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<TechnologyTypeEntity>> getAll() {
        return new SuccessDataResult<>(technologyTypeRepository.findAll(), "TechnologyTypes are successfully received");
    }

    @Override
    public DataResult<List<TechnologyTypeEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "cityName");
        return new SuccessDataResult<>(technologyTypeRepository.findAll(sort), "TechnologyTypes are successfully sorted");
    }

    @Override
    public DataResult<TechnologyTypeEntity> save(TechnologyTypeEntity technologyTypeEntity) {
        if(technologyTypeEntity != null){
            return new SuccessDataResult<>(technologyTypeRepository.save(technologyTypeEntity));
        }
        return new ErrorDataResult<>("echnologyType could not be added");
    }

    @Override
    public DataResult<TechnologyTypeEntity> update(TechnologyTypeEntity technologyTypeEntity) {
        if(technologyTypeRepository.existsById(technologyTypeEntity.getId())){
            return new SuccessDataResult<>(technologyTypeRepository.save(technologyTypeEntity));
        }
        return new ErrorDataResult<>(technologyTypeEntity,"TechnologyType could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(technologyTypeRepository.existsById(id)){
            return new SuccessResult("TechnologyType is sucessfully deleted");
        }
        return new ErrorResult("TechnologyType could not be found");
    }
}
