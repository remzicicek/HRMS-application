package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.entities.concretes.EmployerEntity;
import com.hrms.HRMS.restControllers.abstracts.EmployerRestController;
import com.hrms.HRMS.services.abstracts.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployerRestControllerImpl implements EmployerRestController {

    private EmployerService employerService;

    @Autowired
    public EmployerRestControllerImpl(EmployerService employerService) {
        this.employerService = employerService;
    }

    @Override
    public DataResult<List<EmployerEntity>> getAll() {
        return employerService.getAll();
    }

    @Override
    public DataResult<List<EmployerEntity>> getAllSorted() {
        return employerService.getAllSorted();
    }

    @Override
    public DataResult<List<EmployerEntity>> getList(int pageNo, int pageSize) {
        return employerService.getList(pageNo,pageSize);
    }

    @Override
    public DataResult<EmployerEntity> save(EmployerEntity employerEntity) {
        return employerService.save(employerEntity);
    }

    @Override
    public DataResult<EmployerEntity> update(EmployerEntity employerEntity) {
        return employerService.update(employerEntity);
    }

    @Override
    public Result delete(Long id) {
        return employerService.delete(id);
    }
}
