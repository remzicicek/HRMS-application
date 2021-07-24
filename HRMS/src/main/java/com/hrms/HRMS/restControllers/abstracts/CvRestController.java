package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CvEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/cv")
public interface CvRestController {

    @GetMapping("/getall")
    DataResult<List<CvEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<CvEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<CvEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<CvEntity> save(@Valid @NotNull @RequestBody CvEntity cvEntity);

    @PutMapping("/update")
    DataResult<CvEntity> update(@Valid @NotNull @RequestBody CvEntity cvEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
