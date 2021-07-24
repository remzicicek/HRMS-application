package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.ExperienceEntity;
import com.hrms.HRMS.restControllers.abstracts.ExperienceRestController;
import com.hrms.HRMS.services.abstracts.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExperienceRestControllerImpl implements ExperienceRestController {
    
    private final ExperienceService experienceService;

    @Autowired
    public ExperienceRestControllerImpl(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @Override
    public DataResult<List<ExperienceEntity>> getAll() {
        return experienceService.getAll();
    }

    @Override
    public DataResult<List<ExperienceEntity>> getAllSorted() {
        return experienceService.getAllSorted();
    }

    @Override
    public DataResult<List<ExperienceEntity>> getList(int pageNo, int pageSize) {
        return experienceService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<ExperienceEntity> save(ExperienceEntity experienceEntity) {
        return experienceService.save(experienceEntity);
    }

    @Override
    public DataResult<ExperienceEntity> update(ExperienceEntity experienceEntity) {
        return experienceService.update(experienceEntity);
    }

    @Override
    public Result delete(Long id) {
        return experienceService.delete(id);
    }
}
