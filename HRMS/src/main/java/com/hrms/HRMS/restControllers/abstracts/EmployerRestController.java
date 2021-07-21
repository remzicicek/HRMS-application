package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.entities.concretes.EmployerEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/employers")
public interface EmployerRestController {

    @GetMapping("/getall")
    DataResult<List<EmployerEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<EmployerEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<EmployerEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<EmployerEntity> save(@Valid @NotNull @RequestBody EmployerEntity employerEntity);

    @PutMapping("/update")
    DataResult<EmployerEntity> update(@Valid @NotNull @RequestBody EmployerEntity employerEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
