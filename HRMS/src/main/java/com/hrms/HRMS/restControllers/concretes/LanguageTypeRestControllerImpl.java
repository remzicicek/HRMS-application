package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.LanguageTypeEntity;
import com.hrms.HRMS.restControllers.abstracts.LanguageTypeRestController;
import com.hrms.HRMS.services.abstracts.LanguageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageTypeRestControllerImpl implements LanguageTypeRestController {
    
    private final LanguageTypeService languageTypeService;

    @Autowired
    public LanguageTypeRestControllerImpl(LanguageTypeService languageTypeService) {
        this.languageTypeService = languageTypeService;
    }

    @Override
    public DataResult<List<LanguageTypeEntity>> getAll() {
        return languageTypeService.getAll();
    }

    @Override
    public DataResult<List<LanguageTypeEntity>> getAllSorted() {
        return languageTypeService.getAllSorted();
    }

    @Override
    public DataResult<List<LanguageTypeEntity>> getList(int pageNo, int pageSize) {
        return languageTypeService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<LanguageTypeEntity> save(LanguageTypeEntity languageTypeEntity) {
        return languageTypeService.save(languageTypeEntity);
    }

    @Override
    public DataResult<LanguageTypeEntity> update(LanguageTypeEntity languageTypeEntity) {
        return languageTypeService.update(languageTypeEntity);
    }

    @Override
    public Result delete(Long id) {
        return languageTypeService.delete(id);
    }
}
