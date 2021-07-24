package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.TechnologyTypeEntity;
import com.hrms.HRMS.restControllers.abstracts.TechnologyTypeRestController;
import com.hrms.HRMS.services.abstracts.TechnologyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnologyTypeRestControllerImpl implements TechnologyTypeRestController {
    
    private final TechnologyTypeService technologyTypeService;

    @Autowired
    public TechnologyTypeRestControllerImpl(TechnologyTypeService technologyTypeService) {
        this.technologyTypeService = technologyTypeService;
    }

    @Override
    public DataResult<List<TechnologyTypeEntity>> getAll() {
        return technologyTypeService.getAll();
    }

    @Override
    public DataResult<List<TechnologyTypeEntity>> getAllSorted() {
        return technologyTypeService.getAllSorted();
    }

    @Override
    public DataResult<List<TechnologyTypeEntity>> getList(int pageNo, int pageSize) {
        return technologyTypeService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<TechnologyTypeEntity> save(TechnologyTypeEntity technologyTypeEntity) {
        return technologyTypeService.save(technologyTypeEntity);
    }

    @Override
    public DataResult<TechnologyTypeEntity> update(TechnologyTypeEntity technologyTypeEntity) {
        return technologyTypeService.update(technologyTypeEntity);
    }

    @Override
    public Result delete(Long id) {
        return technologyTypeService.delete(id);
    }
}
