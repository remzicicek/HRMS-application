package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.TechnologyEntity;
import com.hrms.HRMS.repositories.TechnologyRepository;
import com.hrms.HRMS.services.abstracts.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    
    private final TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public DataResult<List<TechnologyEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(technologyRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<TechnologyEntity>> getAll() {
        return new SuccessDataResult<>(technologyRepository.findAll(), "Technologies are successfully received");
    }

    @Override
    public DataResult<List<TechnologyEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "technologyType");
        return new SuccessDataResult<>(technologyRepository.findAll(sort), "Technologies are successfully sorted");
    }

    @Override
    public DataResult<TechnologyEntity> save(TechnologyEntity technologyEntity) {
        if(technologyEntity != null){
            return new SuccessDataResult<>(technologyRepository.save(technologyEntity));
        }
        return new ErrorDataResult<>("Technology could not be added");
    }

    @Override
    public DataResult<TechnologyEntity> update(TechnologyEntity technologyEntity) {
        if(technologyRepository.existsById(technologyEntity.getId())){
            return new SuccessDataResult<>(technologyRepository.save(technologyEntity));
        }
        return new ErrorDataResult<>(technologyEntity,"Technology could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(technologyRepository.existsById(id)){
            return new SuccessResult("Technology is sucessfully deleted");
        }
        return new ErrorResult("Technology could not be found");
    }
}
