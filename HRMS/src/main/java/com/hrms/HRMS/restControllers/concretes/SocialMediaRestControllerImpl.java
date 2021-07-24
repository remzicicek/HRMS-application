package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaEntity;
import com.hrms.HRMS.restControllers.abstracts.SocialMediaRestController;
import com.hrms.HRMS.services.abstracts.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialMediaRestControllerImpl implements SocialMediaRestController {
    
    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaRestControllerImpl(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @Override
    public DataResult<List<SocialMediaEntity>> getAll() {
        return socialMediaService.getAll();
    }

    @Override
    public DataResult<List<SocialMediaEntity>> getAllSorted() {
        return socialMediaService.getAllSorted();
    }

    @Override
    public DataResult<List<SocialMediaEntity>> getList(int pageNo, int pageSize) {
        return socialMediaService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<SocialMediaEntity> save(SocialMediaEntity socialMediaEntity) {
        return socialMediaService.save(socialMediaEntity);
    }

    @Override
    public DataResult<SocialMediaEntity> update(SocialMediaEntity socialMediaEntity) {
        return socialMediaService.update(socialMediaEntity);
    }

    @Override
    public Result delete(Long id) {
        return socialMediaService.delete(id);
    }
}
