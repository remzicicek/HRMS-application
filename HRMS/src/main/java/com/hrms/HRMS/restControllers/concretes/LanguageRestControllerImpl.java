package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.LanguageEntity;
import com.hrms.HRMS.restControllers.abstracts.LanguageRestController;
import com.hrms.HRMS.services.abstracts.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageRestControllerImpl implements LanguageRestController {
    
    private final LanguageService languageService;

    @Autowired
    public LanguageRestControllerImpl(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public DataResult<List<LanguageEntity>> getAll() {
        return languageService.getAll();
    }

    @Override
    public DataResult<List<LanguageEntity>> getAllSorted() {
        return languageService.getAllSorted();
    }

    @Override
    public DataResult<List<LanguageEntity>> getList(int pageNo, int pageSize) {
        return languageService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<LanguageEntity> save(LanguageEntity languageEntity) {
        return languageService.save(languageEntity);
    }

    @Override
    public DataResult<LanguageEntity> update(LanguageEntity languageEntity) {
        return languageService.update(languageEntity);
    }

    @Override
    public Result delete(Long id) {
        return languageService.delete(id);
    }
}
