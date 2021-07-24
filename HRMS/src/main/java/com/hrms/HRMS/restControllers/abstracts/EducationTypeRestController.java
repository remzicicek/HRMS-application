package com.hrms.HRMS.restControllers.abstracts;


import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EducationTypeEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/education-type")
public interface EducationTypeRestController {

    @GetMapping("/getall")
    DataResult<List<EducationTypeEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<EducationTypeEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<EducationTypeEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<EducationTypeEntity> save(@Valid @NotNull @RequestBody EducationTypeEntity educationTypeEntity);

    @PutMapping("/update")
    DataResult<EducationTypeEntity> update(@Valid @NotNull @RequestBody EducationTypeEntity educationTypeEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
