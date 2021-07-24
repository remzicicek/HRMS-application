package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.EducationEntity;
import com.hrms.HRMS.restControllers.abstracts.EducationRestController;
import com.hrms.HRMS.services.abstracts.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EducationRestControllerImpl implements EducationRestController {
    
    private final EducationService educationService;

    @Autowired
    public EducationRestControllerImpl(EducationService educationService) {
        this.educationService = educationService;
    }

    @Override
    public DataResult<List<EducationEntity>> getAll() {
        return educationService.getAll();
    }

    @Override
    public DataResult<List<EducationEntity>> getAllSorted() {
        return educationService.getAllSorted();
    }

    @Override
    public DataResult<List<EducationEntity>> getList(int pageNo, int pageSize) {
        return educationService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<EducationEntity> save(EducationEntity educationEntity) {
        return educationService.save(educationEntity);
    }

    @Override
    public DataResult<EducationEntity> update(EducationEntity educationEntity) {
        return educationService.update(educationEntity);
    }

    @Override
    public Result delete(Long id) {
        return educationService.delete(id);
    }
}
