package com.hrms.HRMS.restControllers.concretes;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import com.hrms.HRMS.restControllers.abstracts.CityRestController;
import com.hrms.HRMS.services.abstracts.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestControllerImpl implements CityRestController {

    private CityService cityService;

    @Autowired
    public CityRestControllerImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public DataResult<List<CityEntity>> getAll() {
        return cityService.getAll();
    }

    @Override
    public DataResult<List<CityEntity>> getAllSorted() {
        return cityService.getAllSorted();
    }

    @Override
    public DataResult<List<CityEntity>> getList(int pageNo, int pageSize) {
        return cityService.getList(pageNo, pageSize);
    }

    @Override
    public DataResult<CityEntity> save(CityEntity cityEntity) {
        return cityService.save(cityEntity);
    }

    @Override
    public DataResult<CityEntity> update(CityEntity cityEntity) {
        return cityService.update(cityEntity);
    }

    @Override
    public Result delete(Long id) {
        return cityService.delete(id);
    }
}
