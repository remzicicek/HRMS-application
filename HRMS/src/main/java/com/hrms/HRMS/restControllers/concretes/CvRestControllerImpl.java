package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CvEntity;
import com.hrms.HRMS.restControllers.abstracts.CvRestController;
import com.hrms.HRMS.services.abstracts.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CvRestControllerImpl implements CvRestController {
    
    private final CvService cvService;

    @Autowired
    public CvRestControllerImpl(CvService cvService) {
        this.cvService = cvService;
    }

    @Override
    public DataResult<List<CvEntity>> getAll() {
        return cvService.getAll();
    }

    @Override
    public DataResult<List<CvEntity>> getAllSorted() {
        return cvService.getAllSorted();
    }

    @Override
    public DataResult<List<CvEntity>> getList(int pageNo, int pageSize) {
        return cvService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<CvEntity> save(CvEntity cvEntity) {
        return cvService.save(cvEntity);
    }

    @Override
    public DataResult<CvEntity> update(CvEntity cvEntity) {
        return cvService.update(cvEntity);
    }

    @Override
    public Result delete(Long id) {
        return cvService.delete(id);
    }
}
