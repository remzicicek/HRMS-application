package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaTypeEntity;
import com.hrms.HRMS.restControllers.abstracts.SocialMediaTypeRestController;
import com.hrms.HRMS.services.abstracts.SocialMediaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialMediaTypeRestControllerImpl implements SocialMediaTypeRestController {
    
    private final SocialMediaTypeService socialMediaTypeService;

    @Autowired
    public SocialMediaTypeRestControllerImpl(SocialMediaTypeService socialMediaTypeService) {
        this.socialMediaTypeService = socialMediaTypeService;
    }

    @Override
    public DataResult<List<SocialMediaTypeEntity>> getAll() {
        return socialMediaTypeService.getAll();
    }

    @Override
    public DataResult<List<SocialMediaTypeEntity>> getAllSorted() {
        return socialMediaTypeService.getAllSorted();
    }

    @Override
    public DataResult<List<SocialMediaTypeEntity>> getList(int pageNo, int pageSize) {
        return socialMediaTypeService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<SocialMediaTypeEntity> save(SocialMediaTypeEntity socialMediaTypeEntity) {
        return socialMediaTypeService.save(socialMediaTypeEntity);
    }

    @Override
    public DataResult<SocialMediaTypeEntity> update(SocialMediaTypeEntity socialMediaTypeEntity) {
        return socialMediaTypeService.update(socialMediaTypeEntity);
    }

    @Override
    public Result delete(Long id) {
        return socialMediaTypeService.delete(id);
    }
}
