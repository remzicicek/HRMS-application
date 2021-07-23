package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.JobAdvertisementEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/job-advertisement")
public interface JobAdvertisementRestController {

    @GetMapping("/getall")
    DataResult<List<JobAdvertisementEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<JobAdvertisementEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<JobAdvertisementEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<JobAdvertisementEntity> save(@Valid @NotNull @RequestBody JobAdvertisementEntity jobAdvertisementEntity);

    @PutMapping("/update")
    DataResult<JobAdvertisementEntity> update(@Valid @NotNull @RequestBody JobAdvertisementEntity jobAdvertisementEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
