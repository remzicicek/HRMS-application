package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.TechnologyEntity;
import com.hrms.HRMS.restControllers.abstracts.TechnologyRestController;
import com.hrms.HRMS.services.abstracts.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnologyRestControllerImpl implements TechnologyRestController {
    
    private final TechnologyService technologyService;

    @Autowired
    public TechnologyRestControllerImpl(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Override
    public DataResult<List<TechnologyEntity>> getAll() {
        return technologyService.getAll();
    }

    @Override
    public DataResult<List<TechnologyEntity>> getAllSorted() {
        return technologyService.getAllSorted();
    }

    @Override
    public DataResult<List<TechnologyEntity>> getList(int pageNo, int pageSize) {
        return technologyService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<TechnologyEntity> save(TechnologyEntity technologyEntity) {
        return technologyService.save(technologyEntity);
    }

    @Override
    public DataResult<TechnologyEntity> update(TechnologyEntity technologyEntity) {
        return technologyService.update(technologyEntity);
    }

    @Override
    public Result delete(Long id) {
        return technologyService.delete(id);
    }
}
