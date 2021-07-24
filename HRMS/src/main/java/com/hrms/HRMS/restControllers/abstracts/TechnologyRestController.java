package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.TechnologyEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/technology")
public interface TechnologyRestController {

    @GetMapping("/getall")
    DataResult<List<TechnologyEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<TechnologyEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<TechnologyEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<TechnologyEntity> save(@Valid @NotNull @RequestBody TechnologyEntity technologyEntity);

    @PutMapping("/update")
    DataResult<TechnologyEntity> update(@Valid @NotNull @RequestBody TechnologyEntity technologyEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
