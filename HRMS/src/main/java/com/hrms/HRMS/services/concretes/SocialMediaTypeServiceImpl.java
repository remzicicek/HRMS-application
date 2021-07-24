package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaTypeEntity;
import com.hrms.HRMS.repositories.SocialMediaTypeRepository;
import com.hrms.HRMS.services.abstracts.SocialMediaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaTypeServiceImpl implements SocialMediaTypeService {
    
    private final SocialMediaTypeRepository socialMediaTypeRepository;

    @Autowired
    public SocialMediaTypeServiceImpl(SocialMediaTypeRepository socialMediaTypeRepository) {
        this.socialMediaTypeRepository = socialMediaTypeRepository;
    }

    @Override
    public DataResult<List<SocialMediaTypeEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(socialMediaTypeRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<SocialMediaTypeEntity>> getAll() {
        return new SuccessDataResult<>(socialMediaTypeRepository.findAll(), "SocialMediaTypes are successfully received");
    }

    @Override
    public DataResult<List<SocialMediaTypeEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "socialMediaName");
        return new SuccessDataResult<>(socialMediaTypeRepository.findAll(sort), "SocialMediaTypes are successfully sorted");
    }

    @Override
    public DataResult<SocialMediaTypeEntity> save(SocialMediaTypeEntity socialMediaTypeEntity) {
        if(socialMediaTypeEntity != null){
            return new SuccessDataResult<>(socialMediaTypeRepository.save(socialMediaTypeEntity));
        }
        return new ErrorDataResult<>("SocialMediaType could not be added");
    }

    @Override
    public DataResult<SocialMediaTypeEntity> update(SocialMediaTypeEntity socialMediaTypeEntity) {
        if(socialMediaTypeRepository.existsById(socialMediaTypeEntity.getId())){
            return new SuccessDataResult<>(socialMediaTypeRepository.save(socialMediaTypeEntity));
        }
        return new ErrorDataResult<>(socialMediaTypeEntity,"SocialMediaType could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(socialMediaTypeRepository.existsById(id)){
            return new SuccessResult("SocialMediaType is sucessfully deleted");
        }
        return new ErrorResult("SocialMediaType could not be found");
    }
}
