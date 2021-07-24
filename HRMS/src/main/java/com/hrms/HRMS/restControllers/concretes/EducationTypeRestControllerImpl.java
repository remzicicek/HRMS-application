package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.entities.concretes.EducationTypeEntity;
import com.hrms.HRMS.restControllers.abstracts.EducationTypeRestController;
import com.hrms.HRMS.services.abstracts.EducationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EducationTypeRestControllerImpl implements EducationTypeRestController {
    
    private final EducationTypeService educationTypeService;

    @Autowired
    public EducationTypeRestControllerImpl(EducationTypeService educationTypeService) {
        this.educationTypeService = educationTypeService;
    }

    @Override
    public DataResult<List<EducationTypeEntity>> getAll() {
        return educationTypeService.getAll();
    }

    @Override
    public DataResult<List<EducationTypeEntity>> getAllSorted() {
        return educationTypeService.getAllSorted();
    }

    @Override
    public DataResult<List<EducationTypeEntity>> getList(int pageNo, int pageSize) {
        return educationTypeService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<EducationTypeEntity> save(EducationTypeEntity educationTypeEntity) {
        return educationTypeService.save(educationTypeEntity);
    }

    @Override
    public DataResult<EducationTypeEntity> update(EducationTypeEntity educationTypeEntity) {
        return educationTypeService.update(educationTypeEntity);
    }

    @Override
    public Result delete(Long id) {
        return educationTypeService.delete(id);
    }
}
