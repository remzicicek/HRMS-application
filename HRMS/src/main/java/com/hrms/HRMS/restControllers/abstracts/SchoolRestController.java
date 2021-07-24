package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SchoolEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/school")
public interface SchoolRestController {

    @GetMapping("/getall")
    DataResult<List<SchoolEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<SchoolEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<SchoolEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<SchoolEntity> save(@Valid @NotNull @RequestBody SchoolEntity schoolEntity);

    @PutMapping("/update")
    DataResult<SchoolEntity> update(@Valid @NotNull @RequestBody SchoolEntity schoolEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
