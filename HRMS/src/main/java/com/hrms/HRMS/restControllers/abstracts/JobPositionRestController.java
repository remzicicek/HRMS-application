package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobPositionEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/job-position")
public interface JobPositionRestController {

    @GetMapping("/getall")
    DataResult<List<JobPositionEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<JobPositionEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<JobPositionEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<JobPositionEntity> save(@Valid @NotNull @RequestBody JobPositionEntity jobPositionEntity);

    @PutMapping("/update")
    DataResult<JobPositionEntity> update(@Valid @NotNull @RequestBody JobPositionEntity jobPositionEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
