package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaEntity;
import com.hrms.HRMS.repositories.SocialMediaRepository;
import com.hrms.HRMS.services.abstracts.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaServiceImpl implements SocialMediaService {
    
    private final SocialMediaRepository socialMediaRepository;

    @Autowired
    public SocialMediaServiceImpl(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }

    @Override
    public DataResult<List<SocialMediaEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(socialMediaRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<SocialMediaEntity>> getAll() {
        return new SuccessDataResult<>(socialMediaRepository.findAll(), "SocialMedias are successfully received");
    }

    @Override
    public DataResult<List<SocialMediaEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "socialMedia");
        return new SuccessDataResult<>(socialMediaRepository.findAll(sort), "SocialMedias are successfully sorted");
    }

    @Override
    public DataResult<SocialMediaEntity> save(SocialMediaEntity socialMediaEntity) {
        if(socialMediaEntity != null){
            return new SuccessDataResult<>(socialMediaRepository.save(socialMediaEntity));
        }
        return new ErrorDataResult<>("SocialMedia could not be added");
    }

    @Override
    public DataResult<SocialMediaEntity> update(SocialMediaEntity socialMediaEntity) {
        if(socialMediaRepository.existsById(socialMediaEntity.getId())){
            return new SuccessDataResult<>(socialMediaRepository.save(socialMediaEntity));
        }
        return new ErrorDataResult<>(socialMediaEntity,"SocialMedia could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(socialMediaRepository.existsById(id)){
            return new SuccessResult("SocialMedia is sucessfully deleted");
        }
        return new ErrorResult("SocialMedia could not be found");
    }
}
