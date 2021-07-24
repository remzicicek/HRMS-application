package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SchoolTypeEntity;
import com.hrms.HRMS.restControllers.abstracts.SchoolTypeRestController;
import com.hrms.HRMS.services.abstracts.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolTypeRestControllerImpl implements SchoolTypeRestController {
    
    private final SchoolTypeService schoolTypeService;

    @Autowired
    public SchoolTypeRestControllerImpl(SchoolTypeService schoolTypeService) {
        this.schoolTypeService = schoolTypeService;
    }

    @Override
    public DataResult<List<SchoolTypeEntity>> getAll() {
        return schoolTypeService.getAll();
    }

    @Override
    public DataResult<List<SchoolTypeEntity>> getAllSorted() {
        return schoolTypeService.getAllSorted();
    }

    @Override
    public DataResult<List<SchoolTypeEntity>> getList(int pageNo, int pageSize) {
        return schoolTypeService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<SchoolTypeEntity> save(SchoolTypeEntity schoolTypeEntity) {
        return schoolTypeService.save(schoolTypeEntity);
    }

    @Override
    public DataResult<SchoolTypeEntity> update(SchoolTypeEntity schoolTypeEntity) {
        return schoolTypeService.update(schoolTypeEntity);
    }

    @Override
    public Result delete(Long id) {
        return schoolTypeService.delete(id);
    }
}
