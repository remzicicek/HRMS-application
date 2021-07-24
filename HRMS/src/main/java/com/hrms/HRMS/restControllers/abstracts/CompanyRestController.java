package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/company")
public interface CompanyRestController {

    @GetMapping("/getall")
    DataResult<List<CompanyEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<CompanyEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<CompanyEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<CompanyEntity> save(@Valid @NotNull @RequestBody CompanyEntity companyEntity);

    @PutMapping("/update")
    DataResult<CompanyEntity> update(@Valid @NotNull @RequestBody CompanyEntity companyEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
