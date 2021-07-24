package com.hrms.HRMS.restControllers.abstracts;


import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.TechnologyTypeEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/technology-type")
public interface TechnologyTypeRestController {

    @GetMapping("/getall")
    DataResult<List<TechnologyTypeEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<TechnologyTypeEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<TechnologyTypeEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<TechnologyTypeEntity> save(@Valid @NotNull @RequestBody TechnologyTypeEntity technologyTypeEntity);

    @PutMapping("/update")
    DataResult<TechnologyTypeEntity> update(@Valid @NotNull @RequestBody TechnologyTypeEntity technologyTypeEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
