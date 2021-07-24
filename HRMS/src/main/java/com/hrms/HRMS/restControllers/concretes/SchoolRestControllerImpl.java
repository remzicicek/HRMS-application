package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SchoolEntity;
import com.hrms.HRMS.restControllers.abstracts.SchoolRestController;
import com.hrms.HRMS.services.abstracts.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolRestControllerImpl implements SchoolRestController {
    
    private final SchoolService schoolService;

    @Autowired
    public SchoolRestControllerImpl(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @Override
    public DataResult<List<SchoolEntity>> getAll() {
        return schoolService.getAll();
    }

    @Override
    public DataResult<List<SchoolEntity>> getAllSorted() {
        return schoolService.getAllSorted();
    }

    @Override
    public DataResult<List<SchoolEntity>> getList(int pageNo, int pageSize) {
        return schoolService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<SchoolEntity> save(SchoolEntity schoolEntity) {
        return schoolService.save(schoolEntity);
    }

    @Override
    public DataResult<SchoolEntity> update(SchoolEntity schoolEntity) {
        return schoolService.update(schoolEntity);
    }

    @Override
    public Result delete(Long id) {
        return schoolService.delete(id);
    }
}
