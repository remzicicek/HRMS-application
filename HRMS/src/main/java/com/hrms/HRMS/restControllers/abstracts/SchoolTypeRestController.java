package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SchoolTypeEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/school-type")
public interface SchoolTypeRestController {

    @GetMapping("/getall")
    DataResult<List<SchoolTypeEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<SchoolTypeEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<SchoolTypeEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<SchoolTypeEntity> save(@Valid @NotNull @RequestBody SchoolTypeEntity schoolTypeEntity);

    @PutMapping("/update")
    DataResult<SchoolTypeEntity> update(@Valid @NotNull @RequestBody SchoolTypeEntity schoolTypeEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
