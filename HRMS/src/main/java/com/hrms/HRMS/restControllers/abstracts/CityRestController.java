package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CityEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/city")
public interface CityRestController {

    @GetMapping("/getall")
    DataResult<List<CityEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<CityEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<CityEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<CityEntity> save(@Valid @NotNull @RequestBody CityEntity cityEntity);

    @PutMapping("/update")
    DataResult<CityEntity> update(@Valid @NotNull @RequestBody CityEntity cityEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
