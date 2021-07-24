package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.restControllers.abstracts.CompanyRestController;
import com.hrms.HRMS.services.abstracts.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyRestControllerImpl implements CompanyRestController {
    
    private final CompanyService companyService;

    @Autowired
    public CompanyRestControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public DataResult<List<CompanyEntity>> getAll() {
        return companyService.getAll();
    }

    @Override
    public DataResult<List<CompanyEntity>> getAllSorted() {
        return companyService.getAllSorted();
    }

    @Override
    public DataResult<List<CompanyEntity>> getList(int pageNo, int pageSize) {
        return companyService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<CompanyEntity> save(CompanyEntity companyEntity) {
        return companyService.save(companyEntity);
    }

    @Override
    public DataResult<CompanyEntity> update(CompanyEntity companyEntity) {
        return companyService.update(companyEntity);
    }

    @Override
    public Result delete(Long id) {
        return companyService.delete(id);
    }
}
