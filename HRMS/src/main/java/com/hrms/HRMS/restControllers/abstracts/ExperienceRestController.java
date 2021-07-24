package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.ExperienceEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/experience")
public interface ExperienceRestController {

    @GetMapping("/getall")
    DataResult<List<ExperienceEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<ExperienceEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<ExperienceEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<ExperienceEntity> save(@Valid @NotNull @RequestBody ExperienceEntity experienceEntity);

    @PutMapping("/update")
    DataResult<ExperienceEntity> update(@Valid @NotNull @RequestBody ExperienceEntity experienceEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
