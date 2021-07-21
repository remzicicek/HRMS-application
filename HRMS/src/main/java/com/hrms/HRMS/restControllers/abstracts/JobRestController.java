package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.entities.concretes.JobEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/job")
public interface JobRestController {

    @GetMapping("/getall")
    DataResult<List<JobEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<JobEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<JobEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<JobEntity> save(@Valid @NotNull @RequestBody JobEntity jobEntity);

    @PutMapping("/update")
    DataResult<JobEntity> update(@Valid @NotNull @RequestBody JobEntity jobEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
