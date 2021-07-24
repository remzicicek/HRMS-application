package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EducationEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/education")
public interface EducationRestController {

    @GetMapping("/getall")
    DataResult<List<EducationEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<EducationEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<EducationEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<EducationEntity> save(@Valid @NotNull @RequestBody EducationEntity educationEntity);

    @PutMapping("/update")
    DataResult<EducationEntity> update(@Valid @NotNull @RequestBody EducationEntity educationEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
